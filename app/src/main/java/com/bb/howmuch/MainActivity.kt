package com.bb.howmuch

import android.content.Intent
import android.os.*
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity


@RequiresApi(Build.VERSION_CODES.O)
class MainActivity : AppCompatActivity() {


    companion object {
        var mainCount = 0;
        var endFlag = false
    }




    lateinit var mainButton : Button
    lateinit var gameTime : TextView
    lateinit var touchCount : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainButton = findViewById(R.id.mainBtn)
        gameTime  = findViewById(R.id.textView)
        touchCount  = findViewById(R.id.textView2)
        mainButton.setOnClickListener {
            if (!endFlag){
                mainCount++
                touchCount.text = mainCount.toString()
            }else if(mainCount > 33 ){
            }

        }
        mCountDown.start()
    }

    private val mCountDown: CountDownTimer = object : CountDownTimer(15000, 10) {
        override fun onTick(millisUntilFinished: Long) {
            gameTime.text = ("${(millisUntilFinished.toFloat() / 1000.0f)}")
        }

        override fun onFinish() {
            //countdown finish
            endFlag = true
            val mHandler = Handler(Looper.getMainLooper())
            mHandler.postDelayed({
                val intent = Intent(this@MainActivity, ResultActivity::class.java)
                startActivity(intent)
            }, 1000)
        }

    }
}