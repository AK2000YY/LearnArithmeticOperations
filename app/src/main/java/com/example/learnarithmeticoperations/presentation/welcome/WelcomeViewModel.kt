package com.example.learnarithmeticoperations.presentation.welcome

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.learnarithmeticoperations.repository.AuthRepository
import com.example.learnarithmeticoperations.response.Response
import com.example.learnarithmeticoperations.response.Response.Success
import com.example.learnarithmeticoperations.response.Response.Failure
import com.example.learnarithmeticoperations.response.Response.Loading
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val repo: AuthRepository
): ViewModel() {

    var welcomeStatus by mutableStateOf<Response<Boolean>>(Loading)
        private set

    init {
        if(repo.getAuthState()) welcomeStatus = Success(true)
        else Failure("No User")
    }

}