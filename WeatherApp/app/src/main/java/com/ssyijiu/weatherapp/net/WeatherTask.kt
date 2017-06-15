package com.ssyijiu.weatherapp.net

import com.ssyijiu.weatherapp.entries.DTO2VO
import com.ssyijiu.weatherapp.entries.vo.CityVO

/**
 * Created by ssyijiu on 2017/6/3.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */


class WeatherTask(private val cityId: String) : Task<CityVO> {

    override fun execute(): CityVO {

        // request net get DTO
        val forecastRequest = WeatherRequest(cityId)

        // convert DTO to VO
        return DTO2VO().convert(
            forecastRequest.request())
    }
}