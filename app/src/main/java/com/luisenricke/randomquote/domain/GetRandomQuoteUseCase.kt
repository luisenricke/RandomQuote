package com.luisenricke.randomquote.domain

import com.luisenricke.randomquote.data.model.QuoteModel
import com.luisenricke.randomquote.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val provider: QuoteProvider
) {

    operator fun invoke(): QuoteModel? {
        val quotes = provider.quotes
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }

}
