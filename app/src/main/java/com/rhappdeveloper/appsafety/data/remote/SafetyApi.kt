package com.rhappdeveloper.appsafety.data.remote

import com.rhappdeveloper.appsafety.data.model.ThreatDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface SafetyApi {

    @GET("urls/recent/limit/{amount}/")
    suspend fun getThreats(
        @Path("amount") amount: String
    ): ThreatDTO

    companion object {
        const val BASE_URL = "https://urlhaus-api.abuse.ch/v1/"
    }
}