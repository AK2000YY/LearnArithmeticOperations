package com.example.learnarithmeticoperations.presentation.welcome.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextOfWelcome(
    modifier: Modifier = Modifier,
    autoColor: Boolean = false
) {
    val gradientColors = listOf(Color.Cyan, Color.Magenta, Color.Blue)
    val gradientText = buildAnnotatedString {
        withStyle(style = SpanStyle(brush = Brush.linearGradient(gradientColors))) {
            append("WELCOME")
        }
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            if(autoColor)
                Text(
                    text = gradientText.toString(),
                    style = TextStyle(fontSize = 70.sp)
                )
            else
                Text(
                    text = gradientText,
                    style = TextStyle(fontSize = 70.sp)
                )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            TextOfMainText(text = "Learn", color = if(autoColor) Color.Unspecified else  Color.Cyan )
            TextOfMainText(text = ".")
            TextOfMainText(text = "Fast", color = if(autoColor) Color.Unspecified else Color.Magenta)
            TextOfMainText(text = ".")
            TextOfMainText(text = "Simple", color = if(autoColor) Color.Unspecified else Color.Blue)
        }
    }
}

@Composable
fun TextOfMainText(
    text: String,
    color: Color = Color.Unspecified
) {
    Text(
        text = text,
        color = color,
        softWrap = false,
        fontSize = 41.5.sp
    )
}

@Preview
@Composable
private fun PrevText() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextOfWelcome(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
    }
}