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

    fun toLoginOrSignupPart() {
        choosePart = ChoosePart.LoginOrSignup
    }

    fun toSignup() {
        choosePart = ChoosePart.Signup
    }

    fun toLogin() {
        choosePart = ChoosePart.Login
    }

    fun login(email: String, password: String) = viewModelScope.launch {
        loginOrSignupResponse = Response.Loading(true)
        loginOrSignupResponse = repo.login(email, password)
    }

    fun assertPassword(email: String, password: String, frequentPassword: String) {
        loginOrSignupResponse = Response.Loading(true)
        if(password == frequentPassword){
            signup(email, password)
        }else {
            loginOrSignupResponse = Response.Failure("passwords are not assert")
        }
    }

    private fun signup(email: String, password: String) = viewModelScope.launch {
        loginOrSignupResponse = repo.signUp(email, password)
    }

    fun showToast(
        context: Context,
        message: String
    ) {
        makeText(context, message, LENGTH_LONG).show()
    }
}

