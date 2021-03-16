package com.swvl.movies.services.repositories

import com.swvl.movies.services.dataModels.picture.PhotoDTO
import com.swvl.movies.services.networkServices.NetworkService
import com.swvl.movies.utils.Constants
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val networkService: NetworkService) {
    suspend fun getList(text: String): Response<PhotoDTO> {
        return networkService.getList(
            Constants.method,
            Constants.format,
            Constants.nojsoncallback,
            text,
            Constants.page,
            Constants.perPage,
            Constants.apiKey
        )
    }
}