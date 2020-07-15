package com.example.apiservice3.FootballDataclass

import com.google.gson.annotations.SerializedName

data class pageData (
   @SerializedName ("pageSize") var pageSize : Int,
   @SerializedName("currentPage") var currentPage : Int,
    @SerializedName("totalPages") var totalPages : Int,
    @SerializedName("totalRecords") var totalRecords : Int
)