package com.example.wogeoji.service

import com.example.wogeoji.dto.RegistrationRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/members/member") // "register"는 회원가입 엔드포인트 URL로 변경해야 합니다.
    fun register(@Body registrationRequest: RegistrationRequest): Call<RegistrationRequest>
}
