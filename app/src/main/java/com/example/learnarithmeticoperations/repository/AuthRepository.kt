package com.example.learnarithmeticoperations.repository

import com.example.learnarithmeticoperations.response.Response
import com.example.learnarithmeticoperations.response.Response.Success
import com.example.learnarithmeticoperations.response.Response.Failure
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.userProfileChangeRequest
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
        userName: String,
        email: String,
        password: String
    ): Response =
        try {
            auth.createUserWithEmailAndPassword(email, password).await()
            auth.currentUser?.updateProfile(
                userProfileChangeRequest {
                    displayName = userName
                }
            )?.await()
            Success
        }catch(e: Exception) {
            Failure(e.message.toString())
        }

    suspend fun login(
        email: String,
        password: String
    ): Response =
        try {
            auth.signInWithEmailAndPassword(email, password).await()
            Success
        }catch(e: Exception) {
            Failure(e.message.toString())
        }

}