package com.example.wogeoji.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.wogeoji.R
import com.example.wogeoji.activity.HomeActivity

class MyGroupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_group)

        // 버튼들 불러오기
        val backHome = findViewById<ImageView>(R.id.left_arrow)

        // 버튼 누르면 각각의 화면으로 가기
        backHome.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}