package com.quis2.model

data class Quote(
    val _id: String,
    val content: String,
    val author: String,
    val tags: List<String>
)
