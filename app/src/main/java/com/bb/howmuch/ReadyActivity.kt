package com.bb.howmuch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.airbnb.lottie.LottieAnimationView

class ReadyActivity : AppCompatActivity() {

    lateinit var startBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ready)

        val lottie = findViewById<View>(R.id.think) as LottieAnimationView
        lottie.playAnimation()
        lottie.loop(false)

        startBtn = findViewById(R.id.next_btn)
        startBtn.setOnClickListener {
            startActivity(Intent(this, Question::class.java))
        }
    }


}