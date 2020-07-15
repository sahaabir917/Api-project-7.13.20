package com.example.apiservice3

import android.os.Bundle
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
import kotlinx.android.synthetic.main.footballrow.view.*

class FootballAdapter(private val footballList: FootballList) : RecyclerView.Adapter<FootballAdapter.ViewHolder>() {
    lateinit var footballdata : MutableList<FootballData>
//    public var totaldata : Int
    init {
      footballdata = footballList.data.toMutableList()
//        totaldata = footballList.page.totalRecords
    }



    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val id_number : TextView = itemView.id_number
        val published_at : TextView = itemView.published_at
        val body : TextView = itemView.bodies



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.footballrow,parent,false)
        return FootballAdapter.ViewHolder(view)
    }

    override fun getItemCount() = footballdata.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id_number.text = footballdata[position].id.toString()
        holder.published_at.text = footballdata[position].publishedAt
        holder.body.text = footballdata[position].body


        holder.itemView.setOnClickListener {view : View ->
            //   Navigation.findNavController(v).navigate(R.id.action_footballFragment_to_newFragment)

//            val mFragment = NewFragment()
            val mArgs = Bundle()
            Log.d("argument will passed", footballdata[position].source)

            mArgs.putString("Key", footballdata[position].source.toString())
            view.findNavController().navigate(R.id.action_typeFragment_to_footballDetailsFragment,mArgs)

        }



    }

    public fun addFootballData( footballDataList : List<FootballData>){
        this.footballdata.addAll(footballDataList)
    }


}