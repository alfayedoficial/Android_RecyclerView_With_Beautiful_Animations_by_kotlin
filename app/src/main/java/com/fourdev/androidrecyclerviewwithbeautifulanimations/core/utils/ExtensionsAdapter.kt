package com.fourdev.androidrecyclerviewwithbeautifulanimations.core.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter


/**
 * Created by ( Eng Ali Al Fayed)
 * Class do : Adapter Extensions
 * Date 1/1/2021 - 4:59 PM
 */

@BindingAdapter("app:bindString")
fun TextView.setBindString(txtString: String?) {
    if (txtString != null) text = txtString
}

@BindingAdapter("app:bindImage")
fun ImageView.setBindImage(imgResource: Int?) {
    if (imgResource != null) setImageResource(imgResource)
}






