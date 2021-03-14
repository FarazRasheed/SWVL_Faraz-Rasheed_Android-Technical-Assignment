package com.swvl.movies

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.swvl.movies.ui.home.MovieListActivity
import com.swvl.movies.ui.home.MoviesViewModel
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    var viewModel: MoviesViewModel? = null

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.vw.movies", appContext.packageName)
    }

    private lateinit var stringToBetyped: String

    @get:Rule
    var activityRule: ActivityScenarioRule<MovieListActivity>
            = ActivityScenarioRule(MovieListActivity::class.java)
//
    @Before
    fun initValidString() {
        // Specify a valid string.
        stringToBetyped = "Espresso"
    }

    @Test
    fun changeText_sameActivity() {
        // Type text and then press the button.
        viewModel?.getListResponse?.postValue(null)
//        onView(withId(R.id.rvMovies)).perform(RecyclerViewActions.actionOnItemAtPosition<MovieItem>()));


    }
}
