package com.swvl.movies.ui.home

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.*
import com.swvl.movies.R
import com.swvl.movies.databinding.ItemMovieBinding
import com.swvl.movies.services.dataModels.movie.Movie
import com.swvl.movies.utils.navigateActivity

open class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    var list: ArrayList<Movie> = arrayListOf()
    var itemsCopy: ArrayList<Movie> = arrayListOf()

    override fun getItemCount(): Int {
        return list.size
    }

    var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_movie, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            bind(list[position], clickListener(list[position]), position)
        }
    }

    private fun clickListener(item: Movie): View.OnClickListener {
        return View.OnClickListener {
            movieItem = item
            navigateActivity(MovieDetailActivity::class.java, context as Activity, false)
        }
    }

    inner class ViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Movie, clickListener: View.OnClickListener, position: Int) {
            with(binding) {
                try {
                    unit = item
                    isVisible = addSections(item, position)
                    listener = clickListener
                    executePendingBindings()
                } catch (ex: Exception) {
                    Log.e("ASSESSMENT_LIST_ERROR", "$ex")
                }
            }
        }
    }

    fun updateList(newList: ArrayList<Movie>) {
        list.clear()
        itemsCopy.clear()
        list.addAll(newList)
        itemsCopy.addAll(newList)
        notifyDataSetChanged()
    }

    companion object {
        lateinit var movieItem: Movie
    }

    open fun filter(text: String) {
        var text = text
        list.clear()
        if (text.isEmpty()) {
            list.addAll(itemsCopy)
        } else {
            text = text.toLowerCase()
            for (item in itemsCopy) {
                if (item.title.toLowerCase().contains(text) || item.year.toLowerCase()
                        .contains(text)
                ) {
                    list.add(item)
                }
            }
        }
        notifyDataSetChanged()
    }

    open fun addSections(item: Movie, position: Int): Boolean {
        return if (position > 0) {
            val currentItem = itemsCopy[position]
            val previousItem = itemsCopy[position - 1]
            currentItem.year != previousItem.year
        }else{
            true
        }
    }
}