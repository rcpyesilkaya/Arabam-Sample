package com.example.arabam_sample.ui.advert

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.arabam_sample.data.remote.datasource.model.CarResponse
import com.example.arabam_sample.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class AdvertListViewModel @Inject constructor(private val advertListUseCase: AdvertListUseCase) :
    ViewModel() {

    private val _advertListLiveData = MutableLiveData<Resource<List<CarResponse>?>>()
    val advertListLiveData: LiveData<Resource<List<CarResponse>?>> = _advertListLiveData

    private val disposable = CompositeDisposable()

    fun fetchAdvertList(skip: Int, take: Int) {
        _advertListLiveData.value = Resource.loading()
        disposable.add(
            advertListUseCase.fetchAdvertList(skip, take)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ data ->
                    _advertListLiveData.value = Resource.success(data = data)
                }, { error ->
                    _advertListLiveData.value = error.message?.let { Resource.failed(it) }
                })
        )
    }

    override fun onCleared() {
        disposable.clear()
    }
}