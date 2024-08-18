package com.example.learnarithmeticoperations.presentation.welcome

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.learnarithmeticoperations.presentation.welcome.component.Welcome
import com.example.learnarithmeticoperations.response.Response
import kotlinx.coroutines.delay

@Composable
fun WelcomeScreen(
    navToSignupOrLogin: () -> Unit,
    navToMyApp: () -> Unit,
    navToVerification: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: WelcomeViewModel = hiltViewModel()
) {

    Scaffold(
        modifier = modifier
    ) { padding ->
        Welcome(
            paddingValues = padding
        )
    }

    LaunchedEffect(true) {
        delay(2000)
        when(viewModel.welcomeStatus) {
            Response.Success -> navToMyApp()
            Response.Failure("No User") -> navToSignupOrLogin()
            Response.Loading(true) -> navToVerification()
            else -> {}
        }
    }

}