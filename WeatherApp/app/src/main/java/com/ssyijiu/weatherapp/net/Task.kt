package com.ssyijiu.weatherapp.net


/**
 * Created by ssyijiu on 2017/6/3.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */


interface Task<out T> {
    fun execute(): T?
}