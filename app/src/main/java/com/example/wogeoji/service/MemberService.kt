package com.example.wogeojiapp.service

import com.example.wogeoji.dto.RegistrationRequest
import com.example.wogeoji.domain.Member
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface MemberService {
    @GET("/members/{id}")
    fun getMembers(@Path("id") id: Long): Call<Member>

    @POST("/members/member")
    fun postMember(@Body requestBody: RegistrationRequest): Call<RegistrationRequest>

}