package com.bb.howmuch

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class Question : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment, FirstQuestion().apply {
                        arguments = Bundle().apply {
                            putString(
                                "deviceAddress", "pass"
                            )
                        }
                    }).commitAllowingStateLoss()
    }

    fun replaceFragment(fragment: Fragment?, next : String, next2 : String) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        if (fragment != null) {
            fragmentTransaction.replace(R.id.fragment, fragment.apply {
                arguments = Bundle().apply {
                    putString(
                        next, next2
                    )
                }
            })
                .commit()
        } // Fragment로 사용할 MainActivity내의 layout공간을 선택합니다.
    }
    fun moveToMain() {
        val mHandler = Handler(Looper.getMainLooper())
        mHandler.postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }, 1000)
    }
}