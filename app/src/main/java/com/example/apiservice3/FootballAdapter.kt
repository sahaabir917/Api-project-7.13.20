package com.example.apiservice3

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.util.Log
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.apiservice3.FootballDataclass.FootballData
import com.example.apiservice3.FootballDataclass.FootballList
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.formats.NativeAdOptions
import com.google.android.gms.ads.formats.UnifiedNativeAd
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bannerad.view.*
import kotlinx.android.synthetic.main.footballrow.view.*

class FootballAdapter(private val footballList: FootballList) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var context: Context
    lateinit var footballdata : MutableList<FootballData>
    val contentview : Int = 0
    val Adviews : Int = 1

    init {
      footballdata = footballList.data.toMutableList()
    }





    class ContentViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind(footballData: FootballData){
            itemView.id_number.text = footballData.id.toString()
            itemView.bodies.text  = footballData.body
            itemView.published_at.text = footballData.publishedAt
        }

    }

    class AdviewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            fun bind(){
//                what should be the context
            }
    }


    override fun getItemViewType(position: Int): Int {

        return if (position % 14 == 0) {
            Adviews
        } else {
             contentview
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if(viewType == contentview){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.footballrow,parent,false)
            return ContentViewHolder(view)
        }
        else{
            val view = LayoutInflater.from(parent.context).inflate(R.layout.bannerad,parent,false)
            return AdviewHolder(view)
        }

    }

    override fun getItemCount() = footballdata.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            if(getItemViewType(position)==contentview){
                (holder as ContentViewHolder).bind(footballdata[position])
                holder.itemView.setOnClickListener {view : View ->
                    val mArgs = Bundle()
                  Log.d("argument will passed", footballdata[position].source)
              mArgs.putString("Key", footballdata[position].source.toString())
              view.findNavController().navigate(R.id.action_typeFragment_to_footballDetailsFragment,mArgs)

          }
            }

        if(getItemViewType(position)==Adviews){
            (holder as AdviewHolder).bind()
        }

    }



    public fun addFootballData( footballDataList : List<FootballData>){
        this.footballdata.addAll(footballDataList)
    }

}