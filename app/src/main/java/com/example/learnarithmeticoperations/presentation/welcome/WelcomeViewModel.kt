package com.example.learnarithmeticoperations.presentation.welcome

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learnarithmeticoperations.repository.AuthRepository
import com.example.learnarithmeticoperations.response.Response
import com.example.learnarithmeticoperations.response.Response.Loading
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val repo: AuthRepository
): ViewModel() {

    var welcomeStatus by mutableStateOf<Response>(Loading(false))
        private set

    init {
        getAuthState()
    }

    private fun getAuthState() = viewModelScope.launch {
        welcomeStatus = repo.getAuthState()
    }
}