package com.example.mvvmnisargdemo.data.repositories

import com.example.mvvmnisargdemo.data.db.AppDatabase
import com.example.mvvmnisargdemo.data.db.entities.User
import com.example.mvvmnisargdemo.data.network.MyApi
import com.example.mvvmnisargdemo.data.network.SafeApiRequest
import com.example.mvvmnisargdemo.data.network.responses.AuthResponse

class UserRepository(
    private val api: MyApi,
    private val db: AppDatabase
) : SafeApiRequest() {

    suspend fun userLogin(email: String, password: String): AuthResponse {
        return apiRequest {
            api.userLogin(email, password)
        }
    }

    suspend fun userSignUp(
        name: String,
        email: String,
        password: String
    ): AuthResponse{
        return apiRequest {
            api.userSignup(name!!, email!!, password!!)
        }
    }

    suspend fun saveUser(user: User) = db.getUserDao().upsert(user)

    fun getUser() = db.getUserDao().getuser()

}