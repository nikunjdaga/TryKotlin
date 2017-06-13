package com.ssyijiu.weatherapp.net


/**
 * Created by ssyijiu on 2017/6/3.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 *
 * 一个通用的任务执行接口
 * 调用 execute 执行任务
 */


interface Command<out T> {
    fun execute(): T
}