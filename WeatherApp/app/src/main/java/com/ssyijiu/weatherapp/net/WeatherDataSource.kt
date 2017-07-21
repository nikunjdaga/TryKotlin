package com.ssyijiu.weatherapp.net

import com.ssyijiu.library.MLog
import com.ssyijiu.weatherapp.dao.Db
import com.ssyijiu.weatherapp.net.data.ApiMapper
import com.ssyijiu.weatherapp.net.data.CityBean
import com.ssyijiu.weatherapp.net.data.WeatherBean

/**
 * Created by ssyijiu on 2017/6/15.
 * GitHub : ssyijiu
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
    fun requestWeatherList(cityId: Long, date: Long): CityBean?
    fun requestWeatherDetail(cityId: Long, date: String): WeatherBean?
}


/** 数据库数据源 */
class WeatherDbSource(val db: Db = Db()) : WeatherDataSource {

    override fun requestWeatherList(cityId: Long, date: Long): CityBean? {
        return db.requestWeatherList(cityId, date)
    }

    override fun requestWeatherDetail(cityId: Long, date: String): WeatherBean? {
        return db.requestWeatherDetail(cityId, date)
    }

}


/** 服务器数据源 */
class WeatherServerSource(val db: Db = Db()) : WeatherDataSource {

    override fun requestWeatherList(cityId: Long, date: Long): CityBean? {

        // request net get DTO
        val forecastRequest = WeatherListRequest(cityId)

        // convert DTO to VO
        val cityBean = ApiMapper().convert(
            forecastRequest.request())
        // 保存到数据库
        db.saveWeatherList(cityId, cityBean)
        return cityBean
    }

    override fun requestWeatherDetail(cityId: Long, date: String): WeatherBean? = null
}
