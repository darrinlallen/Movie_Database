package com.example.movie_database.model

import com.example.movie_database.model.Search

data class MovieDataClass(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String

)