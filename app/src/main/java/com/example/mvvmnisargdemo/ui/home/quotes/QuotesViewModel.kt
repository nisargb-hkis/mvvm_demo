package com.example.mvvmnisargdemo.ui.home.quotes

import androidx.lifecycle.ViewModel
import com.example.mvvmnisargdemo.data.repositories.QuotesRepository
import com.example.mvvmnisargdemo.util.lazyDeferred

class QuotesViewModel(
    repository: QuotesRepository
) : ViewModel() {

    val quotes by lazyDeferred {
        repository.getQuotes()
    }

}
