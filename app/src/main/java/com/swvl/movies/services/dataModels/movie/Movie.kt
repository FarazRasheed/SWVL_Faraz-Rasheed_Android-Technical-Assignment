package com.swvl.movies.services.dataModels.movie

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val cast: List<String>,
    val genres: List<String>,
    val rating: Int,
    val title: String,
    var imageUrl: String = "",
    val year: String
): Parcelable