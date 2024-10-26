package com.example.pruebatecnica.pablomediero.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnica.pablomediero.core.ui.uistates.UIState
import com.example.pruebatecnica.pablomediero.data.models.ApiResponse
import com.example.pruebatecnica.pablomediero.data.models.User
import com.example.pruebatecnica.pablomediero.domain.usecases.GetUsersDataUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class UserViewModel(
    private val getUsersDataUseCase: GetUsersDataUseCase
) : ViewModel() {
    private val _usersFlow = MutableStateFlow<UIState<ApiResponse>>(UIState.Loading)
    val usersFlow: MutableStateFlow<UIState<ApiResponse>> = _usersFlow
    private val _user = MutableStateFlow<UIState<User>>(UIState.Loading)
    val user: StateFlow<UIState<User>> = _user

    fun fetchRandomUsers() {
        viewModelScope.launch {
            _usersFlow.value = UIState.Loading
            getUsersDataUseCase().catch { exception ->
                _usersFlow.value = UIState.Error(exception)
            }.collect { result ->
                result.fold(
                    onSuccess = { _usersFlow.value = UIState.Success(it) },
                    onFailure = { _usersFlow.value = UIState.Error(it) }
                )
            }
        }
    }

    fun getUserDetail(userEmail: String) {
        viewModelScope.launch {
            val currentUsers = (_usersFlow.value as? UIState.Success)?.data?.results
            val user = currentUsers?.find { it.email == userEmail }
            _user.value = if (user != null) {
                UIState.Success(user)
            } else {
                UIState.Error(Exception("Usuario no encontrado con el email: $userEmail"))
            }
        }
    }


}