package com.example.learnarithmeticoperations.navigation.graphs

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.learnarithmeticoperations.core.Constants.REGISTER_ROUTE
import com.example.learnarithmeticoperations.core.Constants.WELCOME_SCREEN
import com.example.learnarithmeticoperations.navigation.Screen.WelcomeScreen
import com.example.learnarithmeticoperations.navigation.Screen.LoginOrSignup
import com.example.learnarithmeticoperations.presentation.signupOrLogin.LoginOrSignupScreen
import com.example.learnarithmeticoperations.presentation.welcome.WelcomeScreen

fun NavGraphBuilder.registerGraph(
    navController: NavHostController
) {
    navigation(
        route = REGISTER_ROUTE,
        startDestination = WelcomeScreen.route
    ) {
        composable(route = WELCOME_SCREEN) {
            WelcomeScreen(
                {
                    navController.popBackStack()
                    navController.navigate(LoginOrSignup.route)
                },
                {
                    navController.popBackStack()
                    navController.navigate("test")
                },
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        composable(route = LoginOrSignup.route) {
            LoginOrSignupScreen(
                modifier = Modifier
                    .fillMaxSize(),
                {
                    navController.popBackStack()
                    navController.navigate("test")
                },
                {
                    navController.popBackStack()
                }
            )
        }
    }
}