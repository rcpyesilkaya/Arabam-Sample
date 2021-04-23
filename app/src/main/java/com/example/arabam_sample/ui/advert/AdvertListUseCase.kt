package com.example.arabam_sample.ui.advert

import com.example.arabam_sample.data.repository.AdvertRepository

class AdvertListUseCase(private val advertRepository: AdvertRepository) {
    fun fetchAdvertList(skip:Int,take:Int) = advertRepository.fetchAdvert(skip,take)
}