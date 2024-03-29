package com.kotproj.mvvmnavigationpagedmovies.moviedetails.remote

import com.kotproj.mvvmnavigationpagedmovies.moviedetails.data.MovieResponse
import com.kotproj.mvvmnavigationpagedmovies.moviedetails.data.moviedetails.MovieDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieInterface {

    @GET("/")
    suspend fun getAllMovies(
        @Query("s")s:String,
        @Query("page")page:Int,
        @Query("apiKey")apiKey:String
    ):Response<MovieResponse>

    @GET("/")
    suspend fun getMovieDetails(
        @Query("i") imdbId: String,
        @Query("apiKey") apiKey: String
    ): Response<MovieDetails>
}