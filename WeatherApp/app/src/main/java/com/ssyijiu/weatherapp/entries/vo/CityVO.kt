package com.ssyijiu.weatherapp.entries.vo

/**
 * Created by ssyijiu on 2017/6/3.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 *
 * VO 展示在 View 上的数据
 */


data class CityVO(val city: String, val country: String,
                  val weatherVOList: List<WeatherVO>) {

    // 重载 get 方法
    operator fun get(position: Int) = weatherVOList[position]

    fun size() = weatherVOList.size
}

data class WeatherVO(val date: String, val description: String, val high: Int,
                     val low: Int, val iconUrl: String)