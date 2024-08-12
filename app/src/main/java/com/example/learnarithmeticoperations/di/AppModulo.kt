package com.example.learnarithmeticoperations.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModulo {
    @Provides
    @Singleton
    fun provideString(): String = "abdulkarim"
}