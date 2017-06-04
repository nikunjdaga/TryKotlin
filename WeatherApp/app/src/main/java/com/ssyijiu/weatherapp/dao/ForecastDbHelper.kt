package com.ssyijiu.weatherapp.dao

import android.database.sqlite.SQLiteDatabase
import com.ssyijiu.weatherapp.App
import org.jetbrains.anko.db.*

/**
 * Created by ssyijiu on 2017/6/4.
 * Github : ssyijiu
 * Email  : lxmyijiu@163.com
 */

class ForecastDbHelper() : ManagedSQLiteOpenHelper(App.instance,
                ForecastDbHelper.DB_NAME,
                null,
                ForecastDbHelper.DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(CityForecastTable.NAME,  // 表名
            true,  // if true 创建之前检查这个表是否存在
            Pair(CityForecastTable.ID, INTEGER + PRIMARY_KEY),
            Pair(CityForecastTable.CITY, TEXT),
            Pair(CityForecastTable.COUNTRY, TEXT)
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        val DB_NAME = "forecast.db"
        val DB_VERSION = 1

        // ForecastDbHelper 单例，懒加载，线程安全
        val instance: ForecastDbHelper by lazy { ForecastDbHelper() }
    }
}


