package com.ssyijiu.weatherapp.domain

import com.ssyijiu.weatherapp.domain.vo.ForecastList
import com.ssyijiu.weatherapp.net.ForecastRequest

/**
 * Created by ssyijiu on 2017/6/3.
 * Github : ssyijiu
 * Email  : lxmyijiu@163.com
 */


class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {

    override fun execute(): ForecastList {

        // request net get DTO
        val forecastRequest = ForecastRequest(zipCode)

        // convert DTO to VO
        return ForecastDataMapper().convertFromDataModel(
            forecastRequest.request())
    }
}