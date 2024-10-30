package com.example.pruebatecnica.pablomediero.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.pruebatecnica.pablomediero.core.ui.uistates.UIState
import com.example.pruebatecnica.pablomediero.data.models.User
import com.example.pruebatecnica.pablomediero.domain.usecases.GetUsersDataUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class UserViewModel(
    private val getUsersDataUseCase: GetUsersDataUseCase
) : ViewModel() {
    private val _usersFlow = MutableStateFlow<UIState<List<User>>>(UIState.Loading)
    val usersFlow: MutableStateFlow<UIState<List<User>>> = _usersFlow

    val usersPagingData: StateFlow<PagingData<User>> = getUsersDataUseCase()
        .cachedIn(viewModelScope)
        .stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())
    private val _user = MutableStateFlow<UIState<User>>(UIState.Loading)
    val user: StateFlow<UIState<User>> = _user

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    val filteredUsers: StateFlow<List<User>?> = searchQuery
        .combine(_usersFlow) { query, usersState ->
            when (usersState) {
                is UIState.Success -> {
                        usersState.data!!.filter { user ->
                        val fullName = "${user.name.first} ${user.name.last}".lowercase()
                        val email = user.email.lowercase()
                        query.lowercase() in fullName || query.lowercase() in email
                    }
                }
                else -> emptyList()
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = emptyList()
        )


    fun updateSearchQuery(query: String) {
        viewModelScope.launch {
            _searchQuery.emit(query)
        }
    }

    /*fun fetchRandomUsers() {
        viewModelScope.launch {
            _usersFlow.value = UIState.Loading
            getUsersDataUseCase().collect { result ->
                result.fold(
                    onSuccess = { _usersFlow.value = UIState.Success(it) },
                    onFailure = { _usersFlow.value = UIState.Error(it) }
                )
            }
        }
    }*/

    fun getUserDetail(userEmail: String) {
        viewModelScope.launch {
            val currentUsers = (_usersFlow.value as? UIState.Success)?.data
            val user = currentUsers?.find { it.email == userEmail }
            _user.value = if (user != null) {
                UIState.Success(user)
            } else {
                UIState.Error(Exception("Usuario no encontrado con el email: $userEmail"))
            }
        }
    }


}