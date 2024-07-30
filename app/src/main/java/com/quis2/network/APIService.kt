package com.quis2.network

import com.quis2.model.QuoteResponse
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("quotes")
    fun getQuotes(): Call<QuoteResponse>
}

