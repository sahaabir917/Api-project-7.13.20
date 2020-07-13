package com.example.apiservice3.FootballDataclass

import com.google.gson.annotations.SerializedName

data class FootballList(@SerializedName("data") var data :List<FootballData>)