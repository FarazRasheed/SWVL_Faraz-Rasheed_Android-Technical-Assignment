package com.swvl.movies.di.module

import com.swvl.movies.di.module.activitiesModule.*
import com.swvl.movies.ui.home.MovieListActivity
import com.swvl.movies.ui.home.MovieDetailActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {


    @ContributesAndroidInjector(modules = [MoviesActivityModule::class])
    internal abstract fun contributeLearningPathwayActivity(): MovieListActivity
    @ContributesAndroidInjector(modules = [MovieDetailActivityModule::class])
    internal abstract fun contributeLessonDetailActivity(): MovieDetailActivity

}