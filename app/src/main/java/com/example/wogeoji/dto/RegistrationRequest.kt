package com.example.wogeoji.dto

data class RegistrationRequest(
    val name: String,
    val memberId: String,
    val password: String,
    val email: String
)
