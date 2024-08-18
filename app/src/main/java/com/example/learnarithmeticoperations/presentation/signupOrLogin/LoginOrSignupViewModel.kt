package com.example.learnarithmeticoperations.presentation.signupOrLogin

import android.content.Context
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.makeText
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

    var userName by mutableStateOf("")
    fun editUserName(value: String){ userName = value }
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
        loginOrSignupResponse = Response.Loading(true)
        loginOrSignupResponse = repo.login(emailLogin, passwordLogin)
    }

    fun assertPassword() {
        loginOrSignupResponse = Response.Loading(true)
        if(passwordSignup == confirmPassword){
            signup(userName, emailSignup, passwordSignup)
        }else {
            loginOrSignupResponse = Response.Failure("passwords are not assert")
        }
    }

    private fun signup(userName: String, email: String, password: String) = viewModelScope.launch {
        loginOrSignupResponse = repo.signUp(userName, email, password)
    }

    fun showToast(
        context: Context,
        message: String
    ) {
        makeText(context, message, LENGTH_LONG).show()
    }
}

