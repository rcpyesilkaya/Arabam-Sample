package com.example.arabam_sample.data.remote.datasource.model

import retrofit2.http.Query

data class FilterModel(
   val minYear: Int?,
   val maxYear: Int?,
   val categoryId: Int?,
   val minDate: String?,
   val maxDate: String?
)
