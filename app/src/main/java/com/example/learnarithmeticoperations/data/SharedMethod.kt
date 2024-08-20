package com.example.learnarithmeticoperations.data

import android.content.Context
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.makeText

object SharedMethod {
    fun showToast(
        context: Context,
        message: String
    ) {
        makeText(context, message, LENGTH_LONG).show()
    }
}