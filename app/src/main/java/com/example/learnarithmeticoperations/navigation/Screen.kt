package com.example.learnarithmeticoperations.navigation

import com.example.learnarithmeticoperations.core.Constants.COMPETITION
import com.example.learnarithmeticoperations.core.Constants.LEVEL_SCREEN
import com.example.learnarithmeticoperations.core.Constants.LOGIN_OR_SIGNUP
import com.example.learnarithmeticoperations.core.Constants.NAVIGATION_BAR
import com.example.learnarithmeticoperations.core.Constants.ORDER
import com.example.learnarithmeticoperations.core.Constants.PROFILE
import com.example.learnarithmeticoperations.core.Constants.SAVED_QUESTION
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
    data object NavigationBarScreen: Screen(NAVIGATION_BAR)
    data object LevelScreen: Screen(LEVEL_SCREEN)
    data object SavedQuestionScreen: Screen(SAVED_QUESTION)
    data object CompetitionScreen: Screen(COMPETITION)
    data object OrderScreen: Screen(ORDER)
    data object ProfileScreen: Screen(PROFILE)
}