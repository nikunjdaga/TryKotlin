package com.ssyijiu.weatherapp.net

import com.ssyijiu.weatherapp.entries.ForecastDataMapper
import com.ssyijiu.weatherapp.entries.vo.ForecastListVO

/**
 * Created by ssyijiu on 2017/6/3.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */


class RequestForecastCommand(private val cityId: String) : Command<ForecastListVO> {

    override fun execute(): ForecastListVO {

        // request net get DTO
        val forecastRequest = ForecastRequest(cityId)

        // convert DTO to VO
        return ForecastDataMapper().convertFromDataModel(
            forecastRequest.request())
    }
}