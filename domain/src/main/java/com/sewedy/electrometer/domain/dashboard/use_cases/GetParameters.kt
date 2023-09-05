package com.sewedy.electrometer.domain.dashboard.use_cases

import com.sewedy.electrometer.core.remote.APIResult
import com.sewedy.electrometer.core.remote.Resource
import com.sewedy.electrometer.domain.dashboard.model.Service
import com.sewedy.electrometer.domain.dashboard.repo.IAllServicesRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetParameters(private val repo: IAllServicesRepo) {

    operator fun invoke(): Flow<Resource<List<Service>>> {
        return repo.getAllServices().map {
            when (it) {
                is APIResult.Success -> {
                    Resource.Success(it.data?.service.orEmpty())
                }

                is APIResult.Error -> {
                    Resource.Error(it.errorTypes)
                }
            }
        }
    }
}