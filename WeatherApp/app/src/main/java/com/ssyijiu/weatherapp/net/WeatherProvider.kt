package com.ssyijiu.weatherapp.net

import com.ssyijiu.weatherapp.net.data.CityBean
import com.ssyijiu.weatherapp.net.data.WeatherBean

/**
 * Created by ssyijiu on 2017/6/18.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */

/** 数据提供者 */
class WeatherProvider(val sources: List<WeatherDataSource> =
                      WeatherProvider.SOURCES) {

    private companion object {
        val SOURCES = listOf(WeatherDbSource(), WeatherServerSource())
    }

    // 获取一个城市的天气列表
    fun requestWeatherList(cityId: Long, days: Int): CityBean?
        = sources.map { requestWeatherLisFromSource(it, cityId, days) }
                 .firstOrNull()


    private fun requestWeatherLisFromSource(source: WeatherDataSource, cityId: Long, days: Int): CityBean? {
        val res = source.requestWeatherList(cityId, todayTimeSpan())
        return if (res != null && res.size() >= days) res else null
    }


    // 获取某个天气的详细信息
    fun requestWeatherDetail(cityId: Long, date: String): WeatherBean?
        = sources.map { requestWeatherDetailFromSource(it, cityId, date) }
                 .firstOrNull()


    private fun requestWeatherDetailFromSource(source: WeatherDataSource, cityId: Long, date: String): WeatherBean?
        = source.requestWeatherDetail(cityId, date)


    private fun todayTimeSpan() = System.currentTimeMillis()
}
