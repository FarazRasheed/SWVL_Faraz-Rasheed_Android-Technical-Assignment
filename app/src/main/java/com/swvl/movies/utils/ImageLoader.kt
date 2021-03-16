package com.swvl.movies.utils

import android.content.Context
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.swvl.movies.R


object ImageLoader {
    fun setImageResource(context: Context, url: String, image: AppCompatImageView) {

        Glide.with(context)
            .load(url) // image url
            .placeholder(R.drawable.ic_placeholder) // any placeholder to load at start
            .error(R.drawable.ic_placeholder)  // any image in case of error
            .override(200, 200)// resizing
            .centerCrop()
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(image);

    }
}