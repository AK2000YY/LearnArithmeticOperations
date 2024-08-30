package com.example.learnarithmeticoperations.domain.model

import com.google.firebase.firestore.Exclude

data class Level(
    @Exclude
    val id: String? = null,
    val name: String? = null,
    val description: String? = null,
    val numberOfUnit: Int? = null,
    val numberOfOpenedUnit: Int? = null
)
