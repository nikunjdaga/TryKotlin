package _11_others

/**
 * Created by ssyijiu on 2017/5/28.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */

// https://github.com/MindorksOpenSource/from-java-to-kotlin
fun main(args: Array<String>) {

    // 空判断
    val str: String? = "xxx"
    // str.length  str 可能为 null 不可以直接调用它的方法
    str?.let {
        println(str.length)
    }

    // 换行
    val text = """
        #First Line
        #Second Line
        #Third Line
        """.trimMargin("#")  // 默认 /
    println(text)


    // for 循环
    for (it in 1..10) {
        print("$it 、")
    }
    println()

    for (it in 1..10 step 2) {
        print("$it 、")
    }
    println()

    val list = listOf(1, 2, 3, 4, 5)
    for (it in list) {
        print("$it 、")
    }
    println()

    val map = mapOf(
            "1" to "11",
            "2" to "22",
            "3" to "33",
            "4" to "44",
            "5" to "55"
    )

    for ((key, value) in map) {
        println("key = $key,value = $value")
    }

    // 集合遍历
    list.forEach { print("$it 、") }
    println()

    list.filter { it > 3 }
            .forEach { print("$it 、") }
    println()

    println(Utils.getValue(7))

    // 调用扩展函数
    println(7.triple())

}

// 构造函数、static 函数
class Utils private constructor() {
    companion object {
        fun getValue(value:Int) = value * 2
    }
}

// 扩展
fun Int.triple()  = this * 3