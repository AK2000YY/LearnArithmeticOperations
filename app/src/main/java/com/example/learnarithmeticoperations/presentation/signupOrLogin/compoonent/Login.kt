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
fun LoginPart(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        LoginOrSignupTopBar(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.5f),
            type = "Login"
        )
        AllTextFieldLogin(
            modifier = Modifier
                .fillMaxWidth()
                .weight(7f)
        )
        ButtonDesigned(
            buttonName = " LOGIN ",
            modifier = Modifier
                .fillMaxWidth()
                .clickable { }
                .weight(1.5f)
                .padding(bottom = 20.dp)
        )
    }
}

@Composable
fun AllTextFieldLogin(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextFieldDesign(
            placeholder = "Email",
            value = "",
            editValue = {},
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
            value = "",
            editValue = {},
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
