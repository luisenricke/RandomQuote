package com.luisenricke.randomquote.domain

import com.luisenricke.randomquote.data.model.QuoteModel
import com.luisenricke.randomquote.data.model.QuoteProvider

class GetRandomQuoteUseCase {

    operator fun invoke(): QuoteModel? {
        val quotes = QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }

}
