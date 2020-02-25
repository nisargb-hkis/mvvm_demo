package com.example.mvvmnisargdemo.ui.auth

import com.example.mvvmnisargdemo.data.db.entities.User

interface AuthListener {
    fun onStarted()
    fun onSuccess(user: User?)
    fun onFailure(message: String)
}