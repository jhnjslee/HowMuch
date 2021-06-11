package com.bb.howmuch

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.TextureView
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_another_result.*

class AnotherResult : AppCompatActivity() {

    companion object{
        var titles : Array<String> = arrayOf("","","","")
        var values : Array<Int> = arrayOf(0,0,0,0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_another_result)
        button6.setOnClickListener {
            this.finish()
        }
        makeDialog(titles)

    }

    fun makeDialog(titles : Array<String>){
        textView11.text = makeTextView(titles[0])
        textView21.text = makeTextView(titles[1])
        textView31.text = makeTextView(titles[2])
        textView41.text = makeTextView(titles[3])

        textView12.text = "${values[0]}점"
        textView22.text = "${values[1]}점"
        textView32.text = "${values[2]}점"
        textView42.text = "${values[3]}점"

        imageView1.setImageDrawable(makeImageView(titles[0]))
        imageView2.setImageDrawable(makeImageView(titles[1]))
        imageView3.setImageDrawable(makeImageView(titles[2]))
        imageView4.setImageDrawable(makeImageView(titles[3]))

    }
    fun makeTextView(value : String) : String{
        when (value){
            "a" -> {
                return "인정하는 말"
            }
            "b" -> {
                return "함께하는 시간"
            }
            "c" -> {
                return "선물"
            }
            "d" -> {
                return "봉사와 노력"
            }
            "e" -> {
                return "스킨쉽"
            }
            else -> {
                return "오류"
            }
        }
    }

    fun makeImageView(value : String) : Drawable{
        when (value){
            "a" -> {
                val drawable: Drawable = getResources().getDrawable(R.drawable.ic_like)
                return drawable
            }
            "b" -> {
                val drawable: Drawable = getResources().getDrawable(R.drawable.ic_couple)
                return drawable
            }
            "c" -> {
                val drawable: Drawable = getResources().getDrawable(R.drawable.ic_gift)
                return drawable
            }
            "d" -> {
                val drawable: Drawable = getResources().getDrawable(R.drawable.ic_effort)
                return drawable
            }
            "e" -> {
                val drawable: Drawable = getResources().getDrawable(R.drawable.ic_hug)
                return drawable
            }
            else -> {
                val drawable: Drawable = getResources().getDrawable(R.drawable.ic_hug)
                return drawable
            }
        }
    }
}