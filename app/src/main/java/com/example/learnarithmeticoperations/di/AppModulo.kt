package com.example.learnarithmeticoperations.di

import com.example.learnarithmeticoperations.core.Constants.LEVEL
import com.example.learnarithmeticoperations.core.Constants.QUESTION
import com.example.learnarithmeticoperations.core.Constants.UNIT
import com.example.learnarithmeticoperations.core.Constants.USER
import com.example.learnarithmeticoperations.data.repository.AllLevelRepository
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
import javax.inject.Qualifier

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

    @LevelDetail
    @Provides
    fun provideLevelReference(
        db: FirebaseFirestore,
        auth: FirebaseAuth
    ): CollectionReference =
        db
            .collection(USER)
            .document(auth.currentUser!!.uid)
            .collection(LEVEL)

    @UnitDetail
    @Provides
    fun providesUnitReference(
        db: FirebaseFirestore,
        auth: FirebaseAuth
    ): CollectionReference =
        db
            .collection(USER)
            .document(auth.currentUser!!.uid)
            .collection(LEVEL)
            .document(auth.currentUser!!.uid)
            .collection(UNIT)

    @QuestionDetail
    @Provides
    fun provideQuestionReference(
        db: FirebaseFirestore,
        auth: FirebaseAuth
    ): CollectionReference =
        db
            .collection(USER)
            .document(auth.currentUser!!.uid)
            .collection(LEVEL)
            .document(auth.currentUser!!.uid)
            .collection(UNIT)
            .document(auth.currentUser!!.uid)
            .collection(QUESTION)

    //for testing
    @Provides
    fun provideStoreRepository(
        @LevelDetail ref: CollectionReference,
    ): StoreRepository =
        StoreRepository(
            ref
        )

    @Provides
    fun provideAllLevelRepository(
        @LevelDetail ref: CollectionReference
    ): AllLevelRepository =
        AllLevelRepository(
            ref
        )



}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LevelDetail

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class UnitDetail

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class QuestionDetail