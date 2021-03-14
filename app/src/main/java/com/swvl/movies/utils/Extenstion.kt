package com.swvl.movies.utils

import android.app.Activity
import android.content.Context
import android.widget.Toast
import android.content.Intent
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar

fun Context.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}


fun showSnackBar(view: View, message: String){
    Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()

}
fun ImageView.loadImage(@DrawableRes drawableRes: Int) {
    Glide.with(this).load(drawableRes).fitCenter().into(this)
}

fun ImageView.loadImage(imagePath: String) {
    Glide.with(this).load(imagePath).fitCenter().into(this)
}

fun ImageView.laodImage(url: String){
    Glide.with(this).load(url).into(this)
}

fun navigateActivity(activityClass: Class<out Activity>, activity: Activity, isFinish: Boolean){
    val intent = Intent(activity, activityClass)
    activity.startActivity(intent)
    if(isFinish)
        activity.finish()
}
fun navigateActivityWithExtra(activityClass: Class<out Activity>, activity: Activity, key: String, value: Int, key2: String, value2: Int, isFinish: Boolean){
    val intent = Intent(activity, activityClass)
    intent.putExtra(key, value)
    intent.putExtra(key2, value2)
    activity.startActivity(intent)
    if(isFinish)
        activity.finish()
}

fun navigateActivityWithExtra(activityClass: Class<out Activity>, activity: Activity, key: String, value: Boolean, isFinish: Boolean){
    val intent = Intent(activity, activityClass)
    intent.putExtra(key, value)
    activity.startActivity(intent)
    if(isFinish)
        activity.finish()
}

fun navigateActivityWithExtra(activityClass: Class<out Activity>, activity: Activity, key: String, value: MovieItem, isFinish: Boolean){
    val intent = Intent(activity, activityClass)
//    intent.putExtra(key, value)
    activity.startActivity(intent)
    if(isFinish)
        activity.finish()
}


