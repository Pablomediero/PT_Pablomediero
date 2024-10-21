package com.example.pruebatecnica.pablomediero.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnica.pablomediero.core.ui.uistates.UIState
import com.example.pruebatecnica.pablomediero.data.models.ApiResponse
import com.example.pruebatecnica.pablomediero.domain.usecases.GetUsersDataUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class UserViewModel(
    private val getUsersDataUseCase: GetUsersDataUseCase
): ViewModel() {
    private val _usersFlow = MutableStateFlow<UIState<ApiResponse>>(UIState.Loading)
    val usersFlow: MutableStateFlow<UIState<ApiResponse>> = _usersFlow

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
}