package com.ssyijiu.weatherapp.domain


/**
 * Created by ssyijiu on 2017/6/3.
 * Github : ssyijiu
 * Email  : lxmyijiu@163.com
 */


interface Command<out T> {
    fun execute(): T
}