package com.ssyijiu.weatherapp.net.data

import java.text.DateFormat
import java.util.*

/**
 * Created by ssyijiu on 2017/6/3.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 *
 */


class ApiMapper {

    // WeatherResultResp -> CityBean
    fun convert(result: WeatherResultResp): CityBean {
        return CityBean(result.city.name, result.city.country,
            convertWeatherList(result.list))
    }

    private fun convertWeatherList(list: List<WeatherResp>): List<WeatherBean> {
        return list.map { convertWeatherItem(it) }
    }

    private fun convertWeatherItem(weather: WeatherResp): WeatherBean {
        return WeatherBean(convertDate(weather.dt),
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


