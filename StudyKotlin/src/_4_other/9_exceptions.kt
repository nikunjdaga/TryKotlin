package _4_other


/**
 * Created by ssyijiu on 2017/6/2.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */

fun main(args: Array<String>) {

    // try 是一个表达式
    // 返回 try 中的最后一个表达式 或者 catch 中最后一个表达式
    var a: Int? = try {
        parseInt("4e")
        println("NumberFormatException")
        7
    } catch (e: NumberFormatException) { null }
    println(a)


    // Nothing 不太懂 。。
    val s = a?: fail("Name required")
    println(s)     // 在此已知“s”已初始化
}


fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}


fun parseInt(str: String): Int? {
    try {
        val x = str.toInt()
        return x
    } catch (e: Throwable) {
        throw NumberFormatException()
    }
}

// Kotlin 中的异常和 Java 差不多
// 所有的异常都是 Throwable 的子类
// try catch finally