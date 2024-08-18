package com.example.learnarithmeticoperations.presentation.signupOrLogin.compoonent

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldDesign(
    modifier: Modifier = Modifier,
    placeholder: String,
    value: String,
    editValue: (String) -> Unit
) {
    TextField(
        modifier = modifier,
        value = value,
        onValueChange = {
            editValue(it)
        },
        placeholder = {
            Text(text = placeholder)
        },
        shape = RoundedCornerShape(35.dp),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black
        )
    )
}
