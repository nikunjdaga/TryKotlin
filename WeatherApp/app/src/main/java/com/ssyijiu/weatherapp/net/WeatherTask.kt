package com.ssyijiu.weatherapp.net

import com.ssyijiu.weatherapp.net.data.ApiMapper
import com.ssyijiu.weatherapp.net.data.CityBean

/**
 * Created by ssyijiu on 2017/6/3.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */


class WeatherTask(private val cityId: String) : Task<CityBean> {

    override fun execute(): CityBean {

        // request net get DTO
        val forecastRequest = WeatherRequest(cityId)

        // convert DTO to VO
        return ApiMapper().convert(
            forecastRequest.request())
    }
}