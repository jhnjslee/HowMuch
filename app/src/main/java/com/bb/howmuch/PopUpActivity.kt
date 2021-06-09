package com.bb.howmuch

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView

class PopUpActivity : AppCompatActivity() {

    lateinit var positiveButton : Button
    lateinit var message : TextView
    companion object {
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.custom_dialog)
        val lottie = findViewById<View>(R.id.heart_hand) as LottieAnimationView
        lottie.playAnimation()
        lottie.loop(true)
        positiveButton = findViewById(R.id.positiveButton)
        message = findViewById(R.id.messageTextView)
        setMessage("말로만 사랑한다고 해서 사랑이면 그건 사랑이 아니죠.\n 말보다 행동이 언제나 준비되어 있어야 하지 않을까요? \n 동의하시나요?")
        positiveButton.setOnClickListener {
            okay()
        }
    }


    fun setMessage(message : String){
        this.message.text = message
    }
    fun okay(){
        val mHandler = Handler(Looper.getMainLooper())
        mHandler.postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }, 1000)
        finish()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_OUTSIDE){
            return false
        }
        return true
    }

    override fun onBackPressed() {
        return
    }
}
