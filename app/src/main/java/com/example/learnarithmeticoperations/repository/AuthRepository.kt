package com.example.learnarithmeticoperations.repository

import com.example.learnarithmeticoperations.core.Constants.EMPTY_MESSAGE
import com.example.learnarithmeticoperations.response.Response
import com.example.learnarithmeticoperations.response.Response.Success
import com.example.learnarithmeticoperations.response.Response.Failure
import com.example.learnarithmeticoperations.response.Response.Loading
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(
    private val auth: FirebaseAuth
) {

    fun getAuthState(): Response =
        if(auth.currentUser == null) Failure("No User")
        else
            if(auth.currentUser?.isEmailVerified == false) Loading(true)
            else Success

    suspend fun signUp(
        email: String,
        password: String,
        confirmPassword: String
    ): Response =
        try {
            if(password == confirmPassword){
                auth.createUserWithEmailAndPassword(email, password).await()
                Success
            }else{
                Failure("passwords aren't match")
            }

        }catch(e: Exception) {
            Failure(e.message?: EMPTY_MESSAGE)
        }

    suspend fun verify(): Response =
        try {
            auth.currentUser?.sendEmailVerification()?.await()
            Success
        }catch(e: Exception) {
            Failure(e.message?: EMPTY_MESSAGE)
        }

    suspend fun login(
        email: String,
        password: String
    ): Response =
        try {
            auth.signInWithEmailAndPassword(email, password).await()
            Success
        }catch(e: Exception) {
            Failure(e.message?: EMPTY_MESSAGE)
        }

    suspend fun reload(): Response =
        try {
            auth.currentUser?.reload()?.await()
            Success
        }catch(e: Exception) {
            Failure(e.message?:EMPTY_MESSAGE)
        }

}