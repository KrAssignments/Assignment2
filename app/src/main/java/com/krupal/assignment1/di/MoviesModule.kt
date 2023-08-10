package com.krupal.assignment1.di

import android.app.Application
import com.krupal.assignment1.data.repository.MovieRepository
import com.krupal.assignment1.data.repository.MovieRepositoryImpl
import com.krupal.assignment1.data.service.AssetsMovieServiceImpl
import com.krupal.assignment1.data.service.MovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object MoviesModule {

    @Provides
    fun provideMovieService(application: Application): MovieService =
        AssetsMovieServiceImpl(application)

    @Provides
    fun bindMovieRepository(movieService: MovieService): MovieRepository =
        MovieRepositoryImpl(movieService)
}