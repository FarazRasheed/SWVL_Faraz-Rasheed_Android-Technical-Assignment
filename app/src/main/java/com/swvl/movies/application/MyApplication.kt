package com.swvl.movies.application

import com.swvl.movies.di.component.AppComponent
import com.swvl.movies.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.HasAndroidInjector
import dagger.android.support.DaggerAppCompatActivity

class MyApplication : DaggerApplication(), HasAndroidInjector {
    lateinit var component: AppComponent
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        component =  DaggerAppComponent.builder()
            .application(this)
            .build()
        return component
                .apply{
                    inject(this@MyApplication)
                }
    }
}

val DaggerAppCompatActivity.component get() = (application as MyApplication).component