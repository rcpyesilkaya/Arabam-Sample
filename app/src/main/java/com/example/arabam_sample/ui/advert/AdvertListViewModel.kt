package com.example.arabam_sample.ui.advert

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import com.example.arabam_sample.data.remote.api.ApiService
import com.example.arabam_sample.data.remote.datasource.advert.CarDataSourceFactory
import com.example.arabam_sample.data.remote.datasource.model.CarResponse
import com.example.arabam_sample.data.remote.datasource.model.SortModel
import com.example.arabam_sample.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class AdvertListViewModel @Inject constructor(val apiService: ApiService) : ViewModel() {

    private val _advertListLiveData = MutableLiveData<Resource<PagedList<CarResponse>?>>()
    val advertListLiveData: LiveData<Resource<PagedList<CarResponse>?>> = _advertListLiveData

    private val compositeDisposable = CompositeDisposable()

    private val pageSize = 20

    private lateinit var sourceFactory: CarDataSourceFactory

    fun loadList(sort: SortModel) {
        sourceFactory = CarDataSourceFactory(compositeDisposable, apiService, sort)

        val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setEnablePlaceholders(false)
            .build()

        val eventPagedList = RxPagedListBuilder(sourceFactory, config)
            .setFetchScheduler(Schedulers.io())
            .buildObservable()
            .cache()


        compositeDisposable.add(eventPagedList.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { _advertListLiveData.value = Resource.loading() }
            .subscribe({
                if (it.isNotEmpty()) {
                    _advertListLiveData.value = Resource.success(data = it)
                }
            }, {
                _advertListLiveData.value = it.message?.let { Resource.failed(it) }
            })
        )
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }
}