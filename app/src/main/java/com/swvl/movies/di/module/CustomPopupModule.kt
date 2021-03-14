package com.swvl.movies.di.module

import com.swvl.movies.utils.CustomPopups
import dagger.Module
import dagger.Provides

@Module
class CustomPopupModule {

    @Provides
    fun provideCustomPopups(): CustomPopups {
        return CustomPopups()
    }
}