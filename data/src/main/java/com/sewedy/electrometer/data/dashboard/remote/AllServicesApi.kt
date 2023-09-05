package com.sewedy.electrometer.data.dashboard.remote

import com.sewedy.electrometer.domain.dashboard.model.ParametersResponse
import com.sewedy.electrometer.domain.dashboard.model.ServicesResponse
import retrofit2.Response
import retrofit2.http.GET

interface AllServicesApi {

    @GET
    suspend fun getAllServices(): Response<ServicesResponse>

    @GET
    suspend fun getAllParameters(): Response<ParametersResponse>
}