package com.swvl.movies.utils;

import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.swvl.movies.R;

public class ImageLoadAdapter {
    @BindingAdapter("loadImage")
    public static void loadImage(ImageView view, String url) {
        if(url != null && !url.isEmpty()){
            Log.e("URL", url);
            Glide.with(view)
                    .load(url) // image url
                    .placeholder(R.drawable.ic_placeholder) // any placeholder to load at start
                    .error(R.color.colorPrimary)  // any image in case of error
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(view);
        }
    }
}
