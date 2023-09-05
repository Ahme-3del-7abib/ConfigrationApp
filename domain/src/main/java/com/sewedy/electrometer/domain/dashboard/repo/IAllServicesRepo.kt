package com.sewedy.electrometer.domain.dashboard.repo

import com.sewedy.electrometer.core.remote.APIResult
import com.sewedy.electrometer.domain.dashboard.model.ParametersResponse
import com.sewedy.electrometer.domain.dashboard.model.ServicesResponse
import kotlinx.coroutines.flow.Flow

interface IAllServicesRepo {
    fun getAllServices(): Flow<APIResult<ServicesResponse>>

    fun getAllParameters(): Flow<APIResult<ParametersResponse>>
}