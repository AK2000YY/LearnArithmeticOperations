package com.example.learnarithmeticoperations.data

import com.google.firebase.firestore.Exclude

data class Question(
    @Exclude
    var id: String? = null,
    var title: String? = null,
    var body: String? = null,
    var answer: String? = null
)
