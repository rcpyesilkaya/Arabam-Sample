package com.example.arabam_sample.data.remote.datasource.advert

import com.example.arabam_sample.data.remote.api.ApiService
import com.example.arabam_sample.data.remote.datasource.model.CarResponse
import io.reactivex.Observable

class AdvertRemoteDataSourceImp(private val apiService: ApiService) : AdvertRemoteDataSource {
    override fun fetchAdverts(skip: Int, take: Int): Observable<List<CarResponse>> = apiService.fetchData(skip,take)
}