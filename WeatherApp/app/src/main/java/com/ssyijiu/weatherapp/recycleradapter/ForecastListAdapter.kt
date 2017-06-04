package com.ssyijiu.weatherapp.recycleradapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import com.ssyijiu.weatherapp.R
import com.ssyijiu.weatherapp.domain.vo.Forecast
import com.ssyijiu.weatherapp.domain.vo.ForecastList
import com.ssyijiu.weatherapp.extensions.ctx
import kotlinx.android.synthetic.main.item_forecast.view.*

/**
 * Created by ssyijiu on 2017/6/3.
 * Github : ssyijiu
 * Email  : lxmyijiu@163.com
 */

class ForecastListAdapter(val datas: ForecastList, val itemClick: (Forecast) -> Unit) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun getItemCount() = datas.size()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        val view = LayoutInflater.from(parent.ctx)
            .inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindForecast(datas[position])
    }


    class ViewHolder(itemView: View, val itemClick: (Forecast) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        fun bindForecast(forecast: Forecast) {

            with(forecast) {
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
