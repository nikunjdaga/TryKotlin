package com.ssyijiu.weatherapp.entries.dto

/**
 * Created by ssyijiu on 2017/6/3.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 *
 * DTO 从服务器获取的数据
 */

data class WeatherResult(val city: City, val list: List<Weather>)

data class City(val id: Long, val name: String, val coord: Coordinates,
                val country: String, val population: Int)

data class Coordinates(val lon: Float, val lat: Float)

data class Weather(val dt: Long, val temp: Temperature, val pressure: Float,
                   val humidity: Int, val weather: List<WeatherDesc>,
                   val speed: Float, val deg: Int, val clouds: Int,
                   val rain: Float)

data class Temperature(val day: Float, val min: Float, val max: Float,
                       val night: Float, val eve: Float, val morn: Float)

data class WeatherDesc(val id: Long, val main: String, val description: String,
                       val icon: String)
