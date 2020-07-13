package com.example.apiservice3.ApiserviceInterface

import com.example.apiservice3.FootballDataclass.FootballList
import retrofit2.Call
import retrofit2.http.GET

interface Football {

//    @GET("sports?page=1&pageSize=15&order=asc")
//    fun getShopsByCategories(@Query("page")  page:Int,
//                             @Query("pageSize")  pageSize:Int,
//                             @Query("order")  order:String
//    ): Observable<JsonObject>


    @GET("/v1/sports?page=1&pageSize=15&order=asc")
    fun getdata(): Call<FootballList>


}