package com.bb.howmuch

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment


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
    lateinit var nextBtn : Button
    private var result : Array<String> = arrayOf("","","")


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


        nextBtn = view.findViewById(R.id.next_btn)
        nextBtn.setOnClickListener {
            if (checkOk(result)){
                (activity as Question?)?.replaceFragment(SecondQuestion.newInstance("", ""), "", "")
            }else{
                Toasty.error(yourContext, "This is an error toast.", Toast.LENGTH_SHORT, true).show();
            }
         }

        return view
    }

    fun checkOk(array : Array<String>) : Boolean{
        return array.contains("")
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
}