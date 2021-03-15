package com.swvl.movies.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import com.swvl.movies.R
import com.swvl.movies.databinding.ActivityMovieDetailBinding
import com.swvl.movies.services.dataModels.movie.Movie
import com.swvl.movies.ui.base.BaseActivity
import com.swvl.movies.utils.ProgressHUD
import javax.inject.Inject


class MovieDetailActivity : BaseActivity<ActivityMovieDetailBinding, MoviesViewModel>() {

    override fun getViewModelClass(): Class<MoviesViewModel> = MoviesViewModel::class.java

    @Inject
    lateinit var progressHUD: ProgressHUD

    private lateinit var movieItem: Movie

    override fun layoutId(): Int = R.layout.activity_movie_detail
    private var genreData: StringBuilder? = StringBuilder()
    private var castData: StringBuilder? = StringBuilder()
    var directorsData: StringBuilder? = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()

    }

    private fun initViews() {
        movieItem = MoviesAdapter.movieItem
        binding.unit = Movie
        findGenres()

    }

    private fun findGenres() {
        movieItem.genres.forEach { i ->
            genreData?.append(" | $i")
        }
//        movieItem.cast.forEach { cast ->
//            castData?.append(" | ${cast.name}")
//        }
//        movieItem.directors.forEach { director ->
//            directorsData?.append(" | ${director.name}")
//        }
//        binding.genres = genreData.toString()
//        binding.cast = castData.toString().substring(3)
//        binding.directer = directorsData.toString().substring(3)
    }

    fun playVideo(view: View){
//        if (movieItem.videos.isNotEmpty()){
//            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(movieItem.videos[0].url))
//            startActivity(browserIntent)
//        }
    }
}
