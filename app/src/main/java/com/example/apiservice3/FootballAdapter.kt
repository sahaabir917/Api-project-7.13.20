package com.example.apiservice3

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.apiservice3.FootballDataclass.FootballList
import kotlinx.android.synthetic.main.footballrow.view.*

class FootballAdapter(private val footballList: FootballList) : RecyclerView.Adapter<FootballAdapter.ViewHolder>() {



    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val id_number : TextView = itemView.id_number
        val published_at : TextView = itemView.published_at
        val body : TextView = itemView.bodies



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.footballrow,parent,false)
        return FootballAdapter.ViewHolder(view)
    }

    override fun getItemCount() = footballList.data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id_number.text = footballList.data[position].id.toString()
        holder.published_at.text = footballList.data[position].publishedAt
        holder.body.text = footballList.data[position].body


        holder.itemView.setOnClickListener {view : View ->
            //   Navigation.findNavController(v).navigate(R.id.action_footballFragment_to_newFragment)

//            val mFragment = NewFragment()
            val mArgs = Bundle()
            Log.d("argument will passed", footballList.data[position].source)

            mArgs.putString("Key", footballList.data[position].source.toString())
            view.findNavController().navigate(R.id.action_typeFragment_to_footballDetailsFragment,mArgs)




        }


    }


}