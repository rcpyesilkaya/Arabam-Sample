package com.example.arabam_sample.data.remote.datasource.advert

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.example.arabam_sample.data.remote.api.ApiService
import com.example.arabam_sample.data.remote.datasource.model.CarResponse
import com.example.arabam_sample.data.remote.datasource.model.SortModel
import io.reactivex.disposables.CompositeDisposable

class AdvertRemoteDataSource(
    private val apiService: ApiService,
    private val disposable: CompositeDisposable,
    private val sortModel: SortModel
) : PageKeyedDataSource<Int, CarResponse>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, CarResponse>
    ) {
        val numberOfItems = params.requestedLoadSize
        createObservable(0, 1, numberOfItems, callback, null)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, CarResponse>) {
        val page = params.key
        val numberOfItems = params.requestedLoadSize
        createObservable(page, page + 1, numberOfItems, null, callback)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, CarResponse>) {}

    private fun createObservable(
        requestedPage: Int,
        adjacentPage: Int,
        requestedLoadSize: Int,
        initialcallback: LoadInitialCallback<Int, CarResponse>?,
        callback: LoadCallback<Int, CarResponse>?
    ) {
        disposable.add(apiService.fetchData(
            requestedPage,
            requestedLoadSize,
            sort = sortModel.sort,
            sortDirection = sortModel.sortDirection
        ).subscribe(
            { response ->
                Log.d("CDT", "Loading Page : $requestedPage")
                initialcallback?.onResult(response, null, adjacentPage)
                callback?.onResult(response, adjacentPage)
            },
            {
                Log.d("CDT", "Error Loading Page : $requestedPage", it)
            }
        ))
    }
}