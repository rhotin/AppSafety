package com.rhappdeveloper.appsafety.domain.model

data class Threat(
    val id: String,
    val threat: String,
    val url: String,
    val url_status: String,
    val urlhaus_reference: String
)
