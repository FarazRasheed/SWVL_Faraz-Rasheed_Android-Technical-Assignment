package com.swvl.movies.di.module

import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Module

@AssistedModule
@Module(includes = [AssistedInject_AssistedInjectionModule::class])
interface AssistedInjectionModule