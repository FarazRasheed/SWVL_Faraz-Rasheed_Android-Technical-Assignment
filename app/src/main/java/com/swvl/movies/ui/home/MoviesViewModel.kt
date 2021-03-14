package com.swvl.movies.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.swvl.movies.services.repositories.Repository
import com.swvl.movies.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MoviesViewModel @Inject constructor() : BaseViewModel() {

  @Inject
  lateinit var repository: Repository

  val getListResponse: MutableLiveData<Any> = MutableLiveData()
  val isLoading = MutableLiveData<Boolean>()

  fun getListResponse(): LiveData<Any> = getListResponse

  fun getList() {
    isLoading.postValue(true)
    viewModelScope.launch(Dispatchers.IO) {

      runCatching {
        repository.getList()

      }.onSuccess {
        isLoading.postValue(false)

        withContext(Dispatchers.Main) {
          if (it.isSuccessful)
            getListResponse.postValue(it.body())
          else {
            val error = it.errorBody()!!.string()
            getListResponse.postValue(error)
            Log.e("ERROR", error)
          }
        }
      }.onFailure {
        isLoading.postValue(false)
        getListResponse.postValue(it.message)
        Log.e("ERROR", it.message!!)

      }
    }
  }
}