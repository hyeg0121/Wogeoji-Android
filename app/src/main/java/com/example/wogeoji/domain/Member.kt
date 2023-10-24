package com.example.wogeoji.domain

data class Member(
    val memberNo: Long,
    val name: String,
    val memberId: String,
    val password: String,
    val email: String,
    val groups: Set<Group>
)
