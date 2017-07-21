package com.ssyijiu.weatherapp.net

import com.ssyijiu.library.MLog
import com.ssyijiu.weatherapp.R
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
        val SOURCES by lazy { listOf(WeatherDbSource(), WeatherServerSource()) }
    }

    // 获取一个城市的天气列表
    fun requestWeatherList(cityId: Long, days: Int): CityBean?
        = sources.firstResult { requestWeatherLisFromSource(it, cityId, days) }


    private fun requestWeatherLisFromSource(source: WeatherDataSource, cityId: Long, days: Int): CityBean? {
        val res = source.requestWeatherList(cityId, todayTimeSpan())
        MLog.i("source = $source, res = $res")
        return if (res != null && res.size() >= days) res else null
    }


    // 获取某个天气的详细信息
    fun requestWeatherDetail(cityId: Long, date: String): WeatherBean?
        = sources.firstResult { requestWeatherDetailFromSource(it, cityId, date) }


    private fun requestWeatherDetailFromSource(source: WeatherDataSource, cityId: Long, date: String): WeatherBean?
        = source.requestWeatherDetail(cityId, date)


    private fun todayTimeSpan() = System.currentTimeMillis()

    private inline fun <T, R : Any> Iterable<T>.firstResult(predicate: (T) -> R?): R? {
        this.forEach { element ->
            val result = predicate(element)
            if(result != null) {
                return result
            }
        }
        return null
    }
}
