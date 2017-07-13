package com.ssyijiu.weatherapp.net.data

/**
 * Created by ssyijiu on 2017/6/3.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */


data class CityBean(val city: String, val country: String,
                    val weatherBeanList: List<WeatherBean>) {

    val mDatas : MutableList<WeatherBean> = arrayListOf()
    init {
        mDatas.addAll(weatherBeanList)
        mDatas.addAll(weatherBeanList)
    }

    // 重载 get 方法
    operator fun get(position: Int) = mDatas[position]

    fun size() = mDatas.size
}

data class WeatherBean(val date: String, val description: String, val high: Int,
                       val low: Int, val iconUrl: String) {
    val highColor = getColor(high)
    val lowColor = getColor(low)


    private fun getColor(temperature : Int) =
        when(temperature) {
            in -50..0 -> android.R.color.holo_blue_dark
            in 0..15 -> android.R.color.holo_green_dark
            else -> android.R.color.holo_red_dark
        }
}