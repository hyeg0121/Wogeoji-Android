package com.example.wogeoji.activities

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.wogeoji.R
import com.example.wogeoji.util.SharedPreferencesHelper

class IndexActivity : AppCompatActivity() {

    lateinit var sharedPreferencesHelper: SharedPreferencesHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)

        sharedPreferencesHelper = SharedPreferencesHelper
        sharedPreferencesHelper.init(this)

        // 버튼들 불러오기
        val loginButton = findViewById<Button>(R.id.login_button)

        // 버튼 누르면 각각의 화면으로 가기
        loginButton.setOnClickListener{
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        val joinButton = findViewById<Button>(R.id.join_button)

        joinButton.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

}