package com.ssyijiu.weatherapp.dao

import com.ssyijiu.weatherapp.net.data.CityBean
import com.ssyijiu.weatherapp.net.data.WeatherBean

/**
 * Created by ssyijiu on 2017/6/13.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 */

class DbMapper {

    fun convert2CityBean(cityModel: CityModel) = with(cityModel) {
        val weatherVOList = weatherModelList.map { convert2WeatherBean(it) }
        CityBean(city, country, weatherVOList)
    }

    fun convert2WeatherBean(weatherModel: WeatherModel) = with(weatherModel) {
        WeatherBean(date, description, high, low, iconUrl)
    }

    fun convert2CityModel(cityId: Long, cityVO: CityBean) = with(cityVO) {
        val daily = weatherBeanList.map { convert2WeatherModel(cityId, it) }
        CityModel(cityId, city, country, daily)
    }

    fun convert2WeatherModel(cityId: Long, weatherVO: WeatherBean) =
        with(weatherVO) {
            WeatherModel(date, description, high, low, iconUrl, cityId)
        }
}
