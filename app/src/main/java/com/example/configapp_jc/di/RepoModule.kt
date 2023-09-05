package com.example.configapp_jc.di

import com.sewedy.electrometer.data.dashboard.remote.AllServicesApi
import com.sewedy.electrometer.data.dashboard.repo.AllServicesRepo
import com.sewedy.electrometer.domain.dashboard.repo.IAllServicesRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    @Singleton
    fun provideServicesRepo(api: AllServicesApi): IAllServicesRepo {
        return AllServicesRepo(api)
    }
}