package com.rhappdeveloper.appsafety.domain.repo

import com.rhappdeveloper.appsafety.domain.model.Threat

interface ThreatRepository {
    suspend fun getThreatList(amount: String): List<Threat>
}