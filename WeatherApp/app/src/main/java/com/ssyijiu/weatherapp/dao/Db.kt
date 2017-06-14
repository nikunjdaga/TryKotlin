package com.ssyijiu.weatherapp.dao

import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.SelectQueryBuilder
import org.jetbrains.anko.db.select

/**
 * Created by ssyijiu on 2017/6/13.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 */
class Db(

    // DbHelper
    val dbHelper: DbHelper = DbHelper.instance,

    val dataMapper: DbDataMapper = DbDataMapper()) {

    fun requestWeather(cityId: Long, date: Long) = dbHelper.use {

        // SQL，查询某个城市某个时间段的天气详情
        val sql = "${WeatherTable.CITY_ID} = ? " +
            "AND ${WeatherTable.DATE} >= ?"

        val weatherList = select(WeatherTable.NAME)
            // 返回 SelectQueryBuilder，这里面封装了各种查询条件
            // 调用 parse 系列函数的时候真正的执行 SQL 语句，返回 Cursor
            .whereSimple(sql, cityId.toString(), date.toString())

            // it 是 parseRow 的参数 columns，是一个 map
            // 调用 columns HashMap(Map<? extends K, ? extends V> m) 创建 HashMap
            // 调用 WeatherModel(var map: MutableMap<String, Any?>) 创建 WeatherModel
            .parseList { WeatherModel(HashMap(it)) }


        // 查询城市，将前面查出来的天气信息赋值到城市中
        val city = select(CityTable.NAME)
            .whereSimple("${CityTable.ID} = ?", cityId.toString())
            .parseOpt { CityModel(HashMap(it), weatherList) }

        if (city != null) dataMapper.convertToCityModel(city) else null
    }
}


fun <T : Any> SelectQueryBuilder.parseList(parser: (Map<String, Any?>) -> T) : List<T> =

    // 1. AnkoInternals.useCursor(doExec()) 执行 sql 语句，返回 Cursor
    // 2. 将 Cursor 每一行转换成一个 map，列名作为 key，列值作为 value
    // 3. 使用自己重写的 parseRow 将 map 转换为 Bean，即 parser(columns)
    // 4. 将 Bean 添加到 List 中
    parseList(object : MapRowParser<T> {
    override fun parseRow(columns: Map<String, Any?>): T = parser(columns)
})


fun <T : Any> SelectQueryBuilder.parseOpt(parser: (Map<String, Any?>) -> T): T? =
    // parseOpt 查询结果大于 1 条抛出异常，0 条返回 null
    parseOpt(object : MapRowParser<T> {
        override fun parseRow(columns: Map<String, Any?>): T = parser(columns)
    })

