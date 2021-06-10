package com.bb.howmuch


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.fragment_first_question.*
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstQuestion.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstQuestion : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var numberPicker1 : NumberPicker
    lateinit var numberPicker2 : NumberPicker

    lateinit var nameText : TextView
    lateinit var mContext : Context
    lateinit var nextBtn : Button
    lateinit var button5 : Button
    private var result : Array<String> = arrayOf("", "", "", "", "","")
    // 사용자 성별, 상대방 성별, 관계 , 생년월일 , 생년월일


    override fun onAttach(context: Context) {
        mContext = context

        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_first_question, container, false)

        val radioGroup1 = view.findViewById(R.id.rg1) as RadioGroup
        radioGroup1.setOnCheckedChangeListener { group, checkedId ->
            val radioButton = view.findViewById(checkedId) as RadioButton
            result[0] = radioButton.text as String
            Log.d("1", checkedId.toString() + " " + radioButton.text)
        }
        val radioGroup2 = view.findViewById(R.id.rg2) as RadioGroup
        radioGroup2.setOnCheckedChangeListener { group, checkedId ->
            val radioButton = view.findViewById(checkedId) as RadioButton
            result[1] = radioButton.text as String
            Log.d("1", checkedId.toString() + " " + radioButton.text)
        }
        val radioGroup3 = view.findViewById(R.id.rg3) as RadioGroup
        radioGroup3.setOnCheckedChangeListener { group, checkedId ->
            val radioButton = view.findViewById(checkedId) as RadioButton
            result[2] = radioButton.text as String
            Log.d("1", checkedId.toString() + " " + radioButton.text)
        }

        numberPicker1 = view.findViewById(R.id.numberPicker1)
        numberPicker2 = view.findViewById(R.id.numberPicker2)
        numberPicker1.minValue = 1
        numberPicker2.minValue = 1
        numberPicker1.maxValue = 100
        numberPicker2.maxValue = 100

        numberPicker1.descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS
        numberPicker2.descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS

        numberPicker1.setOnValueChangedListener { numberPicker, i1, i2 ->
            result[3] = i2.toString()
        }
        numberPicker2.setOnValueChangedListener { numberPicker, i1, i2 ->
            /* i2가 변경될 때마다 실행할 when 조건문 */
            result[4] = i2.toString()
        }

        nameText = view.findViewById(R.id.nameText)
        nameText.addTextChangedListener(watcher)


        nextBtn = view.findViewById(R.id.next_btn)
        button5 = view.findViewById(R.id.button5)
        nextBtn.setOnClickListener {
            if (checkOk(result)){
                ResultActivity.a = 0
                ResultActivity.b = 0
                ResultActivity.c = 0
                ResultActivity.d = 0
                ResultActivity.e = 0
                MainActivity.mainCount = 0
                ResultActivity.setInfo("")
                Log.d("r",result[5])
                (activity as Question?)?.replaceFragment(SecondQuestion.newInstance("", ""), "", "")
                ResultActivity.setInfo(result[0] + "$$" + result[1] + "$$" + result[2] + "$$" + result[3] + "$$" + result[4] + "$$" + result[5])
            }
            else{
                //Toasty
                Toasty.warning(mContext, "모든 사항을 입력해 주세요", Toast.LENGTH_SHORT, true).show();
            }
         }

        button5.setOnClickListener {
            val mHandler = Handler(Looper.getMainLooper())
            mHandler.postDelayed({
                val intent = Intent(mContext, ResultActivity::class.java)
                startActivity(intent)
            }, 0)
        }

        return view
    }

    fun checkOk(array: Array<String>) : Boolean{
        return !array.contains("")
    }
    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstQuestion().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    val watcher: TextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable) {}
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            result[5] = s.toString()
        }
    }
}