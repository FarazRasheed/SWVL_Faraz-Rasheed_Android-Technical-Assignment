package com.swvl.movies.home

import android.os.Build
import android.widget.Adapter
import androidx.core.content.ContextCompat
import androidx.test.core.app.ActivityScenario
import com.swvl.movies.R
import com.swvl.movies.services.dataModels.movie.Movie
import com.swvl.movies.ui.home.MovieDetailActivity
import com.swvl.movies.ui.home.MoviesAdapter
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.layout_alert_puopup.*
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.LOLLIPOP])
class MovieListActivityUnitTest {

    lateinit var activity: MovieDetailActivity
    lateinit var movie: Movie
    @Before
    fun setup() {
        MoviesAdapter.movieItem = Movie(listOf(), listOf(), 5,"Fast and Furious 2", "","2021")
        ActivityScenario.launch(MovieDetailActivity::class.java).use { scenario ->
            scenario.onActivity { activity ->
                this.activity = activity
            }
        }
        movie = MoviesAdapter.movieItem
        activity.binding.unit = movie
    }

    @Test
    @Throws(Exception::class)
    fun activity_isNotNll() {
        assertNotNull(activity)
    }

    @Test
    @Throws(Exception::class)
    fun view_isClickWorking() {
        activity.view1.performClick()
        activity.btnPlay.performClick()
    }

    @Test
    @Throws(Exception::class)
    fun textView_isTextSame() {
        assertEquals(activity.tvName.text, movie.title)
        assertEquals(activity.tvYear.text, "(${movie.year})")
        assertEquals(activity.tvRating.text, "${movie.rating}/10")
        assertEquals(activity.tvTime.text, "${120/60} minutes" + null)
        assertEquals(activity.tvLabel.text, activity.getString(R.string.cast))
        assertEquals(activity.tvCast.text, "")
    }

    @Test
    @Throws(Exception::class)
    fun imageView_isDrawableSame() {
        val shadowBtnPlay = shadowOf(activity.btnPlay.background)
        assertEquals(shadowBtnPlay.createdFromResId, R.drawable.ic_play_button)
    }


}
