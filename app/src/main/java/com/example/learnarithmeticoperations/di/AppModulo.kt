package com.example.learnarithmeticoperations.di

import com.example.learnarithmeticoperations.repository.AuthRepository
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
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
        AuthRepository(auth = Firebase.auth)

}