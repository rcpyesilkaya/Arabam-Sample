package com.example.arabam_sample.data.remote.datasource.advert

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.arabam_sample.data.remote.api.ApiService
import com.example.arabam_sample.data.remote.datasource.model.CarResponse
import com.example.arabam_sample.data.remote.datasource.model.SortModel
import io.reactivex.disposables.CompositeDisposable

class CarDataSourceFactory(
    private val disposable: CompositeDisposable,
    private val arabamService: ApiService,
    private val sortModel: SortModel
) : DataSource.Factory<Int, CarResponse>() {


    private val carLiveDataSource = MutableLiveData<AdvertRemoteDataSource>()
    override fun create(): DataSource<Int, CarResponse> {
        val carDataSource = AdvertRemoteDataSource(arabamService, disposable, sortModel)
        carLiveDataSource.postValue(carDataSource)
        return carDataSource
    }
}