package com.example.apiservice3

import android.os.Bundle
import android.os.Handler

import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apiservice3.ApiserviceInterface.Football
import com.example.apiservice3.FootballDataclass.FootballList

import kotlinx.android.synthetic.main.fragment_type.*
import kotlinx.android.synthetic.main.fragment_type.recyclerview
import kotlinx.android.synthetic.main.fragment_type.view.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * A simple [Fragment] subclass.
 */
class TypeFragment : Fragment() {

    lateinit var layoutManager: RecyclerView.LayoutManager

    //   lateinit var adapter : FootballAdapter
    var isScrolling = false
    var currentItem: Int = 0
    var totalItem: Int = 0
    var scrolloutItems: Int = 0
    var pageid = 1
    val pagesize = 10
    lateinit var adapter: FootballAdapter
    lateinit var footballList: FootballList
    var i: Int = 0
    var totalRecords : Int = 0
    var totalretrive : Int = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_type, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//
        val retrofit = Retrofit.Builder()
            .baseUrl("http://128.199.183.164:8081/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(Football::class.java)


        api.getdata(pagesize, pageid).enqueue(object : Callback<FootballList> {
            override fun onFailure(call: Call<FootballList>, t: Throwable) {
                d("Abir", "Failed to retrive")
            }

            override fun onResponse(call: Call<FootballList>, response: Response<FootballList>) {
                d("Abir", "responsed")
                showAllData(response.body()!!)
                totalRecords = response.body()!!.page.totalRecords

            }

        })


        layoutManager = LinearLayoutManager(activity)
        recyclerview.layoutManager = layoutManager

        recyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                currentItem = layoutManager.childCount
                totalItem = layoutManager.itemCount
                scrolloutItems =
                    (recyclerview.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()


                if (isScrolling && ((currentItem + scrolloutItems) == totalItem)) {
                    isScrolling = false
                    d("total record is in section 1 ", totalRecords.toString())
                    fetchagain(totalRecords)

                }

            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    isScrolling = true

                }
            }

        })


    }


    private fun showAllData(footballList: FootballList) {

        adapter = FootballAdapter(footballList)
        recyclerview.adapter = adapter

    }


    private fun fetchagain(totalrecords : Int ) {

        //        totalretrive = (pagesize*pageid)
//        d("totalretrive",totalretrive.toString())
//
//        if(totalrecords2!=totalretrive){
//            d("load more or not","load more")
//        }
//        if(totalrecords2 == totalretrive){
//            d("load more or not","dont load $totalretrive" )
//        }

        totalretrive =pagesize*pageid
        d("pageid before","$pageid")
        d("total retrive before" , "$totalretrive")



        if(totalrecords != totalretrive){
            Handler().postDelayed(Runnable {
                kotlin.run {
                    pageid++
                    d("pageid after", "$pageid")
                    retrofitcalling(pageid)
                }
            }, 5000)

        }
        if(totalretrive >= totalrecords){
            d("load data "," donot load any data ")
        }


    }


    private fun retrofitcalling(pageId: Int) {

        val retrofit = Retrofit.Builder()
            .baseUrl("http://128.199.183.164:8081/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(Football::class.java)







            api.getdata(pagesize, pageId).enqueue(object : Callback<FootballList> {
                override fun onFailure(call: Call<FootballList>, t: Throwable) {
                    d("Abir", "Failed to retrive")
//                    d("before fail pageid is ", " pageID : $pageId" )
                    pageid--
//                    d("after fail pageid is ",pageid.toString())
                }

                override fun onResponse(call: Call<FootballList>, response: Response<FootballList>) {

                    i++
                    d("Abir", "responsed" + i.toString())

                    adapter.addFootballData(response.body()!!.data)
                    adapter.notifyDataSetChanged()
                }

            })


    }


}







