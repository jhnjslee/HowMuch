package com.bb.howmuch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {


    lateinit var resultValue : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        resultValue = findViewById(R.id.result)


        if (MainActivity.mainCount < 10) {
            resultValue.text = "loser"
        }
        else{
            resultValue.text = "winner"
        }
    }



}