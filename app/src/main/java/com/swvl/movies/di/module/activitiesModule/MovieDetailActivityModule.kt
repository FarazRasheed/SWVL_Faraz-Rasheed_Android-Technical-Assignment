package com.swvl.movies.di.module.activitiesModule

import com.swvl.movies.ui.home.MovieDetailActivity
import com.swvl.movies.utils.ProgressHUD
import dagger.Module
import dagger.Provides

@Module
class MovieDetailActivityModule {

    @Provides
    fun provideLoader(activity: MovieDetailActivity): ProgressHUD {
        return ProgressHUD(activity)
    }


}