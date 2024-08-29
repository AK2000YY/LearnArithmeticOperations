package com.example.learnarithmeticoperations.presentation.learningMap

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learnarithmeticoperations.domain.model.Question
import com.example.learnarithmeticoperations.data.repository.StoreRepository
import com.example.learnarithmeticoperations.domain.model.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LearningMapViewModel @Inject constructor(
    private val repo: StoreRepository
) : ViewModel() {

    var questionResponse by mutableStateOf<Response<List<Question>>>(Response.Loading(false))
        private set

    var createResponse by mutableStateOf<Response<Boolean>>(Response.Loading(false))

    init {
        getQuestions()
    }

    private fun getQuestions() = viewModelScope.launch {
        repo.getUserQuestionSolved().collect {
            questionResponse = it
        }
    }

    fun addQuestion(question: HashMap<String, Any>) = viewModelScope.launch {
        createResponse = Response.Loading(true)
        createResponse = repo.createSolvedQuestion(question)
    }
}