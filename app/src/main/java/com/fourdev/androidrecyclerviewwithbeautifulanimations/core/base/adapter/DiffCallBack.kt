package com.fourdev.androidrecyclerviewwithbeautifulanimations.core.base.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

/**
 * Created by ( Eng Ali Al Fayed)
 * Class do : Generic DiffCallBack
 * Date 4/30/2022 - 2:47 PM
 */
class DiffCallBack<T : Any> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean =
        oldItem == newItem

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean =
        oldItem == newItem

}