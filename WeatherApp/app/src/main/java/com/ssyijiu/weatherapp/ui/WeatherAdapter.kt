package com.ssyijiu.weatherapp.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import com.ssyijiu.weatherapp.R
import com.ssyijiu.weatherapp.net.data.CityBean
import com.ssyijiu.weatherapp.net.data.WeatherBean
import com.ssyijiu.weatherapp.extensions.ctx
import kotlinx.android.synthetic.main.item_forecast.view.*

/**
 * Created by ssyijiu on 2017/6/3.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */

class WeatherAdapter(val datas: CityBean, val itemClick: (WeatherBean) -> Unit) : RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    override fun getItemCount() = datas.size()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        val view = LayoutInflater.from(parent.ctx)
            .inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindForecast(datas[position])
    }


    class ViewHolder(itemView: View, val itemClick: (WeatherBean) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        fun bindForecast(weather: WeatherBean) {

            with(weather) {
                Picasso.with(itemView.ctx).load(iconUrl).into(itemView.icon)
                itemView.date.text = date
                itemView.description.text = description
                itemView.maxTemperature.text = high.toString()
                itemView.minTemperature.text = low.toString()
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}
