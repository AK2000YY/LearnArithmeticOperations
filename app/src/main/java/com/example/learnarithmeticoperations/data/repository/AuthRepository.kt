package com.example.learnarithmeticoperations.data.repository

import com.example.learnarithmeticoperations.core.Constants.EMPTY_MESSAGE
import com.example.learnarithmeticoperations.domain.model.Response
import com.example.learnarithmeticoperations.domain.model.Response.Success
import com.example.learnarithmeticoperations.domain.model.Response.Failure
import com.example.learnarithmeticoperations.domain.model.Response.Loading
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(
    private val auth: FirebaseAuth
) {

    fun getAuthState(): Response<Unit> =
        if(auth.currentUser == null) Failure("No User")
        else
            if(auth.currentUser?.isEmailVerified == false) Loading(true)
            else Success(Unit)

    suspend fun signUp(
        email: String,
        password: String,
        confirmPassword: String
    ): Response<Unit> =
        try {
            if(password == confirmPassword){
                auth.createUserWithEmailAndPassword(email, password).await()
                Success(Unit)
            }else{
                Failure("passwords aren't match")
            }

        }catch(e: Exception) {
            Failure(e.message?: EMPTY_MESSAGE)
        }

    suspend fun verify(): Response<Unit> =
        try {
            auth.currentUser?.sendEmailVerification()?.await()
            Success(Unit)
        }catch(e: Exception) {
            Failure(e.message?: EMPTY_MESSAGE)
        }

    suspend fun login(
        email: String,
        password: String
    ): Response<Unit> =
        try {
            auth.signInWithEmailAndPassword(email, password).await()
            Success(Unit)
        }catch(e: Exception) {
            Failure(e.message?: EMPTY_MESSAGE)
        }

    suspend fun reload(): Response<Unit> =
        try {
            while(!auth.currentUser!!.isEmailVerified) {
                auth.currentUser?.reload()?.await()
                delay(3000)
            }
            Success(Unit)
        }catch(e: Exception) {
            Failure(e.message?:EMPTY_MESSAGE)
        }


}