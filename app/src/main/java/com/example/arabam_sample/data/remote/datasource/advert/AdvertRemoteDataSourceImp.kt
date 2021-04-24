package com.example.arabam_sample.data.remote.datasource.advert

import com.example.arabam_sample.data.remote.api.ApiService
import com.example.arabam_sample.data.remote.datasource.model.CarResponse
import com.example.arabam_sample.data.remote.datasource.model.SortModel
import io.reactivex.Observable
import javax.inject.Inject

class AdvertRemoteDataSourceImp @Inject constructor(private val apiService: ApiService) :
    AdvertRemoteDataSource {
    override fun fetchAdverts(
        skip: Int,
        take: Int,
        sortModel: SortModel
    ): Observable<List<CarResponse>> =
        apiService.fetchData(skip, take, sortModel.sort, sortModel.sortDirection)
}