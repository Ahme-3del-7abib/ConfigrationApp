package com.example.configapp_jc.features.dashboard

import com.sewedy.electrometer.core.remote.ErrorTypes
import com.sewedy.electrometer.domain.dashboard.model.Service

data class AllServicesStates(
    val isLoading: Boolean = false,
    val allServices: List<Service> = listOf(),
    val error: ErrorTypes? = null
)