package com.ssyijiu.weatherapp.dao

/**
 * Created by ssyijiu on 2017/6/13.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 */

class DbDataMapper {
    fun convertToCityModel(cityModel: CityModel) = with(cityModel) {
        val daily = weatherList.map { convertToWeatherModel(it) }
        CityModel(_id, city, country, daily)
    }

    private fun convertToWeatherModel(weatherModel: WeatherModel) = with(weatherModel) {
        WeatherModel(date, description, high, low, iconUrl, cityId)
    }
}
