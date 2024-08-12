package com.example.learnarithmeticoperations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.learnarithmeticoperations.navigation.NavSetup
import com.example.learnarithmeticoperations.ui.theme.LearnArithmeticOperationsTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        auth = Firebase.auth
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnArithmeticOperationsTheme {
                navController = rememberNavController()
                NavSetup(
                    auth = auth,
                    navController = navController
                )
            }
        }
    }
}
