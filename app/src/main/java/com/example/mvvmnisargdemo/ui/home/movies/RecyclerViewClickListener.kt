package com.example.mvvmnisargdemo.ui.home.movies

import android.view.View
import com.example.mvvmnisargdemo.data.network.responses.MoviesResponse

interface RecyclerViewClickListener {
    fun onRecyclerViewItemClick(view: View, movie: MoviesResponse)
}