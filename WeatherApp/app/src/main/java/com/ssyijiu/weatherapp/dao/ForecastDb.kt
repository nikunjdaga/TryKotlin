package com.ssyijiu.weatherapp.dao

import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.SelectQueryBuilder
import org.jetbrains.anko.db.select

/**
 * Created by ssyijiu on 2017/6/13.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 */
class ForecastDb(

    // DbHelper
    val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance,

    val dataMapper: DbDataMapper = DbDataMapper()) {

    fun requestForecastByCityId(cityId: Long, date: Long) = forecastDbHelper.use {

        // 查询某个城市、某个时间段的天气详情
        val sql = "${DetailedForecastTable.CITY_ID} = ? " +
            "AND ${DetailedForecastTable.DATE} >= ?"

        val detailedForecast = select(DetailedForecastTable.NAME)
            .whereSimple(sql, cityId.toString(), date.toString())
            .parseList { DetailedForecast(HashMap(it)) }


        // 查询城市
        val city = select(CityForecastTable.NAME)
            .whereSimple("${CityForecastTable.ID} = ?", cityId.toString())
            .parseOpt { CityForecast(HashMap(it), detailedForecast) }

        if (city != null) dataMapper.convertToModel(city) else null
    }
}


// parseList 是 SelectQueryBuilder 的扩展函数
// 参数是 parser 一个 lambda 类型
// 返回值是  List<T>
// 调用 parseList(MapRowParser) （重载方法）
// 为了获取 MapRowParser
// 创建一个 MapRowParser 的内部类
// 重写 parseRow，将参数交给 parseRow 解析
// 成功获取 MapRowParser，成功获取我们要的 List<T>

fun <T : Any> SelectQueryBuilder.parseList(parser: (Map<String, Any?>) -> T)
    : List<T> = parseList(object : MapRowParser<T> {
    override fun parseRow(columns: Map<String, Any?>): T = parser(columns)
})


fun <T : Any> SelectQueryBuilder.parseOpt(parser: (Map<String, Any?>) -> T): T? =
    parseOpt(object : MapRowParser<T> {
        override fun parseRow(columns: Map<String, Any?>): T = parser(columns)
    })

