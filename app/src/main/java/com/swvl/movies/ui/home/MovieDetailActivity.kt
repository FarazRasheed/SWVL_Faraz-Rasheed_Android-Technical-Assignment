package com.swvl.movies.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.observe
import com.swvl.movies.R
import com.swvl.movies.databinding.ActivityMovieDetailBinding
import com.swvl.movies.services.dataModels.movie.Movie
import com.swvl.movies.services.dataModels.movie.MoviesDTO
import com.swvl.movies.services.dataModels.picture.PhotoDTO
import com.swvl.movies.ui.base.BaseActivity
import com.swvl.movies.utils.*
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.activity_movie_list.*
import javax.inject.Inject


class MovieDetailActivity : BaseActivity<ActivityMovieDetailBinding, MoviesViewModel>() {

    override fun getViewModelClass(): Class<MoviesViewModel> = MoviesViewModel::class.java

    @Inject
    lateinit var progressHUD: ProgressHUD

    private lateinit var movieItem: Movie

    override fun layoutId(): Int = R.layout.activity_movie_detail
    private var genreData: StringBuilder? = StringBuilder()
    private var castData: StringBuilder? = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()

    }

    private fun initViews() {
        movieItem = MoviesAdapter.movieItem
        binding.unit = movieItem
        findGenres()
        setObservables()
        when {
            Validation.isConnected(this) -> {
                viewModel.getList(movieItem.title)
            }
        }
    }

    private fun findGenres() {
        movieItem.genres.forEach { i ->
            genreData?.append(" | $i")
        }
        movieItem.cast.forEach { cast ->
            castData?.append(" | ${cast}")
        }
        binding.genres = genreData.toString()
        binding.cast = castData.toString().substring(3)
    }

    private fun setObservables() {
        viewModel.getListResponse().observe(this) {
            when (it) {
                is String -> {
                    showSnackBar(rootView, it)
                }

                is PhotoDTO -> {
                    val moviesData: PhotoDTO = it as PhotoDTO
                    if (!moviesData.photos.photo.isNullOrEmpty()){
                        val url: String = "https://live.staticflickr.com/"+moviesData.photos.photo[0].server+"/"+moviesData.photos.photo[0].id+"_"+moviesData.photos.photo[0].secret+"_q.jpg"
                        movieItem.imageUrl = url
                        ImageLoader.setImageResource(this, url, binding.ivMedia)
                    }
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
