package com.luisenricke.randomquote.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luisenricke.randomquote.data.model.QuoteModel
import com.luisenricke.randomquote.data.memory.QuoteMemory
import com.luisenricke.randomquote.domain.GetQuotesUseCase
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    var getQuotesUseCase = GetQuotesUseCase()

    fun onCreate() {
        viewModelScope.launch {
            val result = getQuotesUseCase()

            if (!result.isNullOrEmpty()) {
                quoteModel.postValue(result[0])
            }
        }
    }

    fun randomQuote() {
        val currentQuote = QuoteMemory.random()
        quoteModel.postValue(currentQuote)
    }

}
