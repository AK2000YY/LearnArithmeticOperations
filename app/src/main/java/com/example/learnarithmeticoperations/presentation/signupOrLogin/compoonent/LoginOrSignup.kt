package com.example.learnarithmeticoperations.presentation.signupOrLogin.compoonent

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.filled.SportsMartialArts
import androidx.compose.material3.MaterialTheme
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
    userName: String,
    emailLogin: String,
    emailSignup: String,
    passwordLogin: String,
    passwordSignup: String,
    confirmPassword: String,
    toSignup: () -> Unit,
    toLogin: () -> Unit,
    toLoginOrSignup: () -> Unit,
    toCloseApp: () -> Unit,
    login: () -> Unit,
    signup: () -> Unit,
    editEmailLogin: (String) -> Unit,
    editEmailSignup: (String) -> Unit,
    editUserName: (String) -> Unit,
    editPasswordLogin: (String) -> Unit,
    editPasswordSignup: (String) -> Unit,
    editConfirmPassword:  (String) -> Unit
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
            userName = userName,
            emailLogin = emailLogin,
            emailSignup = emailSignup,
            passwordLogin = passwordLogin,
            passwordSignup = passwordSignup,
            confirmPassword = confirmPassword,
            toLogin = { toLogin() },
            toSignup = { toSignup() },
            toLoginOrSignup =  { toLoginOrSignup() },
            login = { login() },
            signup = { signup() },
            editEmailSignup = editEmailSignup,
            editEmailLogin = editEmailLogin,
            editUserName = editUserName,
            editPasswordSignup = editPasswordSignup,
            editPasswordLogin = editPasswordLogin,
            editConfirmPassword = editConfirmPassword
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
    userName: String,
    emailLogin: String,
    emailSignup: String,
    passwordLogin: String,
    passwordSignup: String,
    confirmPassword: String,
    toSignup: () -> Unit,
    toLogin: () -> Unit,
    toLoginOrSignup: () -> Unit,
    login: () -> Unit,
    signup: () -> Unit,
    editEmailLogin: (String) -> Unit,
    editEmailSignup: (String) -> Unit,
    editUserName: (String) -> Unit,
    editPasswordLogin: (String) -> Unit,
    editPasswordSignup: (String) -> Unit,
    editConfirmPassword:  (String) -> Unit
) {
    when(choosePart){
        ChoosePart.LoginOrSignup -> LoginOrSignupPart(
            modifier = modifier,
            toSignup = { toSignup() },
            toLogin = { toLogin() }
        )
        ChoosePart.Signup -> SignupPart(
            modifier = modifier,
            userName = userName,
            emailSignup = emailSignup,
            passwordSignup = passwordSignup,
            confirmPassword = confirmPassword,
            toLoginOrSignup = { toLoginOrSignup() },
            signup = { signup() },
            editUserName = { editUserName(it) },
            editEmailSignup = { editEmailSignup(it) },
            editPasswordSignup = { editPasswordSignup(it) },
            editConfirmPassword = { editConfirmPassword(it) }
        )
        else -> LoginPart(
            modifier = modifier,
            email = emailLogin,
            password = passwordLogin,
            toLoginOrSignup = { toLoginOrSignup() },
            login = { login() },
            editEmail = { editEmailLogin(it) },
            editPassword = { editPasswordLogin(it) }
        )
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
        Spacer(modifier = Modifier.weight(2f))
        PageIndicator(
            modifier = Modifier
                .weight(3f),
            listOfString = listOf(
                "learn with a lot of example for arithmetic operator",
                "make your self fast in calculate numbers",
                "make learning operation simple by this app"
            ),
            listOfIcons = listOf(
                Icons.Default.Calculate,
                Icons.Default.Speed,
                Icons.Default.SportsMartialArts
            )
        )
        Spacer(modifier = Modifier.weight(2f))
        Buttons(
            modifier = Modifier
                .weight(2.5f)
                .fillMaxWidth(),
            toSignup = toSignup,
            toLogin = toLogin
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun Buttons(
    modifier: Modifier = Modifier,
    toSignup: () -> Unit,
    toLogin: () -> Unit
) {
   Column(
       modifier = modifier,
       horizontalAlignment = Alignment.CenterHorizontally,
   ) {
       ButtonDesigned(
           modifier = Modifier
               .weight(1.0f)
               .clickable { toLogin() },
           buttonName = "LOGIN"
       )
       Spacer(modifier = Modifier.weight(0.4f))
       ButtonDesigned(
           modifier = Modifier
               .weight(1.0f)
               .clickable { toSignup() },
           buttonName = "SIGNUP"
       )
   }
}

