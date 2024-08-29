package com.example.learnarithmeticoperations.response


sealed class Response {
    data class Loading(val t: Boolean) : Response()
    data class Failure(val e: String): Response()
    data object Success: Response()
}


sealed class NewResponse<out T> {
    data object Loading: NewResponse<Nothing>()

    data class Success<out T>(
        val data: T?
    ): NewResponse<T>()

    data class Failure(
        val e: Exception?
    ): NewResponse<Nothing>()
}
