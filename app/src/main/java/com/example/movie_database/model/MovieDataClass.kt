package com.example.movie_database.model

import com.example.movie_database.model.Search
// used to read in Json
data class MovieDataClass(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String

)