package com.example.wogeojiapp.service

import com.example.wogeoji.domain.User
import com.example.wogeoji.dto.user.SignInRequest
import com.example.wogeoji.dto.user.SignUpRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import java.util.Objects


interface UserService {
    @POST("/api/users/login")
    fun loginUser(@Body requestBody: SignInRequest): Call<User>

    @POST("/api/users")
    fun signUpUser(@Body requestBody: SignUpRequest): Call<User>
}