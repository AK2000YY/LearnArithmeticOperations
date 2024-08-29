package com.example.learnarithmeticoperations.domain.model


sealed class Response<out T>{
    data class Loading(val t: Boolean) : Response<Nothing>()
    data class Failure(val e: String): Response<Nothing>()
    data class Success<T>(val data: T): Response<T>()
}

