package com.example.arabam_sample.data.repository

import com.example.arabam_sample.data.remote.datasource.advert.AdvertRemoteDataSourceImp
import com.example.arabam_sample.data.remote.datasource.model.SortModel
import javax.inject.Inject


class AdvertRepository @Inject constructor(
    private val advertRemoteDataSource: AdvertRemoteDataSourceImp
) {
    fun fetchAdvert(skip: Int, take: Int, sortModel: SortModel) =
        advertRemoteDataSource.fetchAdverts(skip, take, sortModel)
}