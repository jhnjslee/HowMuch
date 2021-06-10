package com.bb.howmuch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager

class AnotherResult : AppCompatActivity() {

    companion object{
        var secondTitle = ""
        var thirdTitle = ""
        var forthTitle = ""
        var fifthTitle = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_another_result)
    }
}