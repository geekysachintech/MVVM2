package com.mrmobo.mvvm2.data.models

data class SearchResponse(
    val incomplete_results: Boolean? = null,
    val items: List<User>? = null,
    val total_count: Int? = null,
)