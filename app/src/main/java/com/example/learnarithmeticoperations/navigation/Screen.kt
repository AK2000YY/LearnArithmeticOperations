package com.example.learnarithmeticoperations.navigation

import com.example.learnarithmeticoperations.core.Constants.LOGIN_OR_SIGNUP
import com.example.learnarithmeticoperations.core.Constants.SEND_OR_NOT
import com.example.learnarithmeticoperations.core.Constants.VERIFICATION_SCREEN
import com.example.learnarithmeticoperations.core.Constants.WELCOME_SCREEN

sealed class Screen(val route: String) {
    data object WelcomeScreen: Screen(WELCOME_SCREEN)
    data object LoginOrSignupScreen: Screen(LOGIN_OR_SIGNUP)
    data object VerificationScreen: Screen(VERIFICATION_SCREEN) {
        fun send(value: String = "No"): String =
            this.route.replace("{$SEND_OR_NOT}", value)
    }
}