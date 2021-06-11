package com.bb.howmuch

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_result_popup.*
import kotlinx.android.synthetic.main.activity_result_popup.view.*

class ResultPopup : AppCompatActivity() {

    companion object{
        var titleText : String = ""
        lateinit var drawable : Drawable

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_result_popup)

        when (titleText){
            "인정하는 말 (상대에 대한 칭찬, 격려)"->{
                val drawable : Drawable = getResources().getDrawable(R.drawable.ic_like)
                imageView5.setImageDrawable(drawable)
                titleTextView.text = "인정하는 말 (상대에 대한 칭찬, 격려)"
                messageTextView.text = "여기에는 서로의 애정과 칭찬의 말을 필요로 하는 사람들이 포함되어 있다. 그들은 여러 곳의 잘 쓰여진 구절에서 좋은 말과 동기를 찾고, 행복을 얻는다. 사랑을 표현하는 이 방법에는, 연애 편지와 같은 방법도 있다.당신의 사랑 언어 중 하나가 사랑을 확인하는 말이나 방식이라면, 당신은 말로 사람들을 격려하고 싶어할 것이다. 단어는 우리보다 강할 수도 있는, 믿을 수 없는 힘을 가지고 있다. 단 몇 초 동안의 짧은 말도, 우리의 행동에 표식을 남긴다. 우리는 확신의 말을 지닌 사랑의 언어를 통해, 우리가 가진 힘을 깨달아야 한다."
            }
            "함께하는 시간 (진정한 대화, 취미활동 공유)"->{
                val drawable : Drawable = getResources().getDrawable(R.drawable.ic_couple)
                imageView5.setImageDrawable(drawable)
                titleTextView.text = "함께하는 시간 (진정한 대화, 취미활동 공유)"
                messageTextView.text = "우리가 사랑하는 사람들을 위해 시간을 보내는 것은, 우리가 느끼는 감정을 표현하는 방법이다. 그것은 우리의 바쁜 일정에서, 충실하고 보람있는 시간을 찾아, 육체와 정신 모두를, 함께 있는 사람과 함께 하는 것을 의미한다. 함께 시간을 나누면서 하는 일이 무엇인지는, 별로 중요하지 않다. 정말로 중요한 것은 우리가 함께 시간을 보내는 사람이다."
            }
            "선물 (가장 배우기 쉬운 사랑의 언어)"->{
                val drawable : Drawable = getResources().getDrawable(R.drawable.ic_gift)
                imageView5.setImageDrawable(drawable)
                titleTextView.text = "선물 (가장 배우기 쉬운 사랑의 언어)"
                messageTextView.text = "어떤 사람들은 선물을 주고 받는 것을 좋아한다. 그러나, 굳이 물질적이고 비싼 선물을 나눌 필요는 없다. 여기서 중요한 것은 선물이 얼마나 사려 깊은가 하는 것이다. 물론 선물에 들어있는 사랑이 더욱 중요하다. 작지만 중요한 선물을 통해, 다른 사람을 더 잘 알게 된다. 다른 말로 표현하자면, 선물은 다른 사람에 대한 사랑을 표현하는 방법이지, 결코 무언가를 쟁취하기 위한 수단이 될 수 없다."
            }
            "봉사와 노력 (원하는 것 몸으로 봉사해주기)"->{
                val drawable : Drawable = getResources().getDrawable(R.drawable.ic_effort)
                imageView5.setImageDrawable(drawable)
                titleTextView.text = "봉사와 노력 (원하는 것 몸으로 봉사해주기)"
                messageTextView.text ="헌신의 행동이란 행동하는 것을 의사 소통하는 수단으로 인식하고 느끼는 것을 의미한다. 여기에는 여러 가지 다른 예가 있다. 사랑을 담은 식사를 준비하고, 사랑을 나눌 가정을 돌보며, 아플 때 다른 사람을 돌보는 것이 이와 같다. 이런 행동들은 단순하지만, 사랑을 나타내고 있다."
            }
            "스킨쉽 (신체접촉을 통한 교감 증대)"->{
                val drawable : Drawable = getResources().getDrawable(R.drawable.ic_hug)
                imageView5.setImageDrawable(drawable)
                titleTextView.text = "스킨쉽 (신체접촉을 통한 교감 증대)"
                messageTextView.text="신체 접촉은 그 단어가 필요 없기 때문에, 가장 단순한 사랑 언어 중 하나이다. 이 언어를 선호하는 사람들은, 자신이 나누는 접촉, 포옹을 즐긴다. 그들은 다른 사람들의 품에 안기고, 손을 든 채로 위로받는다. 젊은이들은, 이것은 이 신체적 접촉이 주요 사랑 언어 중 하나일 때, 이를 사용하여 위로를 얻는다. 그들은 마사지를 즐기고, 사람들의 무릎에 앉아 있는 것을 좋아한다. 이런 유형의 사랑을 즐기는, 나이가 많은 아이들(특히 7세에서 9세 사이의 아이들)은 특이한 방식으로 사랑을 표현할 수 있다. 여기에는 싸움, 레슬링, 축구 또는 등의 스포츠도 있을 수 있다. 아직까지, 그것은 그들이 사랑받고 돌봐지고 있다는 것을 느끼게 하는 신체 접촉의 한 형태이다."
            }
        }



        closeBtn.setOnClickListener {
            this.finish()
        }

    }
}