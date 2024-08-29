package com.example.learnarithmeticoperations.di

import com.example.learnarithmeticoperations.repository.AuthRepository
import com.example.learnarithmeticoperations.repository.StoreRepository
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton


@Module
@InstallIn(ViewModelComponent::class)
class AppModulo {

    @Provides
    fun provideAuthRepository(): AuthRepository =
        AuthRepository(
            auth = Firebase.auth
        )

    @Provides
    fun provideFireBaseFireStore(): FirebaseFirestore =
        Firebase.firestore


    @Provides
    fun provideQuestionReference(
        db: FirebaseFirestore
    ): CollectionReference =
        db.collection("question")


    @Provides
    fun provideStoreRepository(
        ref: CollectionReference
    ): StoreRepository =
        StoreRepository(
            ref
        )

}