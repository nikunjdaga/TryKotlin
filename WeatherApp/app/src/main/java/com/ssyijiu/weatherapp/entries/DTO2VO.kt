package com.ssyijiu.weatherapp.entries

import com.ssyijiu.weatherapp.entries.dto.WeatherDTO
import com.ssyijiu.weatherapp.entries.dto.WeatherResultDTO
import com.ssyijiu.weatherapp.entries.vo.WeatherListVO
import com.ssyijiu.weatherapp.entries.vo.WeatherVO
import java.text.DateFormat
import java.util.*

/**
 * Created by ssyijiu on 2017/6/3.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 *
 * 将 DTO 转换为 VO
 */


class DTO2VO {

    // WeatherResultDTO -> WeatherListVO
    fun convert(result: WeatherResultDTO): WeatherListVO {
        return WeatherListVO(result.city.name, result.city.country,
            convertWeatherList(result.list))
    }

    private fun convertWeatherList(list: List<WeatherDTO>): List<WeatherVO> {
        return list.map { convertWeatherItem(it) }
    }

    private fun convertWeatherItem(weather: WeatherDTO): WeatherVO {
        return WeatherVO(convertDate(weather.dt),
            weather.weather[0].description, weather.temp.max.toInt(),
            weather.temp.min.toInt(), getIconUrl(weather.weather[0].icon))
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }

    private fun getIconUrl(iconCode: String): String
        = "http://openweathermap.org/img/w/$iconCode.png"
}


