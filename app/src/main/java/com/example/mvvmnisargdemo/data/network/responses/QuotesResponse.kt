package com.example.mvvmnisargdemo.data.network.responses

import com.example.mvvmnisargdemo.data.db.entities.Quote

data class QuotesResponse (
    val isSuccessful: Boolean,
    val quotes: List<Quote>
)