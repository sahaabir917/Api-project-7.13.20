package com.example.marsapi

import android.os.Bundle


import android.util.Log
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apiservice3.ApiserviceInterface.Football
import com.example.apiservice3.FootballAdapter
import com.example.apiservice3.FootballDataclass.FootballList
import com.example.apiservice3.R
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.fragment_type.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * A simple [Fragment] subclass.
 */
class FootballFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_type, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://128.199.183.164:8081/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(Football::class.java)

        api.getdata().enqueue(object : Callback<FootballList>{
            override fun onFailure(call: Call<FootballList>, t: Throwable) {
                d("Abir","Failed to retrive")
            }

            override fun onResponse(call: Call<FootballList>, response: Response<FootballList>) {
              d("Abir","succcess")
               showAllData(response.body()!!)

            }

        })

    }



    private fun showAllData (footballList: FootballList){
        recyclerview.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = FootballAdapter(footballList)
        }
    }





}
