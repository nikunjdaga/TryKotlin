package com.ssyijiu.weatherapp.dao

import com.ssyijiu.weatherapp.entries.vo.CityVO
import com.ssyijiu.weatherapp.entries.vo.WeatherVO

/**
 * Created by ssyijiu on 2017/6/13.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 */

class DbMapper {

    fun convert2CityVO(cityModel: CityModel) = with(cityModel) {
        val weatherVOList = weatherModelList.map { convert2WeatherVO(it) }
        CityVO(city, country, weatherVOList)
    }

    private fun convert2WeatherVO(weatherModel: WeatherModel) = with(weatherModel) {
        WeatherVO(date, description, high, low, iconUrl)
    }

    fun convert2CityModel(cityId: Long, cityVO: CityVO) = with(cityVO) {
        val daily = weatherVOList.map { convert2WeatherModel(cityId, it) }
        CityModel(cityId, city, country, daily)
    }

    private fun convert2WeatherModel(cityId: Long, weatherVO: WeatherVO) =
        with(weatherVO) {
            WeatherModel(date, description, high, low, iconUrl, cityId)
        }
}
