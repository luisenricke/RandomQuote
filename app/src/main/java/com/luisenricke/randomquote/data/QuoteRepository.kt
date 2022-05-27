package com.luisenricke.randomquote.data

import com.luisenricke.randomquote.data.model.QuoteModel
import com.luisenricke.randomquote.data.model.QuoteProvider
import com.luisenricke.randomquote.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val provider: QuoteProvider
) {

    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuotes()
        provider.quotes = response
        return response
    }

}
