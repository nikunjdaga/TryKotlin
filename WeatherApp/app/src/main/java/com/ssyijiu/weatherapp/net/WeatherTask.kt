package com.ssyijiu.weatherapp.net

import com.ssyijiu.weatherapp.net.data.CityBean

/**
 * Created by ssyijiu on 2017/6/3.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */


class WeatherTask(private val cityId: Long,
                  val dataProvider: WeatherProvider = WeatherProvider()) : Task<CityBean> {

    override fun execute(): CityBean = dataProvider.requestWeatherList(cityId, DAYS)

    companion object {
        val DAYS = 7
    }
}