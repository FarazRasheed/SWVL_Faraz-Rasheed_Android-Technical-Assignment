package com.swvl.movies.home

import android.os.Build
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.test.core.app.ActivityScenario
import com.swvl.movies.R
import com.swvl.movies.services.dataModels.movie.Movie
import com.swvl.movies.ui.home.MovieListActivity
import kotlinx.android.synthetic.main.activity_movie_list.*
import org.assertj.core.api.Assertions
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
class MovieDetailActivityUnitTest {

    lateinit var activity: MovieListActivity
    var listMovies = arrayListOf<Movie>()

    @Before
    fun setup() {
        ActivityScenario.launch(MovieListActivity::class.java).use { scenario ->
            scenario.onActivity { activity ->
                this.activity = activity
            }
        }

        listMovies.add(Movie(listOf(), listOf(), 5, "Fast and Furious", "","2018"))
        listMovies.add(Movie(listOf(), listOf(), 5, "Fast and Furious 2", "","2019"))
        listMovies.add(Movie(listOf(), listOf(), 5, "Fast and Furious 3", "","2020"))
    }

    @Test
    @Throws(Exception::class)
    fun activity_isNotNll() {
        assertNotNull(activity)
    }

    @Test
    @Throws(Exception::class)
    fun view_isClickWorking() {
        activity.rvMovies.performClick()
    }

    @Test
    @Throws(Exception::class)
    fun recyclerView_testAdapterItemAt0(){
        activity.rvMovies.layoutManager = LinearLayoutManager(activity)
        activity.rvMovies.adapter = activity.adapter
        activity.adapter.updateList(listMovies)
        val viewHolder = activity.adapter.onCreateViewHolder(activity.rvMovies, 0)
        Assertions.assertThat(viewHolder).isNotNull()
        activity.adapter.onBindViewHolder(viewHolder, 0)
        val itemView = activity.rvMovies.findViewHolderForAdapterPosition(0)!!.itemView as CardView
        val constraintLayout = itemView.getChildAt(0) as ConstraintLayout
        val tvName = constraintLayout.getChildAt(1) as TextView
        val view = constraintLayout.getChildAt(2) as View
        assertEquals(tvName.text.toString(), listMovies[0].title)
        assertEquals(View.VISIBLE, tvName.visibility)
        val shadowView = shadowOf(view.background)
        assertEquals(shadowView.createdFromResId, R.color.color80000000)
    }

    @Test
    @Throws(Exception::class)
    fun recyclerView_testAdapterItemAt1(){
        activity.rvMovies.layoutManager = LinearLayoutManager(activity)
        activity.rvMovies.adapter = activity.adapter
        activity.adapter.updateList(listMovies)
        val viewHolder = activity.adapter.onCreateViewHolder(activity.rvMovies, 0)
        Assertions.assertThat(viewHolder).isNotNull()
        activity.adapter.onBindViewHolder(viewHolder, 1)
        val itemView = activity.rvMovies.findViewHolderForAdapterPosition(1)!!.itemView as CardView
        val constraintLayout = itemView.getChildAt(0) as ConstraintLayout
        val tvName = constraintLayout.getChildAt(1) as TextView
        val view = constraintLayout.getChildAt(2) as View
        assertEquals(tvName.text.toString(), listMovies[1].title)
        assertEquals(View.VISIBLE, tvName.visibility)
        val shadowView = shadowOf(view.background)
        assertEquals(shadowView.createdFromResId, R.color.color80000000)
    }
}
