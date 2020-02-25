package com.example.mvvmnisargdemo.data.repositories

import com.example.mvvmnisargdemo.data.network.MoviesApi
import com.example.mvvmnisargdemo.data.network.SafeApiRequest

class MoviesRepository(
    private val api: MoviesApi
) : SafeApiRequest() {

    suspend fun getMovies() = apiRequest { api.getMovies() }

}