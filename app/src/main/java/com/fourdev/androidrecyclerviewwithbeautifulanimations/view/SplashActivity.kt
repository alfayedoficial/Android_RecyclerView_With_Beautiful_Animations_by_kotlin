package com.fourdev.androidrecyclerviewwithbeautifulanimations.view

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContentProviderCompat.requireContext
import com.alfayedoficial.kotlinutils.*
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.fourdev.androidrecyclerviewwithbeautifulanimations.R
import com.fourdev.androidrecyclerviewwithbeautifulanimations.databinding.ActivitySplashBinding
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ActivitySplashBinding.inflate(layoutInflater).apply {
            setContentView(root)

            MainScope().launch {

                    textView.kuHide()
                    imgCompany.kuHide()
                    lyParent.setAnimation(Techniques.FadeIn , duration = 1000)
                    delay(500)
                    delay(1000)

                    textView.kuShow()
                    textView.setAnimation(Techniques.FadeIn , duration = 1700)
                    delay(700)
                    imgCompany.kuShow()
                    imgCompany.setAnimation(Techniques.FadeIn , duration = 1000)

                delay(3700)

                kuClearIntentClass(MainActivity::class.java)
            }
            
        }
    }

    private fun View.setAnimation(techniques : Techniques, duration : Long = 700, times : Int = 0){
        YoYo.with(techniques)
            .duration(duration)
            .repeat(times)
            .playOn(this)
    }
}