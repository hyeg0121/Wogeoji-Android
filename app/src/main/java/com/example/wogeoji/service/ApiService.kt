package com.example.wogeoji.service

import com.example.wogeoji.domain.Member
import com.example.wogeoji.dto.LoginRequest
import com.example.wogeoji.dto.RegistrationRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import java.util.Optional

interface ApiService {
    @POST("/members/member")
    fun register(@Body registrationRequest: RegistrationRequest): Call<RegistrationRequest>

    @POST("/api/auth/login")
    fun login(@Body request: LoginRequest): Call<Optional<Member>>
}
