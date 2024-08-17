package com.example.learnarithmeticoperations.presentation.signupOrLogin.compoonent

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.learnarithmeticoperations.presentation.signupOrLogin.ChoosePart
import com.example.learnarithmeticoperations.presentation.welcome.component.TextOfWelcome

@Composable
fun LoginORSignup(
    modifier: Modifier = Modifier,
    choosePart: ChoosePart,
    toSignup: () -> Unit,
    toLogin: () -> Unit,
    toLoginOrSignup: () -> Unit,
    toCloseApp: () -> Unit
) {
    BackHandler {
        if(choosePart == ChoosePart.LoginOrSignup)
            toCloseApp()
        else
            toLoginOrSignup()
    }
    Column(
        modifier = modifier
    ) {
        UpPart(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
                .background(MaterialTheme.colorScheme.background)
        )
        DownPart(
            modifier = Modifier
                .fillMaxWidth()
                .weight(7f)
                .clip(RoundedCornerShape(topEnd = 25.dp, topStart = 25.dp))
                .background(
                    if(isSystemInDarkTheme()) Color.White
                    else Color.Gray
                ),
            choosePart = choosePart,
            toLogin = { toLogin() },
            toSignup = { toSignup() }
        )

    }
}

@Composable
fun UpPart(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {

        TextOfWelcome(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )
    }
}

@Composable
fun DownPart(
    modifier: Modifier = Modifier,
    choosePart: ChoosePart,
    toSignup: () -> Unit,
    toLogin: () -> Unit
) {
    when(choosePart){
        ChoosePart.LoginOrSignup -> LoginOrSignupPart(
            modifier = modifier,
            toSignup = { toSignup() },
            toLogin = { toLogin() }
        )
        ChoosePart.Signup -> SignupPart(modifier = modifier)
        else -> LoginPart(modifier = modifier)
    }
}

@Composable
fun LoginOrSignupPart(
    modifier: Modifier = Modifier,
    toSignup: () -> Unit,
    toLogin: () -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { toLogin() }) {
            Text(text = "Login")
        }
        Button(onClick = { toSignup() }) {
            Text(text = "Signup")
        }
    }
}