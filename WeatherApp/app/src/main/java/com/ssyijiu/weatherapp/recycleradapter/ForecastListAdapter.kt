package com.ssyijiu.weatherapp.recycleradapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by ssyijiu on 2017/6/3.
 * Github : ssyijiu
 * Email  : lxmyijiu@163.com
 */

class ForecastListAdapter(val datas: List<String>) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun getItemCount() = datas.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        // new TextView
        return ViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = datas[position]
    }


    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}
