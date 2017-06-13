package com.ssyijiu.weatherapp.entries

import com.ssyijiu.weatherapp.entries.dto.ForecastDTO
import com.ssyijiu.weatherapp.entries.dto.ForecastResultDTO
import com.ssyijiu.weatherapp.entries.vo.ForecastListVO
import com.ssyijiu.weatherapp.entries.vo.ForecastVO
import java.text.DateFormat
import java.util.*

/**
 * Created by ssyijiu on 2017/6/3.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 *
 * 将 DTO 转换为 VO
 */


class ForecastDataMapper {

    fun convertFromDataModel(forecast: ForecastResultDTO): ForecastListVO {
        return ForecastListVO(forecast.city.name, forecast.city.country,
            convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<ForecastDTO>): List<ForecastVO> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: ForecastDTO): ForecastVO {
        return ForecastVO(convertDate(forecast.dt),
            forecast.weather[0].description, forecast.temp.max.toInt(),
            forecast.temp.min.toInt(), generateIconUrl(forecast.weather[0].icon))
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }

    private fun generateIconUrl(iconCode: String): String
        = "http://openweathermap.org/img/w/$iconCode.png"
}


