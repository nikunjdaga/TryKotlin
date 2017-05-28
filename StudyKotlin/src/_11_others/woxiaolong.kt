package _11_others

/**
 * Created by ssyijiu on 2017/5/28.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */

fun main(args: Array<String>) {
    // Kotlin 没有隐式向上转型，必须主动转型
    val long = 1L
    // val i:Int = long 编译错误
    val i:Int = long.toInt()   // 主动转型
}