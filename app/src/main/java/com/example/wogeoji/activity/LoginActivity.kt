package com.example.wogeoji.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.wogeoji.R
import com.example.wogeoji.domain.Member
import com.example.wogeoji.dto.LoginRequest
import com.example.wogeoji.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Optional

class LoginActivity : AppCompatActivity() {
    val baseUrl = "http://10.0.2.2:8080"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sharedPreferences = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        val memberIdEditText = findViewById<EditText>(R.id.member_id)
        val passwordEditText = findViewById<EditText>(R.id.member_password)
        val loginButton = findViewById<Button>(R.id.login_button)

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val authService = retrofit.create(ApiService::class.java)

        loginButton.setOnClickListener{
            val memberId = memberIdEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            val loginRequest = LoginRequest(memberId, password)

            val call = authService.login(loginRequest)

            call.enqueue(object : Callback<Member> {
                override fun onResponse(call: Call<Member>, response: Response<Member>) {
                    if (response.isSuccessful) {
                        val member = response.body()
                        Log.d("my tag", member.toString())

                        member?.let {
                            editor.putLong("id", member.memberNo)
                            editor.putBoolean("isLoggedIn", true) // 사용자가 로그인 상태임을 나타내는 플래그
                            editor.apply()


                            val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                            startActivity(intent);
                        }
                    } else {
                        Log.d("my tag", "error")
                    }
                }

                override fun onFailure(call: Call<Member>, t: Throwable) {
                    Log.d("my tag", "failure")
                }
            })
        }

    }
}