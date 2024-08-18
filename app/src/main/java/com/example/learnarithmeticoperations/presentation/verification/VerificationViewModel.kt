package com.example.learnarithmeticoperations.presentation.verification

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learnarithmeticoperations.repository.AuthRepository
import com.example.learnarithmeticoperations.response.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VerificationViewModel @Inject constructor(
    private val repo: AuthRepository
): ViewModel() {
    var verificationResponse by mutableStateOf<Response>(Response.Loading(false))
        private set

    var verificationLoadingResponse by mutableStateOf<Response>(Response.Loading(false))
        private set

    init {
        reloadUserState()
    }

    private fun reloadUserState() = viewModelScope.launch {
        verificationResponse = try {
            while(repo.getAuthState()?.isEmailVerified == false) {
                delay(3000)
                Log.d("ak2000yy", "from viewModel ${repo.getAuthState()?.isEmailVerified}")
                Response.Loading(true)
            }
            Response.Success
        }catch(e: Exception) {
            Response.Failure(e.message.toString())
        }
    }

    fun verify() = viewModelScope.launch {
        verificationLoadingResponse = try {
            Response.Loading(true)
            repo.verify()
            Response.Success
        }catch(e: Exception) {
            Response.Failure(e.message.toString())
        }
    }
}