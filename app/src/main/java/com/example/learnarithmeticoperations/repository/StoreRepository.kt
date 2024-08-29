package com.example.learnarithmeticoperations.repository

import com.example.learnarithmeticoperations.data.Question
import com.example.learnarithmeticoperations.response.NewResponse
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
                NewResponse.Success(questions)
            }else {
                NewResponse.Failure(e)
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
            NewResponse.Success(true)
        }catch (e: Exception) {
            NewResponse.Failure(e)
        }
}
