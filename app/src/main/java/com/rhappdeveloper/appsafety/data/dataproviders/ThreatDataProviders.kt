package com.rhappdeveloper.appsafety.data.dataproviders

import com.rhappdeveloper.appsafety.data.remote.SafetyApi
import javax.inject.Inject

class ThreatDataProviders @Inject constructor(
    private val safetyApi: SafetyApi
) {
    suspend fun getThreatList(amount: String) = safetyApi.getThreats(amount)
}