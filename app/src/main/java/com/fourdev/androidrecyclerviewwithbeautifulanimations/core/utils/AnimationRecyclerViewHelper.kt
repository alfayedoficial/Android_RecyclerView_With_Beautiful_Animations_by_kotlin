package com.fourdev.androidrecyclerviewwithbeautifulanimations.core.utils

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View

/**
 * Created by ( Eng Ali Al Fayed)
 * Class do : ( RecyclerView Helper Class )
 * Date 4/30/2022 - 3:05 PM
 */
object AnimationRecyclerViewHelper {

    fun View.setFadeInAnimation(position: Int, onAttach: Boolean, duration: Long = 500) {
        var count = position
        if (!onAttach) {
            count = -1
        }
        val isNotFirstItem = count == -1
        count++

        this.alpha = 0f
        val animator = ObjectAnimator.ofFloat(this, "alpha", 0f, 0.5f, 1.0f)
        ObjectAnimator.ofFloat(this, "alpha", 0f).start()
        animator.startDelay = if (isNotFirstItem) duration / 2 else count * duration / 3
        animator.duration = 500

        AnimatorSet().apply {
            play(animator)
            start()
        }

    }

    fun View.setLeftToRightAnimation(position: Int, onAttach: Boolean, duration: Long = 500) {
        var count = position
        if (!onAttach) {
            count = -1
        }
        val isNotFirstItem = count == -1
        count++

        this.translationX = -400f
        this.alpha = 0f
        val animatorTranslateY: ObjectAnimator = ObjectAnimator.ofFloat(this, "translationX", -400f, 0f)
        val animatorAlpha = ObjectAnimator.ofFloat(this, "alpha", 1f)

        ObjectAnimator.ofFloat(this, "alpha", 0f).start()
        animatorTranslateY.startDelay = if (isNotFirstItem) duration else count * duration
        animatorTranslateY.duration = (if (isNotFirstItem) 2 else 1) * duration

        AnimatorSet().apply {
            playTogether(animatorTranslateY, animatorAlpha)
            start()
        }

    }

    fun View.setRightToLeftAnimation(position: Int, onAttach: Boolean, duration: Long = 500) {
        var count = position
        if (!onAttach) {
            count = -1
        }
        val isNotFirstItem = count == -1
        count++

        this.translationX = this.x + 400
        this.alpha = 0f

        val animatorTranslateY: ObjectAnimator = ObjectAnimator.ofFloat(this, "translationX", this.x + 400f, 0f)
        val animatorAlpha = ObjectAnimator.ofFloat(this, "alpha", 1f)
        ObjectAnimator.ofFloat(this, "alpha", 0f).start()
        animatorTranslateY.startDelay = if (isNotFirstItem) duration else count * duration
        animatorTranslateY.duration = (if (isNotFirstItem) 2 else 1) * duration

        AnimatorSet().apply {
            playTogether(animatorTranslateY, animatorAlpha)
            start()
        }

    }

}