package com.ssyijiu.weatherapp.tools;

/**
 * Created by ssyijiu on 2017/7/21.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 */

fun String.toLongSafe(): Long {
    try {
        return toLong()
    } catch(e: NumberFormatException) {
        return 0
    }
}