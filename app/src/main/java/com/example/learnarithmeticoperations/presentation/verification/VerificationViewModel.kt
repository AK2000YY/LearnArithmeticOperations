package com.example.learnarithmeticoperations.presentation.verification

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learnarithmeticoperations.data.repository.AuthRepository
import com.example.learnarithmeticoperations.domain.model.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VerificationViewModel @Inject constructor(
    private val repo: AuthRepository
): ViewModel() {
    var verificationResponse by mutableStateOf<Response<Unit>>(Response.Loading(false))
        private set

    var verificationLoadingResponse by mutableStateOf<Response<Unit>>(Response.Loading(false))
        private set

    init {
        reloadUserState()
    }

    private fun reloadUserState() = viewModelScope.launch {
        verificationResponse = repo.reload()
        Response.Success(Unit)
    }

    fun verify() = viewModelScope.launch {
        verificationLoadingResponse = Response.Loading(true)
        verificationLoadingResponse = repo.verify()
    }
}