package com.luisenricke.randomquote.data

import com.luisenricke.randomquote.data.model.QuoteModel
import com.luisenricke.randomquote.data.model.QuoteProvider
import com.luisenricke.randomquote.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }

}
