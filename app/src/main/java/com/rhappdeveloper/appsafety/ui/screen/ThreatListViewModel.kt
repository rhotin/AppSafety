package com.rhappdeveloper.appsafety.ui.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rhappdeveloper.appsafety.domain.UiEvent
import com.rhappdeveloper.appsafety.domain.usecases.GetThreatListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class ThreatListViewModel @Inject constructor(
    private val getThreatListUseCase: GetThreatListUseCase
) : ViewModel() {

    private val _threatList = mutableStateOf(ThreatListStateHolder())
    val threatList: State<ThreatListStateHolder> get() = _threatList

    var lastScanTime by mutableStateOf(getCurrentTime())
        private set

    init {
        viewModelScope.launch {
            getThreatList("10")
        }
    }

    fun getThreatList(amount: String) = viewModelScope.launch {
        getThreatListUseCase(amount).onEach {
            when (it) {
                is UiEvent.Error -> {
                    _threatList.value =
                        ThreatListStateHolder(error = "Something went wrong. Try Again.")
                }

                is UiEvent.Loading -> {
                    _threatList.value = ThreatListStateHolder(isLoading = true)
                }

                is UiEvent.Success -> {
                    _threatList.value = ThreatListStateHolder(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun updateScanTime() {
        lastScanTime = getCurrentTime()
    }

    private fun getCurrentTime(): String {
        val sdf = SimpleDateFormat("dd.MM.yy HH:mm", Locale.getDefault())
        return sdf.format(Date())
    }

}