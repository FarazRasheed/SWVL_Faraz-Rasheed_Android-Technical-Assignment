package com.swvl.movies.di.component

import android.app.Application
import com.swvl.movies.application.MyApplication
import com.swvl.movies.di.assistedFactory.LinearLayoutMangerAIF
import com.swvl.movies.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton
import dagger.android.support.AndroidSupportInjectionModule

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        AssistedInjectionModule::class,
        ViewModelModule::class,
        ActivitiesModule::class,
        FragmentsModule::class,
        NetworkServiceModule::class,
        NetworkRequestModule::class,
        RepositoriesModule::class,
        CustomPopupModule::class
    ]
)
interface AppComponent : AndroidInjector<MyApplication> {

    override fun inject(instance: MyApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    val linearLayoutMangerAIF: LinearLayoutMangerAIF.Factory
}