package com.fourdev.androidrecyclerviewwithbeautifulanimations.core.base.adapter

import androidx.recyclerview.widget.RecyclerView

/**
 * Created by ( Eng Ali Al Fayed)
 * Class do : Generic Adapter for all Adapter
 * Date 4/30/2022 - 2:47 PM
 */
abstract class BaseAdapter<T> : RecyclerView.Adapter<BaseViewHolder<T>>() {

    abstract fun setDataList(dataList: List<T>)

    abstract fun addDataList(dataList: List<T>)

    abstract fun clearDataList()

}

