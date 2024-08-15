package com.example.learnarithmeticoperations.navigation

import com.example.learnarithmeticoperations.core.Constants.LOGIN_OR_SIGNUP
import com.example.learnarithmeticoperations.core.Constants.WELCOME_SCREEN

sealed class Screen(val route: String) {
    data object WelcomeScreen: Screen(WELCOME_SCREEN)
    data object LoginOrSignup: Screen(LOGIN_OR_SIGNUP)
}