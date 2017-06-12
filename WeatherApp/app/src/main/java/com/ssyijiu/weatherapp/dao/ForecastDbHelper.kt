package com.ssyijiu.weatherapp.dao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.ssyijiu.weatherapp.App
import org.jetbrains.anko.db.*

/**
 * Created by ssyijiu on 2017/6/4.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */

class ForecastDbHelper(context: Context = App.instance) : ManagedSQLiteOpenHelper(
    context,
    ForecastDbHelper.DB_NAME,
    null,
    ForecastDbHelper.DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {

        db.createTable(CityForecastTable.NAME, // 表名
            true, // if true 创建之前检查这个表是否存在
            // Pair(CityForecastTable.ID, INTEGER + PRIMARY_KEY),
            // Pair(CityForecastTable.CITY, TEXT),
            // Pair(CityForecastTable.COUNTRY, TEXT)
            // Pair 的重载函数
            CityForecastTable.ID to INTEGER + PRIMARY_KEY,
            CityForecastTable.CITY to TEXT,
            CityForecastTable.COUNTRY to TEXT)

        db.createTable(DayForecastTable.NAME, true,
            DayForecastTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            DayForecastTable.DATE to INTEGER,
            DayForecastTable.DESCRIPTION to TEXT,
            DayForecastTable.HIGH to INTEGER,
            DayForecastTable.LOW to INTEGER,
            DayForecastTable.ICON_URL to TEXT,
            DayForecastTable.CITY_ID to INTEGER)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        // 删除表
        db.dropTable(CityForecastTable.NAME, true)
        db.dropTable(DayForecastTable.NAME, true)

        // 重建表
        onCreate(db)
    }

    companion object {
        val DB_NAME = "forecast.db"
        val DB_VERSION = 1

        // ForecastDbHelper 单例，懒加载，线程安全
        val instance: ForecastDbHelper by lazy { ForecastDbHelper() }
    }
}


