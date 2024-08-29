package com.example.learnarithmeticoperations.di

import com.example.learnarithmeticoperations.data.repository.AuthRepository
import com.example.learnarithmeticoperations.data.repository.StoreRepository
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
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
    fun provideFireBaseAuth(): FirebaseAuth =
        Firebase.auth

    @Provides
    fun provideFireBaseFireStore(): FirebaseFirestore =
        Firebase.firestore

    @Provides
    fun provideAuthRepository(
        auth: FirebaseAuth
    ): AuthRepository =
        AuthRepository(
            auth
        )

    @Provides
    fun provideQuestionReference(
        db: FirebaseFirestore,
        auth: FirebaseAuth
    ): CollectionReference =
        db.collection("user").document(auth.currentUser!!.uid).collection("question")

    @Provides
    fun provideStoreRepository(
        ref: CollectionReference,
    ): StoreRepository =
        StoreRepository(
            ref
        )

}