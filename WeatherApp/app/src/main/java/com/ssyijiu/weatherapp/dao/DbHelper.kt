package com.ssyijiu.weatherapp.dao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.ssyijiu.weatherapp.App
import org.jetbrains.anko.db.*

/**
 * Created by ssyijiu on 2017/6/4.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 *
 * SQLiteOpenHelper 创建、更新数据库
 */

class DbHelper(context: Context = App.instance) : ManagedSQLiteOpenHelper(
    context,
    DbHelper.DB_NAME,
    null,
    DbHelper.DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {

        // 创建表
        db.createTable(CityTable.NAME, // 表名
            true, // if true 创建之前检查这个表是否存在
            // Pair(CityTable.ID, INTEGER + PRIMARY_KEY),
            // Pair(CityTable.CITY, TEXT),
            // Pair(CityTable.COUNTRY, TEXT)
            // Pair 的重载函数
            CityTable.ID to INTEGER + PRIMARY_KEY,
            CityTable.CITY to TEXT,
            CityTable.COUNTRY to TEXT)

        db.createTable(WeatherTable.NAME, true,
            WeatherTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            WeatherTable.DATE to INTEGER,
            WeatherTable.DESCRIPTION to TEXT,
            WeatherTable.HIGH to INTEGER,
            WeatherTable.LOW to INTEGER,
            WeatherTable.ICON_URL to TEXT,
            WeatherTable.CITY_ID to INTEGER)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        // 删除表
        db.dropTable(CityTable.NAME, true)
        db.dropTable(WeatherTable.NAME, true)

        // 重建表
        onCreate(db)
    }

    companion object {
        val DB_NAME = "forecast.db"
        val DB_VERSION = 1

        // DbHelper 单例，懒加载，线程安全
        val instance: DbHelper by lazy { DbHelper() }
    }
}


