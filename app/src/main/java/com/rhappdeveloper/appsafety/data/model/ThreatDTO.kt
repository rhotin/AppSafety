package com.rhappdeveloper.appsafety.data.model

data class ThreatDTO(
    val query_status: String,
    val urls: List<Url>
)