package com.ssyijiu.weatherapp.net.data

/**
 * Created by ssyijiu on 2017/6/3.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 *
 */

data class WeatherResultResp(val city: com.ssyijiu.weatherapp.net.data.CityResp, val list: List<com.ssyijiu.weatherapp.net.data.WeatherResp>)

data class CityResp(val id: Long, val name: String, val coord: com.ssyijiu.weatherapp.net.data.CoordinatesResp,
                    val country: String, val population: Int)

data class CoordinatesResp(val lon: Float, val lat: Float)

data class WeatherResp(val dt: Long, val temp: com.ssyijiu.weatherapp.net.data.TemperatureResp, val pressure: Float,
                       val humidity: Int, val weather: List<com.ssyijiu.weatherapp.net.data.WeatherDescResp>,
                       val speed: Float, val deg: Int, val clouds: Int,
                       val rain: Float)

data class TemperatureResp(val day: Float, val min: Float, val max: Float,
                           val night: Float, val eve: Float, val morn: Float)

data class WeatherDescResp(val id: Long, val main: String, val description: String,
                           val icon: String)
