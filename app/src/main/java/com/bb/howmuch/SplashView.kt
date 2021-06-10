package com.bb.howmuch

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import com.airbnb.lottie.LottieAnimationView
import kotlinx.android.synthetic.main.activity_splash_view.*

class SplashView : AppCompatActivity() {

    private val SPLASH_TIME_OUT:Long = 3000 // 1 sec


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_view)

        val lottie = findViewById<View>(R.id.hearbeat) as LottieAnimationView
        lottie.playAnimation()
        lottie.loop(true)

        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

            startActivity(Intent(this, ReadyActivity::class.java))

            // close this activity
            finish()
        }, SPLASH_TIME_OUT)
    }
}