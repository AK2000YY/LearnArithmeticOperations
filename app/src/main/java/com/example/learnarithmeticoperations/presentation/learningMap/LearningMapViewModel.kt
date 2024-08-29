package com.example.learnarithmeticoperations.presentation.learningMap

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learnarithmeticoperations.data.Question
import com.example.learnarithmeticoperations.repository.StoreRepository
import com.example.learnarithmeticoperations.response.NewResponse
import com.example.learnarithmeticoperations.response.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LearningMapViewModel @Inject constructor(
    private val repo: StoreRepository
) : ViewModel() {

    var questionResponse by mutableStateOf<NewResponse<List<Question>>>(NewResponse.Loading)
        private set

    var createResponse by mutableStateOf<NewResponse<Boolean>>(NewResponse.Loading)

    init {
        getQuestions()
    }

    private fun getQuestions() = viewModelScope.launch {
        repo.getUserQuestionSolved().collect {
            questionResponse = it
        }
    }

    fun addQuestion(question: HashMap<String, Any>) = viewModelScope.launch {
        createResponse = NewResponse.Loading
        createResponse = repo.createSolvedQuestion(question)
    }
}