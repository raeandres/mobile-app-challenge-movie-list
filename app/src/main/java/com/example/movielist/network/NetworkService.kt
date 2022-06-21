package com.example.movielist.network

import com.example.movielist.model.ApiMovieResponse
import com.example.movielist.model.Movie
import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

const val API_KEY = "b9bd48a6"
const val URL_ENDPOINT = "http://www.omdbapi.com/"
const val SECTION = "Marvel"
const val TYPE = "movie"

interface NetworkService {


    @GET(".")
    fun getMovies(@Query("apikey") apiKey: String,
                  @Query("s") section: String,
                  @Query("type") type: String) : Observable<ApiMovieResponse>


//    http://www.omdbapi.com/?apikey=b9bd48a6&s=Marvel&type=movie
}