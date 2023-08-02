package com.krupal.assignment1.di

import com.krupal.assignment1.data.repository.MovieRepository
import com.krupal.assignment1.data.repository.MovieRepositoryImpl
import com.krupal.assignment1.data.service.MovieService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface MoviesModule {

    @Provides
    fun provideMovieService(service: MovieService): MovieService

    @Binds
    fun provideMovieRepository(repo: MovieRepositoryImpl): MovieRepository
}