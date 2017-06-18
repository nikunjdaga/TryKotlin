package com.ssyijiu.weatherapp.net

import com.ssyijiu.weatherapp.net.data.CityBean

/**
 * Created by ssyijiu on 2017/6/18.
 * Github : ssyijiu
 * Email  : lxmyijiu@163.com
 */

/** 数据提供者 */
class WeatherProvider(val sources: List<WeatherDataSource> =
                      WeatherProvider.SOURCES) {

    companion object {
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        // 默认加载数据库、服务器两个数据源，顺序很重要
        val SOURCES = listOf(WeatherDbSource(), WeatherServerSource())
    }

    // 获取数据的方法
    fun requestWeatherByCityId(cityId: Long, days: Int): CityBean
        = sources.firstResult { requestSource(it, cityId, days) }


    private fun requestSource(source: WeatherDataSource, cityId: Long, days: Int): CityBean? {
        val res = source.requestWeather(cityId, todayTimeSpan())
        return if (res != null && res.size() >= days) res else null
    }

    private fun todayTimeSpan() = System.currentTimeMillis() /
        DAY_IN_MILLIS * DAY_IN_MILLIS


    fun <T : Any> requestWeatherDetailed(data: (WeatherDataSource) -> T): T
        = sources.firstResult { data(it) }

    // 返回第一个不是 null 结果，修改自 firstOrNull 方法
    fun <T, R : Any> Iterable<T>.firstResult(predicate: (T) -> R?): R {
        for (element in this) {
            val result = predicate(element)
            if (result != null) return result
        }
        throw NoSuchElementException("No element matching predicate was found.")
    }
}
