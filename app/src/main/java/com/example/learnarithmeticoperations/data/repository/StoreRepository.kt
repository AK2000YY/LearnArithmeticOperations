package com.example.learnarithmeticoperations.data.repository

import com.example.learnarithmeticoperations.core.Constants.EMPTY_MESSAGE
import com.example.learnarithmeticoperations.domain.model.Question
import com.example.learnarithmeticoperations.domain.model.Response.Success
import com.example.learnarithmeticoperations.domain.model.Response.Failure
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class StoreRepository @Inject constructor(
    private val ref: CollectionReference
) {

    suspend fun getUserQuestionSolved() = callbackFlow {
        val snapshotListener = ref.addSnapshotListener { questionSnapshot, e ->
            val questionResponse = if(questionSnapshot!=null) {
                val questions = questionSnapshot.map {
                    Question(
                        id = it.id,
                        title = it.getString("title"),
                        body = it.getString("body"),
                        answer = it.getString("answer")
                    )
                }
                Success(questions)
            }else {
                Failure(e?.message?: EMPTY_MESSAGE)
            }
            trySend(questionResponse)
        }
        awaitClose {
            snapshotListener.remove()
        }
    }

    suspend fun createSolvedQuestion(question: HashMap<String, Any>) =
        try {
            ref.add(question).await()
            Success(true)
        }catch (e: Exception) {
            Failure(e.message?: EMPTY_MESSAGE)
        }
}
