package com.example.pruebatecnica.pablomediero.core.ui.uistates

sealed class UIState<out T> {
    data object Loading: UIState<Nothing>()
    data class Success<out T>(val data: T? = null) : UIState<T>()
    data class Error(val exception: Throwable) : UIState<Nothing>()
}