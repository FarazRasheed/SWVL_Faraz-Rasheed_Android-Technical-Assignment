package com.swvl.movies.di.assistedFactory

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

class LinearLayoutMangerAIF @AssistedInject constructor(@Assisted context: Context): LinearLayoutManager(context){

    @AssistedInject.Factory
    interface Factory{
        fun create(context: Context): LinearLayoutMangerAIF
    }
}