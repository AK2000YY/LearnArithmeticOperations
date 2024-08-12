package com.example.learnarithmeticoperations.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.firebase.auth.FirebaseAuth

@Composable
fun NavSetup(
    auth: FirebaseAuth,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "first"
    ) {
        composable("first") {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                var name by remember { mutableStateOf("") }
                Text(
                    text = name,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 35.sp,
                )
                Text(
                    text = "sign up",
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 35.sp,
                    modifier = Modifier
                        .clickable {
                            try {
                                auth.createUserWithEmailAndPassword("abdulkarim@gmail.com", "123456789")
                                name = "abdulkarim"
                            }catch(e: Exception) {
                                println(e)
                            }
                        }
                )
            }
        }
    }
}