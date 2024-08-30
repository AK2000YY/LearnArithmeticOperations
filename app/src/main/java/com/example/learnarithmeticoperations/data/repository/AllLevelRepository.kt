package com.example.learnarithmeticoperations.data.repository

import com.example.learnarithmeticoperations.R
import com.example.learnarithmeticoperations.core.Constants.EMPTY_MESSAGE
import com.example.learnarithmeticoperations.domain.model.Level
import com.example.learnarithmeticoperations.domain.model.Response
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.getField
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

typealias LevelResponse = Flow<Response<List<Level>>>

class AllLevelRepository @Inject constructor(
    private val ref: CollectionReference
) {

    fun getLevels(): List<Level> = LocalLevel.getLevels()

    fun getUserLevels(): LevelResponse = callbackFlow {
        val snapshotListener = ref.addSnapshotListener { levelSnapshot, e ->
            val levelsResponse = if(levelSnapshot!=null) {
                val levels = levelSnapshot.map {
                    Level(
                        name = it.getString("name"),
                        description = it.getString("description"),
                        numberOfUnit = it.getField("numberOfUnit"),
                        numberOfOpenedUnit = it.getField("numberOfOpenedUnit")
                    )
                }
                Response.Success(levels)
            }else {
                Response.Failure(e?.message?:EMPTY_MESSAGE)
            }

            trySend(levelsResponse)
        }

        awaitClose { snapshotListener.remove() }
    }

    fun createUnit() =
        try {

        }catch(e: Exception) {

        }

}




object LocalLevel {
    fun getLevels() = listOf(
        Level(
            name = "Level 1",
            description = "",
            numberOfUnit = 3
        ),
        Level(
            name = "Level 2",
            description = "",
            numberOfUnit = 4
        ),
        Level(
            name = "Level 3",
            description = "",
            numberOfUnit = 3
        )
    )
}