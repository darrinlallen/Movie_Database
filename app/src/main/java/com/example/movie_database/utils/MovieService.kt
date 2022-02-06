package com.example.movie_database.utils

import com.example.movie_database.model.MovieDataClass
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    companion object{
        const val BASE_URL = "https://www.omdbapi.com/"

    }

    @GET("?apikey=368629d5")
    suspend fun getMovies(@Query(value = "") search: String)  : MovieDataClass
}