package com.rhappdeveloper.appsafety.domain.usecases

import com.rhappdeveloper.appsafety.domain.UiEvent
import com.rhappdeveloper.appsafety.domain.model.Threat
import com.rhappdeveloper.appsafety.domain.repo.ThreatRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetThreatListUseCase @Inject constructor(
    private val threatRepository: ThreatRepository
) {
    operator fun invoke(amount: String) = flow<UiEvent<List<Threat>>> {
        emit(UiEvent.Loading())
        emit(UiEvent.Success(threatRepository.getThreatList(amount)))
    }.catch {
        emit(UiEvent.Error("Something went wrong"))
    }.flowOn(Dispatchers.IO)
}