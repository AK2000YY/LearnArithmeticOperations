package com.example.learnarithmeticoperations.response

sealed class Response {
    data class Loading(val t: Boolean) : Response()
    data class Failure(val e: String): Response()
    data object Success: Response()
}