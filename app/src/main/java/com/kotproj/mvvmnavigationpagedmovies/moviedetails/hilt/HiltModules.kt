package com.kotproj.mvvmnavigationpagedmovies.moviedetails.hilt

import com.kotproj.mvvmnavigationpagedmovies.moviedetails.remote.MovieInterface
import com.kotproj.mvvmnavigationpagedmovies.moviedetails.ui.details.MovieDetailsRepository
import com.kotproj.mvvmnavigationpagedmovies.moviedetails.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
object HiltModules {

    @Provides
    fun provideRetrofitInterface(): MovieInterface {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build().create(MovieInterface::class.java)
    }

    @Provides
    fun provideRepository(movieInterface: MovieInterface): MovieDetailsRepository {
        return MovieDetailsRepository(movieInterface)
    }


}