package com.quis2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quis2.model.QuoteResponse
import com.quis2.repository.QuoteRepository
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {
    private val repository = QuoteRepository()

    val quotes: LiveData<QuoteResponse> get() = repository.quotes

    fun getQuotes() {
        viewModelScope.launch {
            repository.fetchQuotes()
        }
    }
}