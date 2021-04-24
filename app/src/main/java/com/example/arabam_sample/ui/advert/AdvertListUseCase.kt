package com.example.arabam_sample.ui.advert

import com.example.arabam_sample.data.remote.datasource.model.SortModel
import com.example.arabam_sample.data.repository.AdvertRepository
import javax.inject.Inject

class AdvertListUseCase @Inject constructor(private val advertRepository: AdvertRepository) {
    fun fetchAdvertList(skip: Int, take: Int, sortModel: SortModel) =
        advertRepository.fetchAdvert(skip, take, sortModel)
}