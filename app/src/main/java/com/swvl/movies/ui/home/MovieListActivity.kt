package com.swvl.movies.ui.home

import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.lifecycle.observe
import com.swvl.movies.R
import com.swvl.movies.databinding.ActivityMovieListBinding
import com.swvl.movies.services.dataModels.movie.MoviesDTO
import com.swvl.movies.ui.base.BaseActivity
import com.swvl.movies.utils.GetLocalJson
import com.swvl.movies.utils.ProgressHUD
import com.swvl.movies.utils.Validation
import com.swvl.movies.utils.showSnackBar
import kotlinx.android.synthetic.main.activity_movie_list.*
import javax.inject.Inject

class MovieListActivity : BaseActivity<ActivityMovieListBinding, MoviesViewModel>() {

    override fun getViewModelClass(): Class<MoviesViewModel> = MoviesViewModel::class.java

    @Inject
    lateinit var progressHUD: ProgressHUD
    override fun layoutId(): Int = R.layout.activity_movie_list

    @Inject
    lateinit var adapter: MoviesAdapter

    lateinit var moviesData: MoviesDTO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        setListeners()
    }

    private fun initViews() {
        rvMovies.adapter = adapter
    }

    private fun setListeners() {
        moviesData = GetLocalJson.getLocalData("movies.json", this)
        if (!moviesData.movies.isNullOrEmpty()) {
            adapter.updateList(moviesData.movies)
        } else {
            showSnackBar(rootView, getString(R.string.no_data))
        }

        etSearch.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                // Your action on done
                hideKeyboard()
                adapter.filter(v.text.toString())

                true
            } else false
        })
        when {
            Validation.isConnected(this) -> {
//                viewModel.getList()
//                setObservables()
            }
        }
    }

    private fun setObservables() {
        viewModel.getListResponse().observe(this) {
            when (it) {
                is String -> {
                    showSnackBar(rootView, it)
                }

            }
        }



        viewModel.isLoading.observe(this) {
            try {
                if (it) showLoader(this.progressHUD) else hideLoader(this.progressHUD)
            } catch (e: Exception) {
                Log.e("error:", e.toString() + "")
            }
        }
    }
}
