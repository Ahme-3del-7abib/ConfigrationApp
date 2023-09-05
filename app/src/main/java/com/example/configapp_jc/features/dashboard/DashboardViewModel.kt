package com.example.configapp_jc.features.dashboard

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sewedy.electrometer.core.remote.Resource
import com.sewedy.electrometer.domain.dashboard.model.Service
import com.sewedy.electrometer.domain.dashboard.use_cases.DashboardUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(useCases: DashboardUseCases) : ViewModel() {

    private var _getAllServices = mutableStateOf(AllServicesStates())
    val getAllServices get() = _getAllServices

    private var _currentService = mutableStateOf<Service?>(null)
    val currentService get() = _currentService

    init {
        useCases.getServices.invoke().onStart {
            _getAllServices.value = AllServicesStates(isLoading = true)
        }.map {
            when (it) {
                is Resource.Error -> {
                    _getAllServices.value =
                        AllServicesStates(error = it.errorTypes, isLoading = false)
                }

                is Resource.Success -> {
                    _getAllServices.value =
                        AllServicesStates(allServices = it.data.orEmpty(), isLoading = false)
                }

                else -> it
            }
        }.launchIn(viewModelScope)
    }

    fun setCurrentService(service: Service) {
        _currentService.value = service
    }
}