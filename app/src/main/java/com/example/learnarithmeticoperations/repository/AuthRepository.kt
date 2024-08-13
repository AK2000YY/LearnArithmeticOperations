package com.example.learnarithmeticoperations.repository

import com.example.learnarithmeticoperations.response.Response
import com.example.learnarithmeticoperations.response.Response.Success
import com.example.learnarithmeticoperations.response.Response.Failure
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(
    private val auth: FirebaseAuth
) {

    fun getAuthState(): Boolean =
        auth.currentUser != null

    suspend fun signUp(
        email: String,
        password: String
    ): Response<Boolean> =
        try {
            auth.createUserWithEmailAndPassword(email, password).await()
            Success(true)
        }catch(e: Exception) {
            Failure(e.message.toString())
        }

    suspend fun login(
        email: String,
        password: String
    ): Response<Boolean> =
        try {
            auth.signInWithEmailAndPassword(email, password).await()
            Success(true)
        }catch(e: Exception) {
            Failure(e.message.toString())
        }

}