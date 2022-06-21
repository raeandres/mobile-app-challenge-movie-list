package com.example.movielist.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.movielist.model.Movie
import com.example.movielist.network.*

class MovieViewModel: ViewModel() {
     val _movieList = mutableStateListOf<Movie>()
    var errorMessage: String by mutableStateOf("")
    val movies: List<Movie>
       get() = _movieList

    fun getMovieList() {

         ApiCall.INSTANCE.getMovies(object: ApiResponse {
             override fun data(data: List<Movie>, status: Boolean) {
                 _movieList.clear()
                 _movieList.addAll(data)
             }
         })
    }
}