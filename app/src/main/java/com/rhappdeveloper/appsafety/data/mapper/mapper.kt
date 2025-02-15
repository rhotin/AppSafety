package com.rhappdeveloper.appsafety.data.mapper

import com.rhappdeveloper.appsafety.data.model.ThreatDTO
import com.rhappdeveloper.appsafety.domain.model.Threat

fun ThreatDTO.toDomainThreatList(): List<Threat> {
    return this.urls.map {
        Threat(
            id = it.id.toString(),
            threat = it.threat,
            url = it.url,
            url_status = it.url_status,
            urlhaus_reference = it.urlhaus_reference
        )
    }
}