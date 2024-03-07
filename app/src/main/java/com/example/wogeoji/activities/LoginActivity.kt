package com.example.wogeoji.activities

import RetrofitClient
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.wogeoji.R
import com.example.wogeoji.domain.User
import com.example.wogeoji.dto.user.LoginRequest
import com.example.wogeojiapp.service.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception
import kotlin.math.log

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sharedPreferences = getSharedPreferences("myPref", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()

                val emailEditText = findViewById<EditText>(R.id.email_edittext)
                val pwEditText = findViewById<EditText>(R.id.pw_edittext)
                val loginButton = findViewById<Button>(R.id.login_button)

                loginButton.setOnClickListener {
                    val email = emailEditText.text.toString().trim()
                    val pw = pwEditText.text.toString().trim()

                    performLogin(LoginRequest(email, pw))
                }

    }

    fun performLogin(loginRequest: LoginRequest) {
        try {
            val retrofit = RetrofitClient.getRetrofitInstance()
            val userService = retrofit.create(UserService::class.java)
            val call = userService.loginUser(loginRequest)

            call.enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (response.isSuccessful) {
                        val user = response.body()
                        Log.d("my tag", user.toString())
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    // TODO: 실패 했을떄 토스트 메세지
                    Log.d("my tag", t.message.toString())
                }

            })
        } catch (e: Exception) {
            Log.d("mytag", e.message.toString())
        }
    }
}