package com.swvl.movies.services.repositories

import com.swvl.movies.services.networkServices.NetworkService
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val networkService: NetworkService) {
    suspend fun getList(): Response<Any> {
        return networkService.getList()
    }
}