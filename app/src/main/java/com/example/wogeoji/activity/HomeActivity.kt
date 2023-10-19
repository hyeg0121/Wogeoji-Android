package com.example.wogeoji.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wogeoji.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()
    }
}