package com.rhappdeveloper.appsafety.data.model

data class Url(
    val blacklists: Blacklists,
    val date_added: String,
    val host: String,
    val id: Int,
    val larted: String,
    val reporter: String,
    val tags: List<String>?,
    val threat: String,
    val url: String,
    val url_status: String,
    val urlhaus_reference: String
)