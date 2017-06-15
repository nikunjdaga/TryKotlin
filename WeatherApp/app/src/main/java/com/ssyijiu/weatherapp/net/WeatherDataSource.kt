package com.ssyijiu.weatherapp.net

import com.ssyijiu.weatherapp.dao.Db
import com.ssyijiu.weatherapp.dao.DbHelper
import com.ssyijiu.weatherapp.dao.DbMapper
import com.ssyijiu.weatherapp.entries.ApiMapper
import com.ssyijiu.weatherapp.entries.vo.CityVO

/**
 * Created by ssyijiu on 2017/6/15.
 * Github : ssyijiu
 * Email  : lxmyijiu@163.com
 */

interface WeatherDataSource {
    fun requestWeather(cityId: Long, date: Long): CityVO
}

class WeatherProvider(val sources: List<WeatherDataSource> =
                      WeatherProvider.SOURCES) {

    companion object {
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCES = listOf(WeatherDb(), WeatherServer())
    }

    fun requestCityId(id: Long, days: Int): CityVO
        = sources.firstResult{ requestSource(it, days, id) }
}

fun requestSource(source: WeatherDataSource, days: Int, zipCode: Long):
    CityVO? {
    val res = source.requestForecastByZipCode(zipCode, todayTimeSpan())
    return if (res != null && res.size() >= days) res else null
}

class WeatherDb(val dbHelper: DbHelper = DbHelper.instance,
                val dbMapper: DbMapper = DbMapper()) : WeatherDataSource {

    override fun requestWeather(cityId: Long, date: Long): CityVO {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class WeatherServer(val apiMapper: ApiMapper = ApiMapper(),
                    val db: Db = Db()) : WeatherDataSource {

    override fun requestWeather(cityId: Long, date: Long): CityVO {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

inline fun <T, R : Any> Iterable<T>.firstResult(predicate: (T) -> R?) : R {
    for (element in this){
        val result = predicate(element)
        if (result != null) return result
    }
    throw NoSuchElementException("No element matching predicate was found.")
}