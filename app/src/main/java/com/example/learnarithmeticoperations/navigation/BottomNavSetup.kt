package com.example.learnarithmeticoperations.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.learnarithmeticoperations.presentation.competition.CompetitionScreen
import com.example.learnarithmeticoperations.presentation.learningMap.LearningMapScreen
import com.example.learnarithmeticoperations.presentation.order.OrderScreen
import com.example.learnarithmeticoperations.presentation.profile.ProfileScreen
import com.example.learnarithmeticoperations.presentation.savedQuestion.SavedQuestionScreen

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
            LearningMapScreen(
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        composable(Screen.SavedQuestionScreen.route) {
            SavedQuestionScreen(
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        composable(Screen.CompetitionScreen.route) {
            CompetitionScreen(
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        composable(Screen.OrderScreen.route) {
            OrderScreen(
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        composable(Screen.ProfileScreen.route) {
            ProfileScreen(
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}