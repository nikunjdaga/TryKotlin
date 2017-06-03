package com.ssyijiu.weatherapp.recycleradapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.ssyijiu.weatherapp.R
import com.ssyijiu.weatherapp.domain.vo.Forecast
import com.ssyijiu.weatherapp.domain.vo.ForecastList
import com.ssyijiu.weatherapp.extensions.ctx
import org.jetbrains.anko.find

/**
 * Created by ssyijiu on 2017/6/3.
 * Github : ssyijiu
 * Email  : lxmyijiu@163.com
 */

class ForecastListAdapter(val datas: ForecastList, val itemClick: OnItemClickListener) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun getItemCount() = datas.size()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        val view = LayoutInflater.from(parent.ctx)
            .inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindForecast(datas[position])
    }


    class ViewHolder(itemView: View, val itemClick: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {

        private val iconView: ImageView = itemView.find(R.id.icon)
        private val dateView: TextView = itemView.find(R.id.date)
        private val descriptionView: TextView = itemView.find(R.id.description)
        private val maxTemperatureView: TextView = itemView.find(R.id.maxTemperature)
        private val minTemperatureView: TextView = itemView.find(R.id.minTemperature)

        fun bindForecast(forecast: Forecast) {

            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = high.toString()
                minTemperatureView.text = low.toString()
                itemView.setOnClickListener { itemClick(forecast) }
            }
        }
    }

    // invoke 对应 ()
    // 重载操作符，itemClick(forecast) 就调用了 invoke 这个方法
    interface OnItemClickListener {
        operator fun invoke(forecast: Forecast)
    }
}
