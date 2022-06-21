package com.example.movielist.network

import coil.request.Disposable
import com.example.movielist.model.ApiMovieResponse
import com.example.movielist.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.lang.Exception


interface ApiResponse {
    fun data(data: List<Movie>, status: Boolean)
}

class ApiCall {


    companion object {
        val INSTANCE = ApiCall()

        val networkService by lazy { NetworkAdapter.getNetworkService()}

    }



    fun getMovies(callback: ApiResponse) {

        networkService.getMovies(
                apiKey = API_KEY,
                section = SECTION,
                type = TYPE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result ->
                    callback.data(result.Search, true)
                }, { error ->
                    error.printStackTrace()
                })



    }


}