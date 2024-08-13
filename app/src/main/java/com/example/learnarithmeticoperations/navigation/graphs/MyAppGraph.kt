package com.example.learnarithmeticoperations.navigation.graphs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation

fun NavGraphBuilder.myAppGraph() {
    navigation(
        route = "test",
        startDestination = "test1"
    ) {
        composable("test1") {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
               Text(
                   text = "Test Complete",
                   style = MaterialTheme.typography.bodyLarge,
                   fontSize = 40.sp
               )
            }
        }
    }
}