package com.bb.howmuch

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PopUpActivity : AppCompatActivity() {

    lateinit var positiveButton : Button
    lateinit var message : TextView
    companion object {
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.custom_dialog)
        positiveButton = findViewById(R.id.positiveButton)
        message = findViewById(R.id.messageTextView)
    }

    fun setMessage(message : String){
        this.message.text = message
    }
    fun okay(v : View){
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
