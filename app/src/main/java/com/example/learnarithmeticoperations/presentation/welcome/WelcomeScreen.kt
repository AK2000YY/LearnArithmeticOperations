package com.example.learnarithmeticoperations.presentation.welcome

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.learnarithmeticoperations.response.Response

@Composable
fun WelcomeScreen(
    navToSignupOrLogin: () -> Unit,
    navToMyApp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: WelcomeViewModel = hiltViewModel()
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Welcome",
            style = MaterialTheme.typography.titleLarge,
            fontSize = 40.sp
        )
    }

    when(viewModel.welcomeStatus) {
        Response.Success(true) -> navToMyApp()
        Response.Failure("No User") -> navToSignupOrLogin()
        else -> {}
    }

}