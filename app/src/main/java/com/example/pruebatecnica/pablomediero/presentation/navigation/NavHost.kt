package com.example.pruebatecnica.pablomediero.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pruebatecnica.pablomediero.presentation.ui.screens.DetailScreen
import com.example.pruebatecnica.pablomediero.presentation.ui.screens.HomeScreen
import com.example.pruebatecnica.pablomediero.presentation.viewmodels.UserViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun AppNavHost(){
    val navController = rememberNavController()
    val userViewModel: UserViewModel = koinViewModel()

    NavHost(
        navController = navController,
        startDestination = AppRoutes.HomeScreen.route
    ){
        composable(
            route = AppRoutes.HomeScreen.route
        ) {
            HomeScreen(navController = navController, userViewModel)
        }
        composable(
            route = "${AppRoutes.DetailScreen.route}/{email}",
            arguments = listOf(navArgument("email") { type = NavType.StringType })
        ) { backStackEntry ->
            val email = backStackEntry.arguments?.getString("email")
            DetailScreen(navController = navController, email = email, userViewModel)
        }
    }
}