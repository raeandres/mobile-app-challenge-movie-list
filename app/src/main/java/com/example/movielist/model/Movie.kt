package com.example.movielist.model

data class Movie(
    val Title: String,
    val Year: String,
    val imdbID: String,
    val Type: String,
    val Poster: String
)

data class ApiMovieResponse(
    val Search: List<Movie>,
    val totalResults: String,
    val Response: String
)