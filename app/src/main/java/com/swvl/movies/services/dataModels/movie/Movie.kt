package com.swvl.movies.services.dataModels.movie

data class Movie(
    val cast: List<String>,
    val genres: List<String>,
    val rating: Int,
    val title: String,
    val year: Int
)