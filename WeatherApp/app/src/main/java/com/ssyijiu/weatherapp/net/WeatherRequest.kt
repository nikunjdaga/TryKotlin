package com.ssyijiu.weatherapp.net

import com.google.gson.Gson
import com.ssyijiu.weatherapp.net.data.WeatherResultResp
import java.net.URL

/**
 * Created by ssyijiu on 2017/6/3.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 *
 * 请求网络，获取 DTO
 */

class WeatherRequest(val cityId: Long) {

    // url
    companion object {

        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/" +
            "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }

    fun request(): WeatherResultResp {
        // request json
        val forecastJsonStr = URL(COMPLETE_URL + cityId).readText()
        // json to bean
        return Gson().fromJson(forecastJsonStr, WeatherResultResp::class.java)
    }
}
