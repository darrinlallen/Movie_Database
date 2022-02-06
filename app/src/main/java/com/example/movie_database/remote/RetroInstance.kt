package com.example.movie_database.remote

import com.example.movie_database.utils.MovieService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class RetrofitInstance {
    private val retrofit = Retrofit.Builder()
        .baseUrl(MovieService.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val movieService : MovieService by lazy {
        retrofit.create()   }

}