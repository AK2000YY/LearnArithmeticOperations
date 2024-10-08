package com.example.learnarithmeticoperations.presentation.signupOrLogin

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.learnarithmeticoperations.core.SharedMethod
import com.example.learnarithmeticoperations.presentation.signupOrLogin.compoonent.LoginORSignup
import com.example.learnarithmeticoperations.presentation.signupOrLogin.compoonent.ProgressBar
import com.example.learnarithmeticoperations.domain.model.Response

@Composable
fun LoginOrSignupScreen(
    modifier: Modifier = Modifier,
    toMyApp: () -> Unit,
    closeApp: () -> Unit,
    toVerifyScreen: () -> Unit,
    viewModel: LoginOrSignupViewModel = hiltViewModel()
) {
    Scaffold(
        modifier = modifier
    ) { padding ->
        LoginORSignup(
            modifier = modifier
                .padding(padding),
            choosePart = viewModel.choosePart,
            emailLogin = viewModel.emailLogin,
            emailSignup = viewModel.emailSignup,
            passwordLogin = viewModel.passwordLogin,
            passwordSignup = viewModel.passwordSignup,
            confirmPassword = viewModel.confirmPassword,
            toSignup = { viewModel.toSignup() },
            toLogin = { viewModel.toLogin() },
            toLoginOrSignup = { viewModel.toLoginOrSignupPart() },
            toCloseApp = { closeApp() },
            login = { viewModel.login() },
            signup = { viewModel.signup() },
            editEmailLogin = { viewModel.editEmailLogin(it) },
            editEmailSignup = { viewModel.editEmailSignup(it) },
            editPasswordLogin = { viewModel.editPasswordLogin(it) },
            editPasswordSignup = { viewModel.editPasswordSignup(it) },
            editConfirmPassword = { viewModel.editConfirmPassword(it) }
        )
    }

    when(val loginOrSignupResponse = viewModel.loginOrSignupResponse) {
        is Response.Loading ->
            if (loginOrSignupResponse.t) ProgressBar(
                modifier = Modifier
                    .fillMaxSize()
            )
        is Response.Failure -> loginOrSignupResponse.apply {
            SharedMethod.showToast(LocalContext.current, loginOrSignupResponse.e)
        }
        is Response.Success<*> -> loginOrSignupResponse.apply {
            if(viewModel.methodType == "login")
                toMyApp()
            else toVerifyScreen()
        }
    }
}