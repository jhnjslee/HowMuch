package com.bb.howmuch

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import java.util.*

class ResultActivity : AppCompatActivity() {


    lateinit var resultValue : TextView
    lateinit var mAdView : AdView
    lateinit var resultImage : ImageView
    lateinit var resultTitle : TextView
    lateinit var resultContents : TextView
    lateinit var mainScore : TextView


    companion object {
        var personalInfo : String = ""
        var result : String = ""
        var loveCount : Int  = 0
        var a : Int = 0
        var b : Int = 0
        var c : Int = 0
        var d : Int = 0
        var e : Int = 0

        fun setInfo(info : String){
            this.personalInfo = info
        }

        fun addPointA(point : Int){
            this.a += point
        }
        fun addPointB(point : Int){
            this.b += point
        }
        fun addPointC(point : Int){
            this.c += point
        }
        fun addPointD(point : Int){
            this.d += point
        }
        fun addPointE(point : Int){
            this.e += point
        }
    }


    // 인정하는 말
    // 함께하는 시간
    // 선물
    // 봉사
    // 스킨쉽

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        resultValue = findViewById(R.id.result)
        resultImage = findViewById(R.id.imageView3)
        resultTitle = findViewById(R.id.textView17)
        resultContents = findViewById(R.id.textView19)
        mainScore = findViewById(R.id.textView20)

        val mm = mutableMapOf("a" to a,"b" to b,"c" to c,"d" to d,"e" to e)
        var sortedByValue = mm.toList().sortedWith(compareByDescending({it.second})).toMap()
//
//        var arr = arrayOf(a, b, c, d, e)
//        arr.sortDescending()
//        println(Arrays.toString(arr))
        when (sortedByValue[0]){
            a->{
                val drawable : Drawable = getResources().getDrawable(R.drawable.ic_like)
                resultImage.setImageDrawable(drawable)
                resultTitle.text = "인정하는 말 (상대에 대한 칭찬, 격려)"
            }
            b->{
                val drawable : Drawable = getResources().getDrawable(R.drawable.ic_couple)
                resultImage.setImageDrawable(drawable)
                resultTitle.text = "함께하는 시간 (진정한 대화, 취미활동 공유)"
            }
            c->{
                val drawable : Drawable = getResources().getDrawable(R.drawable.ic_gift)
                resultImage.setImageDrawable(drawable)
                resultTitle.text = "선물 (가장 배우기 쉬운 사랑의 언어)"
            }
            d->{
                val drawable : Drawable = getResources().getDrawable(R.drawable.ic_effort)
                resultImage.setImageDrawable(drawable)
                resultTitle.text = "봉사와 노력 (원하는 것 몸으로 봉사해주기)"
            }
            e->{
                val drawable : Drawable = getResources().getDrawable(R.drawable.ic_hug)
                resultImage.setImageDrawable(drawable)
                resultTitle.text = "스킨쉽 (신체접촉을 통한 교감 증대)"
            }
        }


        MobileAds.initialize(this)
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
        if (MainActivity.mainCount < 10) {
            resultValue.text = "${personalInfo} = ${a} , ${b}, ${c}, ${d}, ${e} : ${MainActivity.mainCount}"
        } else {
            resultValue.text = "${personalInfo} = ${a} , ${b}, ${c}, ${d}, ${e} : ${MainActivity.mainCount}"
        }

        mainScore.text = MainActivity.mainCount.toString()


        mAdView.adListener = object : AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

//            override fun onAdFailedToLoad(adError: LoadAdError) {
//                // Code to be executed when an ad request fails.
//            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        }
    }


}