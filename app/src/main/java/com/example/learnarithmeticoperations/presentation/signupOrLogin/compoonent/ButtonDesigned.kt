package com.example.learnarithmeticoperations.presentation.signupOrLogin.compoonent

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonDesigned(
    modifier: Modifier = Modifier,
    buttonName: String
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .background(
                if (buttonName == "LOGIN") Color.White else Color.Black,
                RoundedCornerShape(35.dp)
            )
            .border(
                BorderStroke(2.dp, if (buttonName == "LOGIN") Color.Black else Color.White),
                RoundedCornerShape(35.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = buttonName,
            style = MaterialTheme.typography.titleLarge,
            color = if (buttonName == "LOGIN") Color.Black else Color.White
        )
    }
}