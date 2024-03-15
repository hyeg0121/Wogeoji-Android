package com.example.wogeoji.activities

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.wogeoji.MainActivity
import com.example.wogeoji.R
import com.example.wogeoji.util.SharedPreferencesHelper

class IndexActivity : AppCompatActivity() {

    lateinit var sharedPreferencesHelper: SharedPreferencesHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)

        sharedPreferencesHelper = SharedPreferencesHelper
        sharedPreferencesHelper.init(this)

        // 로그인 정보가 이미 저장되어 있는지 확인
        if (sharedPreferencesHelper.containsUserPk()) {
            navigateToMainActivity()
            return
        }

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

    // MainActivity로 이동하는 함수
    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}