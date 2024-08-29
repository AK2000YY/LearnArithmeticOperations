package com.example.learnarithmeticoperations.presentation.learningMap

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Scaffold
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.learnarithmeticoperations.core.SharedMethod
import com.example.learnarithmeticoperations.presentation.signupOrLogin.compoonent.ProgressBar
import com.example.learnarithmeticoperations.response.NewResponse

@Composable
fun LearningMapScreen(
    modifier: Modifier = Modifier,
    viewModel: LearningMapViewModel = hiltViewModel()
) {
    var isAppeared by remember { mutableStateOf(false) }
    Scaffold(
        modifier = modifier
    ) { padding -> 
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            when(val questionResponse = viewModel.questionResponse) {
                is NewResponse.Loading ->
                    ProgressBar()
                is NewResponse.Failure ->
                    SharedMethod.showToast(LocalContext.current, questionResponse.e?.message.toString())
                is NewResponse.Success -> {
                    LazyColumn(
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.background)
                    ) {
                        item {
                            Button(onClick = { isAppeared = true }) {
                                Text(text = "Add")
                            }
                        }
                        items(questionResponse.data?: listOf()) {
                            Column {
                                Text(text = it.id.toString())
                                Text(text = it.title.toString())
                                Text(text = it.body.toString())
                                Text(text = it.answer.toString())
                            }
                        }
                    }
                }
            }
            if(isAppeared) {
                Column {
                    var body by remember { mutableStateOf("") }
                    var title by remember { mutableStateOf("") }
                    var answer by remember { mutableStateOf("") }
                    TextField(value = title, onValueChange = {title = it})
                    TextField(value = body, onValueChange = { body = it })
                    TextField(value = answer, onValueChange = { answer = it })
                    Button(onClick = {
                        isAppeared = false
                        viewModel.addQuestion(hashMapOf(
                            "title" to title,
                            "body" to body,
                            "answer" to answer
                        ))
                    }) {
                        Text(text = "Add Question")
                    }
                }
            }
        }
    }

}