package com.bb.howmuch

import android.content.Intent
import android.os.*
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView

@RequiresApi(Build.VERSION_CODES.O)
class MainActivity : AppCompatActivity() {


    companion object {
        var mainCount = 0;
        var endFlag = false
    }

    lateinit var mainButton : Button
    lateinit var gameTime : TextView
    lateinit var touchCount : TextView
    lateinit var broken1 : ImageView
    lateinit var blackView : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gameTime  = findViewById(R.id.textView)
        touchCount  = findViewById(R.id.textView2)
        broken1 = findViewById(R.id.imageView)
        blackView = findViewById(R.id.blackView)
//        blackView.visibility = View.INVISIBLE
        broken1.visibility = View.INVISIBLE


        val lottie = findViewById<View>(R.id.hearbeat) as LottieAnimationView

        lottie.setOnClickListener {
            if (!endFlag){
                lottie.playAnimation()
                lottie.loop(false)
                mainCount++
                touchCount.text = mainCount.toString()
            }
            else if(mainCount == 20){
                blackView.setBackgroundColor(resources.getColor(R.color.black30))
                blackView.visibility = View.VISIBLE
            }
            else if(mainCount == 21){
                blackView.setBackgroundColor(resources.getColor(R.color.black0))
                blackView.visibility = View.VISIBLE
            }
            else if(mainCount == 22){
                blackView.setBackgroundColor(resources.getColor(R.color.black50))
                blackView.visibility = View.VISIBLE
            }
            else if(mainCount == 25){
                blackView.setBackgroundColor(resources.getColor(R.color.black70))
                blackView.visibility = View.VISIBLE
            }
            else if(mainCount == 33 ){
                broken1.visibility = View.VISIBLE
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