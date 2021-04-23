package com.example.arabam_sample.data.remote.api

import com.example.arabam_sample.data.remote.datasource.model.CarResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/api/v1/listing")
    fun fetchData(
        @Query("skip") skip: Int,
        @Query("take") take: Int,
        @Query("sort") sort: Int?,
        @Query("sortDirection") sortDirection: Int?,
        @Query("minYear") minYear: Int?,
        @Query("maxYear") maxYear: Int?,
        @Query("categoryId") categoryId: Int?,
        @Query("minDate") minDate: String?,
        @Query("maxDate") maxDate: String?
    ): Observable<List<CarResponse>>

    @GET("/api/v1/listing")
    fun fetchData(
        @Query("skip") skip: Int,
        @Query("take") take: Int
    ): Observable<List<CarResponse>>
}