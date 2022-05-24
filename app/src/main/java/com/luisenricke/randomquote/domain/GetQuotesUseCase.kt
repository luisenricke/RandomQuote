package com.luisenricke.randomquote.domain

import com.luisenricke.randomquote.data.QuoteRepository
import com.luisenricke.randomquote.data.model.QuoteModel

class GetQuotesUseCase {

    private val repository = QuoteRepository()

    suspend operator fun invoke(): List<QuoteModel> = repository.getAllQuotes()

}