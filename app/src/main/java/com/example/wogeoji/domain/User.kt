package com.example.wogeoji.domain

import java.util.Date

data class User(
    val id: Long,
    val name: String,
    val email: String,
    val password: String,
    val bio: String?,
    val profileImagePath: String?,
    val spentAmount: Int,
    val isDelted: Int,
    val createdAt: Date,
    val updatedAt: Date,
)
