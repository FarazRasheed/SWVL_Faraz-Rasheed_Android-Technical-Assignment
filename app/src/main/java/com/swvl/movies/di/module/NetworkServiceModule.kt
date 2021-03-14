package com.swvl.movies.di.module

import com.swvl.movies.services.networkServices.NetworkService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
object NetworkServiceModule {
    @Provides
    @Singleton
    fun provideRemoteService(retrofit: Retrofit): NetworkService {
        return retrofit.create(NetworkService::class.java)
    }

}