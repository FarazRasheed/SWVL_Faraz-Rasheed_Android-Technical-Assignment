package com.swvl.movies.services.networkServices

import retrofit2.Response
import retrofit2.http.*

interface NetworkService {
    @Headers("Content-Type: application/json")
    @GET("")
    suspend fun getList(): Response<Any>
}