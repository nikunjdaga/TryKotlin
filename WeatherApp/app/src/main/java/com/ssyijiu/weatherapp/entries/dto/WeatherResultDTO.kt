package com.ssyijiu.weatherapp.entries.dto

/**
 * Created by ssyijiu on 2017/6/3.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 *
 * DTO 从服务器获取的数据
 */

data class WeatherResultDTO(val city: CityDTO, val list: List<WeatherDTO>)

data class CityDTO(val id: Long, val name: String, val coord: CoordinatesDTO,
                   val country: String, val population: Int)

data class CoordinatesDTO(val lon: Float, val lat: Float)

data class WeatherDTO(val dt: Long, val temp: TemperatureDTO, val pressure: Float,
                      val humidity: Int, val weather: List<WeatherDescDTO>,
                      val speed: Float, val deg: Int, val clouds: Int,
                      val rain: Float)

data class TemperatureDTO(val day: Float, val min: Float, val max: Float,
                          val night: Float, val eve: Float, val morn: Float)

data class WeatherDescDTO(val id: Long, val main: String, val description: String,
                          val icon: String)
