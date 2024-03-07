package com.example.wogeojiapp.service

import com.example.wogeoji.dto.user.RegistrationRequest
import com.example.wogeoji.domain.User
import com.example.wogeoji.dto.user.LoginRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface UserService {
    @GET("/members/{id}")
    fun getMembers(@Path("id") id: Long): Call<User>

    @POST("/members/member")
    fun postMember(@Body requestBody: RegistrationRequest): Call<RegistrationRequest>

    @POST("/api/users/login")
    fun loginUser(@Body requestBody: LoginRequest): Call<User>

}