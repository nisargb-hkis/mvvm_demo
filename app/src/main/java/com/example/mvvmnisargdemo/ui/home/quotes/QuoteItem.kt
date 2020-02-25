package com.example.mvvmnisargdemo.ui.home.quotes

import com.example.mvvmnisargdemo.R
import com.example.mvvmnisargdemo.data.db.entities.Quote
import com.example.mvvmnisargdemo.databinding.ItemQuoteBinding
import com.xwray.groupie.databinding.BindableItem

class QuoteItem (
    private val quote: Quote
): BindableItem<ItemQuoteBinding>(){

    override fun getLayout()= R.layout.item_quote

    override fun bind(viewBinding: ItemQuoteBinding, position: Int) {
        viewBinding.setQuote(quote)
    }

}