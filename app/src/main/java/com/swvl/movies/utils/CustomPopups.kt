package com.swvl.movies.utils

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.LinearLayout
import android.widget.TextView
import com.swvl.movies.R
import java.lang.NullPointerException


@Suppress("IfThenToSafeAccess")
class CustomPopups {

    private lateinit var onClick: OnClick

    fun showAlertPopup(title: String, message: String, activity: Activity, onClick: OnClick?) {
        if(onClick != null)
            this.onClick = onClick
        val dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.layout_alert_puopup)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val window = dialog.window
        window!!.setLayout(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        window.setWindowAnimations(R.style.FadeInOutDialogAnimation)
        dialog.show()

        dialog.findViewById<TextView>(R.id.tvDetail).text = message
        dialog.findViewById<TextView>(R.id.tvHeading).text = title

        dialog.findViewById<View>(R.id.tvOk)
            .setOnClickListener {
                try {
                    dialog.dismiss()
                    if(onClick != null)
                        onClick.onBackPress()
                } catch (ex: NullPointerException){
                    Log.e("PopupClickException","$ex")
                }
            }
    }

    interface OnClick {
        fun onBackPress()
    }
}
