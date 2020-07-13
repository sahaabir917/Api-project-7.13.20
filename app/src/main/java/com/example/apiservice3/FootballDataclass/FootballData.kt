package com.example.apiservice3.FootballDataclass

import com.google.gson.annotations.SerializedName

data class FootballData (
    @SerializedName("id") var id:Int,
    @SerializedName("body") var body : String,
    @SerializedName("publishedAt") var publishedAt : String,
    @SerializedName("source") var source : String
)