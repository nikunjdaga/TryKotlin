package com.ssyijiu.weatherapp.dao

/**
 * Created by ssyijiu on 2017/6/4.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 *
 * 数据库表结构，两张表，一张城市表，一张天气表
 */

object CityTable {
    val NAME = "CityModel"       // 城市信息
    val ID = "_id"               // 城市 id
    val CITY = "city"            // 城市名称
    val COUNTRY = "country"      // 位于哪个国家
}

object WeatherTable {
    val NAME = "WeatherModel"        // 天气信息
    val ID = "_id"                   // id
    val DATE = "date"                // 具体时间
    val DESCRIPTION = "description"  // 描述
    val HIGH = "high"                // 高温
    val LOW = "low"                  // 低温
    val ICON_URL = "iconUrl"         // icon 图片
    val CITY_ID = "cityId"           // 对应城市 id
}