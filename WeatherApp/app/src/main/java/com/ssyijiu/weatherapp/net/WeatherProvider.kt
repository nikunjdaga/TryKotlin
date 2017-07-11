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
    fun requestWeatherList(cityId: Long, days: Int): CityBean
        = sources.firstResult { requestWeatherLisFromSource(it, cityId, days) }


    private fun requestWeatherLisFromSource(source: WeatherDataSource, cityId: Long, days: Int): CityBean? {
        val res = source.requestWeatherList(cityId, todayTimeSpan())
        return if (res != null && res.size() >= days) res else null
    }


    // 获取某个天气的详细信息
    fun requestWeatherDetail(cityId: Long, date: String): WeatherBean
        = sources.firstResult { requestWeatherDetailFromSource(it, cityId, date) }


    private fun requestWeatherDetailFromSource(source: WeatherDataSource, cityId: Long, date: String): WeatherBean?
        = source.requestWeatherDetail(cityId, date)


    // 返回第一个不是 null 结果，修改自 firstOrNull 方法
    // 参数是一个 lambda,这个 lambda 将 T 转化成 R
    private fun <T, R : Any> Iterable<T>.firstResult(predicate: (T) -> R?): R {

        this.mapNotNull { it -> predicate(it) }
            .forEach { return it }
        throw NoSuchElementException("No element matching predicate was found.")
    }

    private fun todayTimeSpan() = System.currentTimeMillis()
}
