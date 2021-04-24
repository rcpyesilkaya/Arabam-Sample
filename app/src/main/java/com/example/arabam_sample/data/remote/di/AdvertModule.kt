package com.example.arabam_sample.data.remote.di

import com.example.arabam_sample.data.remote.api.ApiService
import com.example.arabam_sample.data.remote.datasource.advert.AdvertRemoteDataSource
import com.example.arabam_sample.data.remote.datasource.advert.AdvertRemoteDataSourceImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AdvertModule {

    @Provides
    @Singleton
    fun provideRemoteDataSource(service: ApiService): AdvertRemoteDataSource {
        return AdvertRemoteDataSourceImp(service)
    }
}