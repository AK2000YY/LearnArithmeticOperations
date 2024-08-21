package com.example.learnarithmeticoperations.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun BottomNavSetup(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.LearningMapScreen.route
    ) {
        composable(Screen.LearningMapScreen.route) {
            Box(
                modifier = modifier,
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Learning")
            }
        }
        composable(Screen.SavedQuestionScreen.route) {
            Box(
                modifier = modifier,
                contentAlignment = Alignment.Center
            ) {
                Text(text = "saved")
            }
        }
        composable(Screen.CompetitionScreen.route) {
            Box(
                modifier = modifier,
                contentAlignment = Alignment.Center
            ) {
                Text(text = "competition")
            }
        }
        composable(Screen.OrderScreen.route) {
            Box(
                modifier = modifier,
                contentAlignment = Alignment.Center
            ) {
                Text(text = "order")
            }
        }
        composable(Screen.ProfileScreen.route) {
            Box(
                modifier = modifier,
                contentAlignment = Alignment.Center
            ) {
                Text(text = "profile")
            }
        }
    }
}