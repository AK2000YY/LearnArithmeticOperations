package com.example.learnarithmeticoperations.presentation.welcome.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Welcome(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        RowOfMultiAndAdd(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        TextOfWelcome(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
        Divide(
            modifier = Modifier
                .weight(1f)
        )
    }
}

@Composable
fun RowOfMultiAndAdd(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "x",
            fontSize = 120.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Cyan,
            modifier = Modifier
                .padding(40.dp)
        )
        Text(
            text = "+",
            fontSize = 200.sp,
            color = Color.Magenta,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 100.dp)
        )
    }
}

@Composable
fun Divide(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "÷",
            color = Color.Blue,
            fontSize = 100.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(end = 100.dp, bottom = 100.dp)
                .rotate(-45f)
        )
    }
}
