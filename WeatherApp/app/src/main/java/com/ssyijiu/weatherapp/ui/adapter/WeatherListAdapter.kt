package com.ssyijiu.weatherapp.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import com.ssyijiu.weatherapp.R
import com.ssyijiu.weatherapp.net.data.CityBean
import com.ssyijiu.weatherapp.net.data.WeatherBean
import com.ssyijiu.weatherapp.extensions.ctx
import kotlinx.android.synthetic.main.item_weather_list.view.*

/**
 * Created by ssyijiu on 2017/6/3.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */


class WeatherListAdapter(val datas: CityBean) : RecyclerView.Adapter<WeatherListAdapter.ViewHolder>() {

    // onItemClickListener 是一个 lambda
    // 这个 lambda 的作用是[ 操作一个 WeatherBean，返回 Unit ]
    // 调用方法 onItemClickListener(weatherBean)
    lateinit var itemClickListener: (WeatherBean) -> Unit

    override fun getItemCount() = datas.size()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        val view = LayoutInflater.from(parent.ctx)
            .inflate(R.layout.item_weather_list, parent, false)
        return ViewHolder(view, itemClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(datas[position])
    }


    class ViewHolder(itemView: View, val onItemClickListener: (WeatherBean) -> Unit) : RecyclerView.ViewHolder(itemView) {

        fun bindForecast(weather: WeatherBean) {

            with(weather) {
                Picasso.with(itemView.ctx).load(iconUrl).into(itemView.icon)
                itemView.date.text = date
                itemView.description.text = description
                itemView.maxTemperature.text = high.toString()
                itemView.minTemperature.text = low.toString()

                itemView.setOnClickListener {
                    onItemClickListener(this)
                }
            }
        }
    }

    fun setOnItemClickListener(itemClickListener: (WeatherBean) -> Unit) {
        this.itemClickListener = itemClickListener
    }
}
