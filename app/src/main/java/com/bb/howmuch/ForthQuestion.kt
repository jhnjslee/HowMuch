package com.bb.howmuch

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import es.dmoral.toasty.Toasty

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ForthQuestion.newInstance] factory method to
 * create an instance of this fragment.
 */
class ForthQuestion : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var mContext : Context
    lateinit var nextBtn : Button
    private var result : Array<String> = arrayOf("","","","","","","")

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
        val view : View = inflater.inflate(R.layout.fragment_forth_question, container, false)

        val radioGroup1 = view.findViewById(R.id.rg1) as RadioGroup
        radioGroup1.setOnCheckedChangeListener { group, checkedId ->
            val radioButton = view.findViewById(checkedId) as RadioButton
            result[0] = radioButton.text as String
            Log.d("1", checkedId.toString() +" "+ radioButton.text)
        }
        val radioGroup2 = view.findViewById(R.id.rg2) as RadioGroup
        radioGroup2.setOnCheckedChangeListener { group, checkedId ->
            val radioButton = view.findViewById(checkedId) as RadioButton
            result[1] = radioButton.text as String
            Log.d("1", checkedId.toString() +" "+ radioButton.text)
        }
        val radioGroup3 = view.findViewById(R.id.rg3) as RadioGroup
        radioGroup3.setOnCheckedChangeListener { group, checkedId ->
            val radioButton = view.findViewById(checkedId) as RadioButton
            result[2] = radioButton.text as String
            Log.d("1", checkedId.toString() +" "+ radioButton.text)
        }
        val radioGroup4 = view.findViewById(R.id.rg4) as RadioGroup
        radioGroup4.setOnCheckedChangeListener { group, checkedId ->
            val radioButton = view.findViewById(checkedId) as RadioButton
            result[3] = radioButton.text as String
            Log.d("1", checkedId.toString() +" "+ radioButton.text)
        }
        val radioGroup5 = view.findViewById(R.id.rg5) as RadioGroup
        radioGroup5.setOnCheckedChangeListener { group, checkedId ->
            val radioButton = view.findViewById(checkedId) as RadioButton
            result[4] = radioButton.text as String
            Log.d("1", checkedId.toString() +" "+ radioButton.text)
        }
        val radioGroup6 = view.findViewById(R.id.rg6) as RadioGroup
        radioGroup6.setOnCheckedChangeListener { group, checkedId ->
            val radioButton = view.findViewById(checkedId) as RadioButton
            result[5] = radioButton.text as String
            Log.d("1", checkedId.toString() +" "+ radioButton.text)
        }
        val radioGroup7 = view.findViewById(R.id.rg7) as RadioGroup
        radioGroup7.setOnCheckedChangeListener { group, checkedId ->
            val radioButton = view.findViewById(checkedId) as RadioButton
            result[6] = radioButton.text as String
            Log.d("1", checkedId.toString() +" "+ radioButton.text)
        }


        nextBtn = view.findViewById(R.id.nextBtn)
        nextBtn.setOnClickListener {
            if (checkOk(result)){
                sumSecondQuestion(result)
                (activity as Question?)?.replaceFragment(FifthQuestion.newInstance("",""),"","")
            }else{
                //Toasty
                Toasty.warning(mContext, "모든 사항을 체크해 주세요", Toast.LENGTH_SHORT, true).show();
            }
        }

        return view
    }

    fun checkOk(array : Array<String>) : Boolean{
        return !array.contains("")
    }
    fun sumSecondQuestion(array: Array<String>){
        var count = 0
        //B C A D B A D E
        array.forEach { it ->
            when(count){
                0->{
                    when(it){
                        "그렇다"->{
                            ResultActivity.addPointB(1)
                        }
                    }
                }
                1->{when(it){
                    "그렇다"->{
                        ResultActivity.addPointC(1)
                    }
                }}
                2->{when(it){
                    "그렇다"->{
                        ResultActivity.addPointA(1)
                    }
                }}
                3->{when(it){
                    "그렇다"->{
                        ResultActivity.addPointD(1)
                    }
                }}
                4->{when(it){
                    "그렇다"->{
                        ResultActivity.addPointB(1)
                    }
                }}
                5->{when(it){
                    "그렇다"->{
                        ResultActivity.addPointA(1)
                    }
                }}
                6->{when(it){
                    "그렇다"->{
                        ResultActivity.addPointD(1)
                    }
                }}
            }
            count++
        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ForthQuestion.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ForthQuestion().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}