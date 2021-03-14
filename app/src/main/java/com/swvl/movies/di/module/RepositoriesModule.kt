package com.swvl.movies.di.module

import com.swvl.movies.services.networkServices.NetworkService
import com.swvl.movies.services.repositories.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoriesModule {

    @Provides
    @Singleton
    fun provideRepository(networkService : NetworkService): Repository {
        return Repository(networkService)
    }
}