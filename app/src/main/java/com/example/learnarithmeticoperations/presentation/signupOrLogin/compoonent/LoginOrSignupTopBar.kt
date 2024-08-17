package com.example.learnarithmeticoperations.presentation.signupOrLogin.compoonent

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LoginOrSignupTopBar(
    modifier: Modifier = Modifier,
    type: String
) {
    Box(
        modifier = modifier,
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBackIosNew,
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 20.dp)
                .size(40.dp),
            tint = Color.Black
        )
        Text(
            text = type,
            style = MaterialTheme.typography.headlineLarge,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}