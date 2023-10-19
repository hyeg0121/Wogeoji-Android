package com.example.wogeoji.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.wogeoji.R
import com.example.wogeoji.dto.RegistrationRequest
import com.example.wogeoji.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JoinActivity : AppCompatActivity() {

    val baseUrl = "http://10.0.2.2:8080"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        val loginButton = findViewById<Button>(R.id.login_button)
        val nameEditText = findViewById<EditText>(R.id.name_edittext)
        val idEditText = findViewById<EditText>(R.id.id_edittext)
        val passwordEditText = findViewById<EditText>(R.id.password_edittext)
        val emailEditText = findViewById<EditText>(R.id.email_edittext)

        // 레트로핏
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)

        loginButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val id = idEditText.text.toString()
            val password = passwordEditText.text.toString()
            val email = emailEditText.text.toString()
            val member = RegistrationRequest(name, id, password, email)

            val call = apiService.register(member)

            call.enqueue(object : Callback<RegistrationRequest> {
                override fun onResponse(call: Call<RegistrationRequest>, response: Response<RegistrationRequest>) {
                    val res = response
                    res.let {
                        Log.d("my tag", res.toString())
                    }
                }

                override fun onFailure(call: Call<RegistrationRequest>, t: Throwable) {
                    Log.d("my tag", "fail")
                }

            })
        }

    }

}