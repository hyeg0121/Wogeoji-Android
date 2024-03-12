package com.example.wogeoji.activities

import RetrofitClient
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.wogeoji.R
import com.example.wogeoji.domain.User
import com.example.wogeoji.dto.user.SignUpRequest
import com.example.wogeojiapp.service.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity() : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        val signUpButton = findViewById<Button>(R.id.signup_button)
        val nameEditText = findViewById<EditText>(R.id.name_edittext)
        val passwordEditText = findViewById<EditText>(R.id.password_edittext)
        val emailEditText = findViewById<EditText>(R.id.email_edittext)

        signUpButton.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.toString().trim()

            signUpUser(SignUpRequest(name, email, password))

        }

    }

    fun signUpUser(signUpRequest: SignUpRequest) {
        val retrofit = RetrofitClient.getRetrofitInstance();
        val userService = retrofit.create(UserService::class.java)
        val call = userService.signUpUser(signUpRequest)
        
        call.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    val user = response.body()
                    Log.d("my tag", "user" + user.toString())
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {

                // TODO: 실패 했을떄 토스트 메세지
                Log.d("my tag", "error" + t.toString())
            }

        })
    }

}