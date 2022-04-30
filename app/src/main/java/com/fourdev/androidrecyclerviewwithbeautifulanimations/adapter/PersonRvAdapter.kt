package com.fourdev.androidrecyclerviewwithbeautifulanimations.adapter

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.alfayedoficial.kotlinutils.kuGetBindingRow
import com.fourdev.androidrecyclerviewwithbeautifulanimations.BR
import com.fourdev.androidrecyclerviewwithbeautifulanimations.R
import com.fourdev.androidrecyclerviewwithbeautifulanimations.core.base.adapter.BaseAdapter
import com.fourdev.androidrecyclerviewwithbeautifulanimations.core.base.adapter.BaseViewHolder
import com.fourdev.androidrecyclerviewwithbeautifulanimations.core.base.adapter.DiffCallBack
import com.fourdev.androidrecyclerviewwithbeautifulanimations.core.utils.AnimationRecyclerViewHelper.setFadeInAnimation
import com.fourdev.androidrecyclerviewwithbeautifulanimations.core.utils.AnimationRecyclerViewHelper.setLeftToRightAnimation
import com.fourdev.androidrecyclerviewwithbeautifulanimations.core.utils.AnimationRecyclerViewHelper.setRightToLeftAnimation
import com.fourdev.androidrecyclerviewwithbeautifulanimations.databinding.ItemRvPersonBinding
import com.fourdev.androidrecyclerviewwithbeautifulanimations.model.Person


/**
 * Created by ( Eng Ali Al Fayed)
 * Class do : ( PersonRvAdapter )
 * Date 4/30/2022 - 2:47 PM
 */
class PersonRvAdapter : BaseAdapter<Person>() {

    var duration: Long = 500
    private var onAttach = true
    private var animationStory : Int = 0

    inner class PersonVewHolder(dataBinding : ItemRvPersonBinding) : BaseViewHolder<Person>(dataBinding) {

        override var itemRowBinding: ViewDataBinding = dataBinding

        override fun bind(result: Person) {
            itemRowBinding.apply {
                setVariable(BR.model, result)
                executePendingBindings()
            }
        }

    }

    private var mDiffer = AsyncListDiffer(this, DiffCallBack<Person>())
    private var dataList: List<Person> = arrayListOf()

    override fun setDataList(dataList: List<Person>) {
        this.dataList = dataList
        mDiffer.submitList(dataList)
    }

    override fun addDataList(dataList: List<Person>) {
        clearDataList()
        setDataList(dataList)
    }

    override fun clearDataList() {
        this.dataList = arrayListOf()
    }

    fun getSetAnimation(animationStatus : Int = 0){
        this.animationStory = animationStatus
       notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Person> {
        return PersonVewHolder(kuGetBindingRow(parent, R.layout.item_rv_person) as ItemRvPersonBinding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Person>, position: Int) {
        val model = mDiffer.currentList[position]
        holder.apply {
            bind(model)
            itemView.also {
                when(animationStory){
                    0 -> it.setFadeInAnimation(position, onAttach,duration)
                    1 -> it.setLeftToRightAnimation(position, onAttach,duration)
                    2 -> it.setRightToLeftAnimation(position, onAttach,duration)
                }
            }
        }
    }

    override fun getItemCount(): Int = mDiffer.currentList.size

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                onAttach = false
                super.onScrolled(recyclerView, dx, dy)

            }
        })
        super.onAttachedToRecyclerView(recyclerView)
    }



}