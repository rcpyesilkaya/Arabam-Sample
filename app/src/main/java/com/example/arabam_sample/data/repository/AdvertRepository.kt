package com.example.arabam_sample.data.repository

import com.example.arabam_sample.data.remote.datasource.advert.AdvertRemoteDataSource
import javax.inject.Inject


class AdvertRepository @Inject constructor(
    private val advertRemoteDataSource: AdvertRemoteDataSource
) {
    fun fetchAdvert(skip: Int, take: Int) = advertRemoteDataSource.fetchAdverts(skip, take)
}