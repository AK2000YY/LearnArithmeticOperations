package com.example.learnarithmeticoperations.presentation.signupOrLogin

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.learnarithmeticoperations.presentation.signupOrLogin.compoonent.LoginORSignup
import com.example.learnarithmeticoperations.presentation.signupOrLogin.compoonent.ProgressBar
import com.example.learnarithmeticoperations.response.Response

@Composable
fun LoginOrSignupScreen(
    modifier: Modifier = Modifier,
    toMyApp: () -> Unit,
    closeApp: () -> Unit,
    viewModel: LoginOrSignupViewModel = hiltViewModel()
) {
    Scaffold(
        modifier = modifier
    ) { padding ->
        LoginORSignup(
            modifier = modifier
                .padding(padding),
            choosePart = viewModel.choosePart,
            toSignup = { viewModel.toSignup() },
            toLogin = { viewModel.toLogin() },
            toLoginOrSignup = { viewModel.toLoginOrSignupPart() },
            toCloseApp = { closeApp() }
        )
    }
    when(val loginOrSignupResponse = viewModel.loginOrSignupResponse) {
        is Response.Loading ->
            if (loginOrSignupResponse.t) ProgressBar()
        is Response.Failure -> loginOrSignupResponse.apply {
            viewModel.showToast(LocalContext.current, e)
        }
        is Response.Success -> loginOrSignupResponse.apply {
            toMyApp()
        }
    }
}