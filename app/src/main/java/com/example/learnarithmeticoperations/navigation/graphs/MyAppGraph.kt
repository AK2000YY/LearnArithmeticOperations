package com.example.learnarithmeticoperations.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.learnarithmeticoperations.core.Constants.MY_APP_ROUTE
import com.example.learnarithmeticoperations.navigation.Screen
import com.example.learnarithmeticoperations.presentation.myApp.MyAppScreen

fun NavGraphBuilder.myAppGraph() {
    navigation(
        route = MY_APP_ROUTE,
        startDestination = Screen.NavigationBarScreen.route
    ) {
        composable(Screen.NavigationBarScreen.route) {
            MyAppScreen()
        }

    }
}