package com.example.learnarithmeticoperations.presentation.verification

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.learnarithmeticoperations.R
import com.example.learnarithmeticoperations.data.SharedMethod
import com.example.learnarithmeticoperations.presentation.signupOrLogin.compoonent.ProgressBar
import com.example.learnarithmeticoperations.response.Response

@Composable
fun VerificationScreen(
    modifier: Modifier = Modifier,
    toMyApp: () -> Unit,
    sendOrNot: String,
    viewModel: VerificationViewModel = hiltViewModel()
) {
    val context: Context = LocalContext.current
    LaunchedEffect(sendOrNot!="No") {
        Log.d("ak2000yy", "from verification screen $sendOrNot")
        if(sendOrNot != "No")
            viewModel.verify()
    }
    Scaffold(
        modifier = modifier
    ) { padding ->
        Verification(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            verify = { viewModel.verify() }
        )
    }

    when(val verificationLoadingResponse = viewModel.verificationLoadingResponse) {
        is Response.Loading ->
            if(verificationLoadingResponse.t)
                ProgressBar(
                    modifier = Modifier
                        .fillMaxSize()
                )
        is Response.Failure -> verificationLoadingResponse.apply {
            SharedMethod.showToast(context, verificationLoadingResponse.e)
        }
        is Response.Success -> verificationLoadingResponse.apply {
            SharedMethod.showToast(context, "Email Verification sent")
        }
    }

    if(viewModel.verificationResponse == Response.Success)
        viewModel.verificationResponse.apply {
            toMyApp()
        }
}

@Composable
fun Verification(
    modifier: Modifier = Modifier,
    verify: () -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.tick),
            contentDescription = null,
            modifier = Modifier
                .padding(bottom = 40.dp)
                .size(125.dp)
        )
        Text(
            text = "Check Your Email And Verify Your Account",
            style = MaterialTheme.typography.bodyLarge,
        )
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomCenter
        ) {
            BottomBar(
                modifier = Modifier
                    .padding(bottom = 20.dp),
                verify = { verify() }
            )
        }
    }
}

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    verify: () -> Unit
) {
    Row(
        modifier = modifier
    ) {
        Text(
            text = "if you don't receive email ",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "press here",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Cyan,
            modifier = Modifier
                .clickable {
                    verify()
                }
        )
    }
}
