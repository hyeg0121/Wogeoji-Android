package com.example.wogeoji.domain

import java.time.LocalDateTime
import java.util.Date

data class User(
    val isDeleted: Int,
    val createdAt: String,
    val updatedAt: String,
    val id: Long,
    val name: String,
    val email: String,
    val password: String,
    val bio: String,
    val profileImagePath: String,
    val spentAmount: Int
)
