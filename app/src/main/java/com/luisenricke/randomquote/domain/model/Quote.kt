package com.luisenricke.randomquote.domain.model

import com.luisenricke.randomquote.data.database.entities.QuoteEntity
import com.luisenricke.randomquote.data.model.QuoteModel

data class Quote(
    val quote: String,
    val author: String
)

fun QuoteModel.toDomain() = Quote(quote, author)

fun QuoteEntity.toDomain() = Quote(quote, author)
