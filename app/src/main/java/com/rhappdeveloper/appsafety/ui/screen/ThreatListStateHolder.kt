package com.rhappdeveloper.appsafety.ui.screen

import com.rhappdeveloper.appsafety.domain.model.Threat

data class ThreatListStateHolder(
    val isLoading: Boolean = false,
    val data: List<Threat>? = null,
    val error: String = ""
)
