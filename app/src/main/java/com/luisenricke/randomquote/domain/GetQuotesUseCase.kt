package com.luisenricke.randomquote.domain

import com.luisenricke.randomquote.data.QuoteRepository
import com.luisenricke.randomquote.data.database.entities.toDatabase
import com.luisenricke.randomquote.domain.model.Quote
import javax.inject.Inject


class GetQuotesUseCase @Inject constructor(
    private val repository: QuoteRepository
) {

    suspend operator fun invoke(): List<Quote> {
        val quotes = repository.getAllQuotesFromApi()
        return if (quotes.isNotEmpty()) {
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        } else {
            repository.getAllQuotesFromDatabase()
        }
    }

}