package com.example.learnarithmeticoperations.navigation.graphs

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.learnarithmeticoperations.core.Constants.LOGIN
import com.example.learnarithmeticoperations.core.Constants.LOGIN_OR_SIGNUP
import com.example.learnarithmeticoperations.core.Constants.REGISTER_ROUTE
import com.example.learnarithmeticoperations.core.Constants.SIGNUP
import com.example.learnarithmeticoperations.core.Constants.WELCOME_SCREEN
import com.example.learnarithmeticoperations.presentation.welcome.WelcomeScreen

fun NavGraphBuilder.registerGraph(
    navController: NavHostController
) {
    navigation(
        route = REGISTER_ROUTE,
        startDestination = WELCOME_SCREEN
    ) {
        composable(route = WELCOME_SCREEN) {
            WelcomeScreen(
                {
                    navController.popBackStack()
                    navController.navigate(LOGIN_OR_SIGNUP)
                },
                {
                    navController.popBackStack()
                    navController.navigate("test")
                },
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        composable(route = LOGIN_OR_SIGNUP) {

        }
        composable(route = LOGIN) {

        }
        composable(route = SIGNUP) {

        }
    }
}