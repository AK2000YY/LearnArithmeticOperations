package com.example.learnarithmeticoperations.navigation.graphs

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.example.learnarithmeticoperations.core.Constants.REGISTER_ROUTE
import com.example.learnarithmeticoperations.core.Constants.SEND_OR_NOT
import com.example.learnarithmeticoperations.core.Constants.WELCOME_SCREEN
import com.example.learnarithmeticoperations.navigation.Screen.VerificationScreen
import com.example.learnarithmeticoperations.navigation.Screen.WelcomeScreen
import com.example.learnarithmeticoperations.navigation.Screen.LoginOrSignupScreen
import com.example.learnarithmeticoperations.presentation.signupOrLogin.LoginOrSignupScreen
import com.example.learnarithmeticoperations.presentation.verification.VerificationScreen
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
                    navController.navigate(LoginOrSignupScreen.route)
                },
                {
                    navController.popBackStack()
                    navController.navigate("test")
                },
                {
                    navController.popBackStack()
                    navController.navigate(VerificationScreen.send())
                },
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        composable(route = LoginOrSignupScreen.route) {
            LoginOrSignupScreen(
                modifier = Modifier
                    .fillMaxSize(),
                {
                    navController.popBackStack()
                    navController.navigate("test")
                },
                {
                    navController.popBackStack()
                },
                {
                    navController.popBackStack()
                    navController.navigate(VerificationScreen.send("send"))
                }
            )
        }
        composable(
            route = VerificationScreen.route,
            arguments = listOf(
                navArgument(SEND_OR_NOT) {
                    type = NavType.StringType
                }
            )
        ) {
            VerificationScreen(
                modifier = Modifier
                    .fillMaxSize(),
                {
                    navController.popBackStack()
                    navController.navigate("test")
                },
                sendOrNot = it.arguments?.getString(SEND_OR_NOT)!!
            )
        }
    }
}