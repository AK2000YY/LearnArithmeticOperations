package com.example.learnarithmeticoperations.response

sealed class Response<out T> {
    data object Loading : Response<Nothing>()
    data class Failure(val e: String): Response<Nothing>()
    data class Success<T>(val t: T): Response<T>()
}