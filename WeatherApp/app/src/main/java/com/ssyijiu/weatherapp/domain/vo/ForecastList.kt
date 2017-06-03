package com.ssyijiu.weatherapp.domain.vo

/**
 * Created by ssyijiu on 2017/6/3.
 * Github : ssyijiu
 * Email  : lxmyijiu@163.com
 */

// VO

data class ForecastList(val city: String, val country: String,
                        val dailyForecast: List<Forecast>) {

    // 重载 get 方法
    operator fun get(position: Int): Forecast = dailyForecast[position]

    fun size(): Int = dailyForecast.size
}

data class Forecast(val date: String, val description: String, val high: Int,
                    val low: Int, val iconUrl: String)