package com.example.pruebatecnica.pablomediero.presentation.navigation

sealed class AppRoutes(val route: String) {
    data object HomeScreen: AppRoutes("HomeScreen")
    data object DetailScreen: AppRoutes("DetailScreen")
}