package com.example.mvvmnisargdemo.ui.home.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmnisargdemo.data.network.responses.MoviesResponse
import com.example.mvvmnisargdemo.data.repositories.MoviesRepository
import com.example.mvvmnisargdemo.util.Coroutines
import kotlinx.coroutines.Job

class MoviesViewModel (
    private val repository: MoviesRepository
) : ViewModel() {

    private lateinit var job: Job

    private val _movies = MutableLiveData<List<MoviesResponse>>()
    val movies: LiveData<List<MoviesResponse>>
        get() = _movies

    fun getMovies() {
        job = Coroutines.ioThenMain(
            { repository.getMovies() },
            { _movies.value = it }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}