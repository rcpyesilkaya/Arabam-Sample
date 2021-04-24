package com.example.arabam_sample.data.remote.datasource.advert

import com.example.arabam_sample.data.remote.datasource.model.CarResponse
import com.example.arabam_sample.data.remote.datasource.model.SortModel
import io.reactivex.Observable

interface AdvertRemoteDataSource {
    fun fetchAdverts(skip: Int, take: Int, sortModel: SortModel): Observable<List<CarResponse>>
}