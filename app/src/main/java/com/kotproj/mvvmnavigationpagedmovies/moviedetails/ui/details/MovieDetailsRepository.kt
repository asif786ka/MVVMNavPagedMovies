package com.kotproj.mvvmnavigationpagedmovies.moviedetails.ui.details
import com.kotproj.mvvmnavigationpagedmovies.moviedetails.data.moviedetails.MovieDetails
import com.kotproj.mvvmnavigationpagedmovies.moviedetails.remote.MovieInterface
import com.kotproj.mvvmnavigationpagedmovies.moviedetails.utils.Constants
import com.kotproj.mvvmnavigationpagedmovies.moviedetails.utils.Result;
import com.kotproj.mvvmnavigationpagedmovies.moviedetails.utils.Status

class MovieDetailsRepository(private val movieInterface: MovieInterface) {


    suspend fun getMovieDetails(imdbId: String): Result<MovieDetails> {


        return try {

            val response = movieInterface.getMovieDetails(imdbId, Constants.API_KEY)
            if (response.isSuccessful) {

                Result(Status.SUCCESS, response.body(), null)

            } else {
                Result(Status.ERROR, null, null)
            }


        } catch (e: Exception) {
            Result(Status.ERROR, null, null)
        }


    }


}