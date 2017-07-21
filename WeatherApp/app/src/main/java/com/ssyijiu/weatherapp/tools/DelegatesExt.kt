package com.ssyijiu.weatherapp.tools

import kotlin.properties.ReadWriteProperty

/**
 * Created by ssyijiu on 2017/7/18.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */

class DelegatesExt {

    companion object {
        fun <T> notNullSingleValue():
            ReadWriteProperty<Any?, T> = NotNullSingleValueVar()

        fun <T : Any>preference(key: String, default: T) =
            Preference(key, default)
    }
}