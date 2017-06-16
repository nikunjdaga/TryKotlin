package com.ssyijiu.weatherapp.net

import com.ssyijiu.weatherapp.dao.Db
import com.ssyijiu.weatherapp.net.data.CityBean

/**
 * Created by ssyijiu on 2017/6/15.
 * Github : ssyijiu
 * Email  : lxmyijiu@163.com
 *
 * 1. 从数据库获取数据
 * 2. 检查数据是否存在
 * 3. 如果存在，进行 UI 渲染
 * 4. 如果没有，请求服务器数据
 * 5. 进行 UI 渲染，将数据保存到数据库
 *
 * Retrofit + RxCache 套路
 */

/** 数据源接口 */
interface WeatherDataSource {
    fun requestWeather(cityId: String, days: Int): CityBean?
}

/** 数据提供者 */
class WeatherProvider(val sources: List<WeatherDataSource> =
                      WeatherProvider.SOURCES) {

    companion object {
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        // 默认加载数据库、服务器两个数据源，顺序很重要
        val SOURCES = listOf(WeatherDbSource(), WeatherServerSource())
    }

    // 获取数据的方法
    fun requestCityId(cityId: String, days: Int): CityBean
        = sources.firstResult { requestSource(it, cityId, days) }


    private fun requestSource(source: WeatherDataSource, cityId: String, date: Int): CityBean? {
        val res = source.requestWeather(cityId, date)
        return if (res != null && res.size() >= date) res else null
    }

    // 返回第一个不是 null 结果，修改自 firstOrNull 方法
    private fun <T, R : Any> Iterable<T>.firstResult(predicate: (T) -> R?): R {
        for (element in this) {
            val result = predicate(element)
            if (result != null) return result
        }
        throw NoSuchElementException("No element matching predicate was found.")
    }
}


/** 数据库数据源 */
class WeatherDbSource(val db: Db = Db()) : WeatherDataSource {

    override fun requestWeather(cityId: String, days: Int): CityBean? {

        // 从数据库保存数据
        return db.requestWeather(cityId, days)
    }
}


/** 服务器数据源 */
class WeatherServerSource(val db: Db = Db()) : WeatherDataSource {

    override fun requestWeather(cityId: String, days: Int): CityBean? {

        // 从网络请求数据
        val cityBean = WeatherTask(cityId).execute()
        // 保存到数据库
        db.saveForecast(cityId, cityBean)
        return cityBean
    }
}
