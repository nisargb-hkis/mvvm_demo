package com.example.mvvmnisargdemo.data.network.responses

import com.example.mvvmnisargdemo.data.db.entities.User

data class AuthResponse(
    val isSuccessful : Boolean?,
    val message: String?,
    val user: User?
)