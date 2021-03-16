package com.swvl.movies.services.networkServices

import com.swvl.movies.services.dataModels.picture.PhotoDTO
import retrofit2.Response
import retrofit2.http.*

interface NetworkService {
    @Headers("Content-Type: application/json")
    @GET("rest/")
    suspend fun getList(
        @Query("method") method: String,
        @Query("format") format: String,
        @Query("nojsoncallback") nojsoncallback: String,
        @Query("text") text: String,
        @Query("page") page: String,
        @Query("per_page") per_page: String,
        @Query("api_key") api_key: String
    ): Response<PhotoDTO>
}