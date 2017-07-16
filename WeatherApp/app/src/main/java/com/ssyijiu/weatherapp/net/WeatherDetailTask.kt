package com.ssyijiu.weatherapp.net

import com.ssyijiu.weatherapp.net.data.WeatherBean

/**
 * Created by ssyijiu on 2017/7/11.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 */

class WeatherDetailTask(private val cityId: Long, val date: String,
                        val dataProvider: WeatherProvider = WeatherProvider()) : Task<WeatherBean> {

    override fun execute(): WeatherBean? =
        dataProvider.requestWeatherDetail(cityId, date)

}