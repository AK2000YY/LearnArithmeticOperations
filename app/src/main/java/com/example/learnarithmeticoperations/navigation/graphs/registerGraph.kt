package com.example.learnarithmeticoperations.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.learnarithmeticoperations.core.Constants.LOGIN
import com.example.learnarithmeticoperations.core.Constants.LOGIN_OR_SIGNUP
import com.example.learnarithmeticoperations.core.Constants.REGISTER_ROUTE
import com.example.learnarithmeticoperations.core.Constants.SIGNUP
import com.example.learnarithmeticoperations.core.Constants.WELCOME_SCREEN


fun NavGraphBuilder.registerGraph(
    navController: NavHostController
) {
    navigation(
        route = REGISTER_ROUTE,
        startDestination = WELCOME_SCREEN
    ) {
        composable(route = WELCOME_SCREEN) {

        }
        composable(route = LOGIN_OR_SIGNUP) {

        }
        composable(route = LOGIN) {

        }
        composable(route = SIGNUP) {

        }
    }
}