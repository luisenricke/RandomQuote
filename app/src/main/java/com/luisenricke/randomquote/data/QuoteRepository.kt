package com.luisenricke.randomquote.data

import com.luisenricke.randomquote.data.database.dao.QuoteDao
import com.luisenricke.randomquote.data.database.entities.QuoteEntity
import com.luisenricke.randomquote.data.model.QuoteModel
import com.luisenricke.randomquote.data.network.QuoteService
import com.luisenricke.randomquote.domain.model.Quote
import com.luisenricke.randomquote.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val dao: QuoteDao
) {

    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response: List<QuoteModel> = api.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase(): List<Quote> {
        val response: List<QuoteEntity> = dao.getAll()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes: List<QuoteEntity>) {
        dao.insertAll(quotes)
    }

    suspend fun clearQuotes() {
        dao.deleteAll()
    }

}
