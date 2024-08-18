package com.example.learnarithmeticoperations.presentation.signupOrLogin.compoonent

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LoginPart(
    modifier: Modifier = Modifier,
    email: String,
    password: String,
    toLoginOrSignup: () -> Unit,
    login: () -> Unit,
    editEmail: (String) -> Unit,
    editPassword: (String) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        LoginOrSignupTopBar(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.5f),
            type = "Login",
            toLoginOrSignup = { toLoginOrSignup() }
        )
        AllTextFieldLogin(
            modifier = Modifier
                .fillMaxWidth()
                .weight(7f),
            email = email,
            password = password,
            editEmail = { editEmail(it) },
            editPassword = { editPassword(it) }
        )
        ButtonDesigned(
            buttonName = " LOGIN ",
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    login()
                }
                .weight(1.5f)
                .padding(bottom = 20.dp)
        )
    }
}

@Composable
fun AllTextFieldLogin(
    modifier: Modifier = Modifier,
    email: String,
    password: String,
    editEmail: (String) -> Unit,
    editPassword: (String) -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextFieldDesign(
            placeholder = "Email",
            value = email,
            editValue = {
                editEmail(it)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(75.dp)
                .padding(horizontal = 20.dp, vertical = 8.dp)
                .border(
                    BorderStroke(
                        2.dp,
                        Color.Black
                    ),
                    RoundedCornerShape(35.dp)
                )
        )
        TextFieldDesign(
            placeholder = "Password",
            value = password,
            editValue = {
                editPassword(it)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(75.dp)
                .padding(horizontal = 20.dp, vertical = 8.dp)
                .border(
                    BorderStroke(
                        2.dp,
                        Color.Black
                    ),
                    RoundedCornerShape(35.dp)
                )
        )
    }
}
