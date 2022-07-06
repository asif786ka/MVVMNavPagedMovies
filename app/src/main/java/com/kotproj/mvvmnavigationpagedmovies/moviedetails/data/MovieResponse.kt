package com.kotproj.mvvmnavigationpagedmovies.moviedetails.data

data class MovieResponse(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)