package com.ssyijiu.weatherapp.dao

/**
 * Created by ssyijiu on 2017/6/4.
 * Github : ssyijiu
 * Email  : lxmyijiu@163.com
 */

object CityForecastTable {
    val NAME = "CityForecast"
    val ID = "_id"
    val CITY = "city"
    val COUNTRY = "country"
}

object DayForecastTable {
    val NAME = "DayForecast"
    val ID = "_id"
    val DATE = "date"
    val DESCRIPTION = "description"
    val HIGH = "high"
    val LOW = "low"
    val ICON_URL = "iconUrl"
    val CITY_ID = "cityId"
}