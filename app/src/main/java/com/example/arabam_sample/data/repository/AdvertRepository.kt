package com.example.arabam_sample.data.repository

import com.example.arabam_sample.data.remote.datasource.advert.AdvertRemoteDataSource

class AdvertRepository(
    private val advertRemoteDataSource: AdvertRemoteDataSource) {
    fun fetchAdvert(skip:Int,take:Int) = advertRemoteDataSource.fetchAdverts(skip,take)
}