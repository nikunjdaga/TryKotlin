package com.ssyijiu.weatherapp.dao

/**
 * Created by ssyijiu on 2017/6/13.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 *
 * Model 保存到数据库中的数据
 * DTO -> VO -> Model
 */


/**
 * 城市信息，包含一系列的天气详情
 */
class CityModel(val map: MutableMap<String, Any?>,
                val weatherList: List<WeatherModel>) {
    // id、city、country 三个字段都会映射到 map 中
    var _id: Long by map
    var city: String by map
    var country: String by map

    constructor(id: Long, city: String, country: String,
                weatherList: List<WeatherModel>) : this(HashMap(), weatherList) {
        this._id = id
        this.city = city
        this.country = country
    }
}


/**
 * 天气信息
 */
class WeatherModel(var map: MutableMap<String, Any?>) {
    var _id: Long by map
    var date: String by map
    var description: String by map
    var high: Int by map
    var low: Int by map
    var iconUrl: String by map
    var cityId: Long by map

    constructor(date: String, description: String, high: Int, low: Int,
                iconUrl: String, cityId: Long) : this(HashMap()) {
        this.date = date
        this.description = description
        this.high = high
        this.low = low
        this.iconUrl = iconUrl
        this.cityId = cityId
    }
}