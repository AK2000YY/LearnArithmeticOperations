package com.example.learnarithmeticoperations.navigation.graphs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

fun NavGraphBuilder.myAppGraph(
    navController: NavHostController
) {
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
                   text = Firebase.auth.currentUser?.displayName!!,
                   style = MaterialTheme.typography.bodyLarge,
                   fontSize = 40.sp
               )
            }
        }
    }
}