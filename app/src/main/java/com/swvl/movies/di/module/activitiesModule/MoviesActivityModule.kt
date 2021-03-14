package com.swvl.movies.di.module.activitiesModule

import com.swvl.movies.ui.home.MoviesAdapter
import com.swvl.movies.ui.home.MovieListActivity
import com.swvl.movies.utils.ProgressHUD
import dagger.Module
import dagger.Provides

@Module
class MoviesActivityModule {

    @Provides
    fun provideLoader(activity: MovieListActivity): ProgressHUD {
        return ProgressHUD(activity)
    }

    @Provides
    fun provideLearningAdapter(): MoviesAdapter {
        return MoviesAdapter()
    }

}