package com.ssyijiu.weatherapp.dao

/**
 * Created by ssyijiu on 2017/6/13.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 */

class DbDataMapper {
    fun convertToModel(forecast: CityForecast) = with(forecast) {
        val daily = detailedForecast.map { convertDayToModel(it) }
        CityForecast(_id, city, country, daily)
    }

    private fun convertDayToModel(dayForecast: DetailedForecast) = with(dayForecast) {
        DetailedForecast(date, description, high, low, iconUrl, cityId)
    }
}
