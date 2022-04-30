package com.fourdev.androidrecyclerviewwithbeautifulanimations.core.base.adapter


import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
/**
 * Created by ( Eng Ali Al Fayed)
 * Class do : Generic ViewHolder for all ViewHolder
 * Date 4/30/2022 - 2:47 PM
 */
abstract class BaseViewHolder<T>(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
    open var itemRowBinding: ViewDataBinding = binding
    abstract fun bind(result: T)
}