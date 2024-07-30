package com.quis2.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.quis2.model.QuoteResponse
import com.quis2.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuoteRepository {
    private val _quotes = MutableLiveData<QuoteResponse>()
    val quotes: LiveData<QuoteResponse> get() = _quotes

    fun fetchQuotes() {
        RetrofitInstance.api.getQuotes().enqueue(object : Callback<QuoteResponse> {
            override fun onResponse(call: Call<QuoteResponse>, response: Response<QuoteResponse>) {
                if (response.isSuccessful) {
                    _quotes.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<QuoteResponse>, t: Throwable) {
                _quotes.postValue(null)
            }
        })
    }
}