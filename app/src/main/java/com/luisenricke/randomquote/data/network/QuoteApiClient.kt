package com.luisenricke.randomquote.data.network

import com.luisenricke.randomquote.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {

    @GET("/.json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>

}