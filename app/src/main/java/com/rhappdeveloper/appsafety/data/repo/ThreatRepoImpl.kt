package com.rhappdeveloper.appsafety.data.repo

import com.rhappdeveloper.appsafety.data.dataproviders.ThreatDataProviders
import com.rhappdeveloper.appsafety.data.mapper.toDomainThreatList
import com.rhappdeveloper.appsafety.domain.model.Threat
import com.rhappdeveloper.appsafety.domain.repo.ThreatRepository
import javax.inject.Inject

class ThreatRepoImpl @Inject constructor(
    private val threatDataProviders: ThreatDataProviders
) : ThreatRepository {
    override suspend fun getThreatList(amount: String): List<Threat> {
        return threatDataProviders.getThreatList(amount).toDomainThreatList()
    }
}