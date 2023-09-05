package com.example.configapp_jc.di

import com.sewedy.electrometer.domain.dashboard.repo.IAllServicesRepo
import com.sewedy.electrometer.domain.dashboard.use_cases.DashboardUseCases
import com.sewedy.electrometer.domain.dashboard.use_cases.GetParameters
import com.sewedy.electrometer.domain.dashboard.use_cases.GetServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetServicesUseCase(repo: IAllServicesRepo): DashboardUseCases {
        return DashboardUseCases(GetServices(repo), GetParameters(repo))
    }
}