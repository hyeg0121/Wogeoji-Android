package com.example.wogeoji.activities

import RetrofitClient
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.wogeoji.MainActivity
import com.example.wogeoji.R
import com.example.wogeoji.domain.User
import com.example.wogeoji.dto.user.SignInRequest
import com.example.wogeoji.util.SharedPreferencesHelper
import com.example.wogeoji.util.ToastHelper
import com.example.wogeojiapp.service.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var signInButton: Button
    private lateinit var sharedPreferencesHelper: SharedPreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        sharedPreferencesHelper = SharedPreferencesHelper

        emailEditText = findViewById(R.id.email_edittext)
        passwordEditText = findViewById(R.id.pw_edittext)
        signInButton = findViewById(R.id.login_button)

        signInButton.setOnClickListener {
            Log.d("my tag", "click")
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()


            // 이메일 및 비밀 번호 유효성 검사
            if (email.isEmpty() || password.isEmpty()) {
                ToastHelper.showToast(this@SignInActivity, "이메일 또는 비밀번호를 입력해 주세요.")
            } else {

                signInUser(SignInRequest(email, password))
            }

        }

    }

    private fun signInUser(loginRequest: SignInRequest) {
        val retrofit = RetrofitClient.getRetrofitInstance()
        val userService = retrofit.create(UserService::class.java)
        val call = userService.loginUser(loginRequest)

        call.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    val user = response.body()
                    Log.d("my tag", "user" + user.toString())
                    sharedPreferencesHelper.saveLoginInfo(user?.id.toString())
                    navigateToMainActivity()
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                ToastHelper.showToast(this@SignInActivity, "로그인에 실패하였습니다.")
            }

        })
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this@SignInActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}