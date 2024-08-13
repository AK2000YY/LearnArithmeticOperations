package com.example.learnarithmeticoperations.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.learnarithmeticoperations.core.Constants.REGISTER_ROUTE
import com.example.learnarithmeticoperations.navigation.graphs.registerGraph

@Composable
fun NavSetup(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = REGISTER_ROUTE,
    ) {
        registerGraph(
            navController = navController
        )
    }
}