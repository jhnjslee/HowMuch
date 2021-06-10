package com.bb.howmuch

import android.R.drawable
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.*
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.codemybrainsout.ratingdialog.RatingDialog
import com.codemybrainsout.ratingdialog.RatingDialog.Builder.*
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.android.synthetic.main.activity_result_popup.*
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

        lateinit var ask: Drawable

        fun setInfo(info: String){
            this.personalInfo = info
        }

        fun addPointA(point: Int){
            this.a += point
        }
        fun addPointB(point: Int){
            this.b += point
        }
        fun addPointC(point: Int){
            this.c += point
        }
        fun addPointD(point: Int){
            this.d += point
        }
        fun addPointE(point: Int){
            this.e += point
        }
    }


    // 인정하는 말
    // 함께하는 시간
    // 선물
    // 봉사
    // 스킨쉽

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        resultImage = findViewById(R.id.imageView3)
        resultTitle = findViewById(R.id.textView17)
        resultContents = findViewById(R.id.textView19)
        mainScore = findViewById(R.id.textView20)
        ask = getResources().getDrawable(R.drawable.ic_couple)
        val str = personalInfo
        val arr = str.split("$$")

        val mm = mutableMapOf("a" to a, "b" to b, "c" to c, "d" to d, "e" to e)
        var sortedByValue = mm.toList().sortedWith(compareByDescending({ it.second })).toMap()

        when (sortedByValue.keys.first()){
            "a" -> {
                val drawable: Drawable = getResources().getDrawable(R.drawable.ic_like)
                resultImage.setImageDrawable(drawable)
                resultContents.text = "인정하는 말 (상대에 대한 칭찬, 격려)"
                ResultPopup.titleText = "인정하는 말 (상대에 대한 칭찬, 격려)"
            }
            "b" -> {
                val drawable: Drawable = getResources().getDrawable(R.drawable.ic_couple)
                resultImage.setImageDrawable(drawable)
                resultContents.text = "함께하는 시간 (진정한 대화, 취미활동 공유)"
                ResultPopup.titleText = "함께하는 시간 (진정한 대화, 취미활동 공유)"
            }
            "c" -> {
                val drawable: Drawable = getResources().getDrawable(R.drawable.ic_gift)
                resultImage.setImageDrawable(drawable)
                resultContents.text = "선물 (가장 배우기 쉬운 사랑의 언어)"
                ResultPopup.titleText = "선물 (가장 배우기 쉬운 사랑의 언어)"
            }
            "d" -> {
                val drawable: Drawable = getResources().getDrawable(R.drawable.ic_effort)
                resultImage.setImageDrawable(drawable)
                resultContents.text = "봉사와 노력 (원하는 것 몸으로 봉사해주기)"
                ResultPopup.titleText = "봉사와 노력 (원하는 것 몸으로 봉사해주기)"
            }
            "e" -> {
                val drawable: Drawable = getResources().getDrawable(R.drawable.ic_hug)
                resultImage.setImageDrawable(drawable)
                resultContents.text = "스킨쉽 (신체접촉을 통한 교감 증대)"
                ResultPopup.titleText = "스킨쉽 (신체접촉을 통한 교감 증대)"
            }
        }
        // 다른 결과 보기
        button2.setOnClickListener {


            val mHandler = Handler(Looper.getMainLooper())
            mHandler.postDelayed({
                val intent = Intent(this, AnotherResult::class.java)
                startActivity(intent)
            }, 0)

        }

        //내용 복사하기
        button3.setOnClickListener {
            val clipboard: ClipboardManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            var loveText = ""
            when (resultContents.text){
                "인정하는 말 (상대에 대한 칭찬, 격려)" -> {
                    loveText =
                        "서로의 애정과 칭찬의 말을 필요로 하는 사람입니다. 당신은 여러 곳의 잘 쓰여진 구절에서 좋은 말과 동기를 찾고, 행복을 얻죠. 사랑을 표현하는 이 방법에는, 연애 편지와 같은 방법도 있습니다."
                }
                "함께하는 시간 (진정한 대화, 취미활동 공유)" -> {
                    loveText =
                        "바쁜 일정에서, 충실하고 보람있는 시간을 찾아, 육체와 정신 모두를, 함께 있는 사람과 함께 하는 것을 추구합니다. 함께 시간을 나누면서 하는 일이 무엇인지는, 별로 중요하지 않죠. 정말로 중요한 것은 우리가 함께 시간을 보내는 사람이라는것 입니다."
                }
                "선물 (가장 배우기 쉬운 사랑의 언어)" -> {
                    loveText =
                        "작지만 중요한 선물을 통해, 다른 사람을 더 잘 알게 됩니다. 굳이 물질적이고 비싼 선물을 나눌 필요는 없습니다. 여기서 중요한 것은 선물이 얼마나 사려 깊은가 하는 것입니다. 물론 선물에 들어있는 사랑이 더욱 중요하겠죠."
                }
                "봉사와 노력 (원하는 것 몸으로 봉사해주기)" -> {
                    loveText =
                        "헌신적인 행동을 의사 소통하는 수단으로 인식하고 느낍니다. 여기에는 사랑을 담은 식사를 준비하고, 사랑을 나눌 가정을 돌보며, 아플 때 다른 사람을 돌보는 것이 이와 같습니다. 이런 행동들은 단순하지만, 사랑을 나타내고 있다고 생각합니다."
                }
                "스킨쉽 (신체접촉을 통한 교감 증대)" -> {
                    loveText =
                        "자신이 나누는 접촉, 포옹을 즐깁니다. 다른 사람들의 품에 안기고, 손을 든 채로 위로받습니다. 젊은이들은, 이것은 이 신체적 접촉이 주요 사랑 언어 중 하나일 때, 이를 사용하여 위로를 얻습니다. 마사지를 즐기고, 사람들의 무릎에 앉아 있는 것을 좋아합니다."
                }
            }


            val clip = ClipData.newPlainText(
                "label",
                "${arr[5]}님의 [사랑의 5가지 언어] 테스트 결과 : 제 1 사랑의 언어는 '${resultContents.text}' 입니다. ${arr[5]}님은 ${loveText}"
            )
            clipboard.setPrimaryClip(clip)

        }

        //앱 평가하기
        button.setOnClickListener {
            Log.d("v평가","rate")
            val ratingDialog: RatingDialog = RatingDialog.Builder(this)
                .icon(ask)
                .session(7)
                .threshold(3f)
                .title("앱에 대한 평가를 부탁드려도 될까요?")
                .titleTextColor(R.color.black)
                .positiveButtonText("지금 안할래요")
                .negativeButtonText("싫어요")
                .positiveButtonTextColor(R.color.white)
                .negativeButtonTextColor(R.color.grey_500)
                .formTitle("앱 평가 하기")
                .formHint("당신의 생각이 듣고 싶어요")
                .formSubmitText("등록")
                .formCancelText("취소")
                .ratingBarColor(R.color.purple_200)
                .playstoreUrl("YOUR_URL")
                .onThresholdCleared { ratingDialog, rating, thresholdCleared -> //do something
                    ratingDialog.dismiss()
                }
                .onThresholdFailed { ratingDialog, rating, thresholdCleared -> //do something
                    ratingDialog.dismiss()
                }
                .onRatingChanged { rating, thresholdCleared -> }
                .onRatingBarFormSumbit { }.build()


            ratingDialog.show()
        }

        //내용 보기
        button4.setOnClickListener {
            val mHandler = Handler(Looper.getMainLooper())
            mHandler.postDelayed({
                val intent = Intent(this, ResultPopup::class.java)
                startActivity(intent)
            }, 0)
        }

        MobileAds.initialize(this)
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
        if (MainActivity.mainCount < 10) {

        } else {

        }

        mainScore.text = MainActivity.mainCount.toString()+"점"


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