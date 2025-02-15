package com.rhappdeveloper.appsafety.di

import com.rhappdeveloper.appsafety.data.dataproviders.ThreatDataProviders
import com.rhappdeveloper.appsafety.data.remote.SafetyApi
import com.rhappdeveloper.appsafety.data.repo.ThreatRepoImpl
import com.rhappdeveloper.appsafety.domain.repo.ThreatRepository
import com.rhappdeveloper.appsafety.domain.usecases.GetThreatListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideSafetyApi(): SafetyApi {
        return Retrofit.Builder()
            .baseUrl(SafetyApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SafetyApi::class.java)
    }

    @Provides
    fun provideThreatDataProviders(safetyApi: SafetyApi): ThreatDataProviders {
        return ThreatDataProviders(safetyApi)
    }

    @Provides
    fun provideThreatRepo(threatDataProviders: ThreatDataProviders): ThreatRepository {
        return ThreatRepoImpl(threatDataProviders)
    }

    @Provides
    fun provideGetThreatListUseCase(threatRepository: ThreatRepository): GetThreatListUseCase {
        return GetThreatListUseCase(threatRepository)
    }

}