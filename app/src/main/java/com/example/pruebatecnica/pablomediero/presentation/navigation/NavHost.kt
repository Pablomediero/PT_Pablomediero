package com.example.pruebatecnica.pablomediero.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pruebatecnica.pablomediero.presentation.ui.screens.DetailScreen
import com.example.pruebatecnica.pablomediero.presentation.ui.screens.HomeScreen


@Composable
fun AppNavHost(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppRoutes.HomeScreen.route
    ){
        composable(
            route = AppRoutes.HomeScreen.route
        ) {
            HomeScreen()
        }
        composable(
            route = AppRoutes.DetailScreen.route
        ) {
            DetailScreen()
        }
    }
}