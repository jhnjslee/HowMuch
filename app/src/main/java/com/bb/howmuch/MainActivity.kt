package com.bb.howmuch

import android.content.Intent
import android.os.*
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_main.*

@RequiresApi(Build.VERSION_CODES.O)
class MainActivity : AppCompatActivity() {


    companion object {
        var mainCount = 0;
        var endFlag = false
    }

    lateinit var gameTime : TextView
    lateinit var touchCount : TextView
    lateinit var blackView : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gameTime  = findViewById(R.id.textView)
        touchCount  = findViewById(R.id.textView2)
        blackView = findViewById(R.id.blackView)

        touchCount.visibility = View.GONE
        gameTime.visibility = View.GONE
        dosError.visibility = View.GONE

        val lottiecd = findViewById<View>(R.id.countdown) as LottieAnimationView
        val lottie = findViewById<View>(R.id.hearbeat) as LottieAnimationView
        Toasty.info(this,"사랑하는 만큼 화면을 눌러주세요!",Toasty.LENGTH_LONG).show()
        lottie.visibility = View.INVISIBLE
        lottiecd.playAnimation()
        lottiecd.loop(false)
        val mHandler = Handler(Looper.getMainLooper())
            mHandler.postDelayed({
                lottiecd.visibility = View.GONE

                //VISIBLE
                lottie.visibility = View.VISIBLE
                touchCount.visibility = View.VISIBLE
                gameTime.visibility = View.VISIBLE
            }, 5000)


        lottie.setOnClickListener {
            if (!endFlag) {
                lottie.playAnimation()
                lottie.loop(false)
                mainCount++
                Log.d("lottie", mainCount.toString())
                touchCount.text = mainCount.toString()
            }

            if (mainCount == 30) {
                blackView.setBackgroundColor(resources.getColor(R.color.black30))

                touchCount.text = "?!@#$"
                lottie.visibility = View.GONE
                blackView.visibility = View.VISIBLE
                //20에서 한번 사라짐
            } else if (mainCount == 45) {
                lottie.visibility = View.GONE
                blackView.visibility = View.VISIBLE
            }else if (mainCount in 51..61) {
                lottie.pauseAnimation()
                touchCount.text = "?!@#$"
            }else if(mainCount in 61..71){

                touchCount.visibility = View.GONE
                gameTime.visibility = View.GONE
                lottie.visibility = View.GONE
                blackView.visibility = View.GONE
                dosError.visibility = View.VISIBLE
            }else if(mainCount > 71){
                //VISIBLE
                lottie.visibility = View.VISIBLE
                touchCount.visibility = View.VISIBLE
                gameTime.visibility = View.VISIBLE
            }
        }

        blackView.setOnClickListener {
            Log.d("countBv", mainCount.toString())
            mainCount++
            //20에서 등장
            if (mainCount == 35){
                blackView.setBackgroundColor(resources.getColor(R.color.white))
                //25에서 사라짐 25에서 다시 버튼 등장
            }
            else if (mainCount == 37){

                blackView.setBackgroundColor(resources.getColor(R.color.black100))
                gameTime.visibility = View.INVISIBLE
                }
            else if (mainCount == 38){
                blackView.setBackgroundColor(resources.getColor(R.color.white))

            }
            else if (mainCount == 45){
                blackView.setBackgroundColor(resources.getColor(R.color.black0))
                blackView.visibility = View.GONE
                lottie.visibility = View.VISIBLE
            //25에서 사라짐 25에서 다시 버튼 등장
            }
        }

        dosError.setOnClickListener {
            mainCount++
            Log.d("countDos", mainCount.toString())
            if (mainCount == 71){
                dosError.visibility = View.GONE
                lottie.visibility = View.VISIBLE
            //25에서 사라짐 25에서 다시 버튼 등장
        }
        }
        mCountDown.start()
    }

    private val mCountDown: CountDownTimer = object : CountDownTimer(20000, 10) {
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
    override fun onBackPressed() {
        return
    }
}