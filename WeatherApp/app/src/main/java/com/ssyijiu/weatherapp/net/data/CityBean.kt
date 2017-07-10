package com.ssyijiu.weatherapp.net.data

/**
 * Created by ssyijiu on 2017/6/3.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */


data class CityBean(val city: String, val country: String,
                    val weatherBeanList: List<WeatherBean>) {

    // 重载 get 方法
    operator fun get(position: Int) = weatherBeanList[position]

    fun size() = weatherBeanList.size
}

data class WeatherBean(val id: Long, val date: String, val description: String, val high: Int,
                       val low: Int, val iconUrl: String)