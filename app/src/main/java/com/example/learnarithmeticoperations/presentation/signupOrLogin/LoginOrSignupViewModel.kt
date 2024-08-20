package com.example.learnarithmeticoperations.presentation.signupOrLogin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learnarithmeticoperations.repository.AuthRepository
import com.example.learnarithmeticoperations.response.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginOrSignupViewModel @Inject constructor(
    private val repo: AuthRepository
): ViewModel() {
    var loginOrSignupResponse by mutableStateOf<Response>(Response.Loading(false))
        private set

    var choosePart by mutableStateOf(ChoosePart.LoginOrSignup)
        private set

    var emailLogin by mutableStateOf("")
    fun editEmailLogin(value: String){ emailLogin = value }
    var emailSignup by mutableStateOf("")
    fun editEmailSignup(value: String){ emailSignup = value }
    var passwordLogin by mutableStateOf("")
    fun editPasswordLogin(value: String){ passwordLogin = value }
    var passwordSignup by mutableStateOf("")
    fun editPasswordSignup(value: String){ passwordSignup = value }
    var confirmPassword by mutableStateOf("")
    fun editConfirmPassword(value: String){ confirmPassword = value }
    var methodType by mutableStateOf("login")

    fun toLoginOrSignupPart() {
        choosePart = ChoosePart.LoginOrSignup
    }

    fun toSignup() {
        choosePart = ChoosePart.Signup
    }

    fun toLogin() {
        choosePart = ChoosePart.Login
    }

    fun login() = viewModelScope.launch {
        methodType = "login"
        loginOrSignupResponse = Response.Loading(true)
        loginOrSignupResponse = repo.login(emailLogin, passwordLogin)
    }

    fun signup() = viewModelScope.launch {
        methodType = "signup"
        loginOrSignupResponse = Response.Loading(true)
        loginOrSignupResponse = repo.signUp(emailSignup, passwordSignup, confirmPassword)
    }

}

