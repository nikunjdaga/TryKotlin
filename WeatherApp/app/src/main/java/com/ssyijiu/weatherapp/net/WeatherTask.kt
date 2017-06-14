package com.ssyijiu.weatherapp.net

import com.ssyijiu.weatherapp.entries.DTO2VO
import com.ssyijiu.weatherapp.entries.vo.WeatherListVO

/**
 * Created by ssyijiu on 2017/6/3.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */


class WeatherTask(private val cityId: String) : Task<WeatherListVO> {

    override fun execute(): WeatherListVO {

        // request net get DTO
        val forecastRequest = WeatherRequest(cityId)

        // convert DTO to VO
        return DTO2VO().convert(
            forecastRequest.request())
    }
}