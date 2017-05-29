package _4_other

/**
 * Created by ssyijiu on 2017/5/29.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */

// 解构说明

fun main(args: Array<String>) {
    val lang = Lang("Yin", "wangyin")
    println(lang)

    // 一个对象可以被分解成变量
    // 只能解构构造函数
    val (name, author) = lang
    println("name = $name,author = $author")

    // 实际上是这样的
    val name2 = lang.component1()
    val author2 = lang.component2()
    println(name2)
    println(author2)


    // for 循环中的解构
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
    println()

    // 函数返回值可以直接解构
    val (result, status) = foo()
    println("result = $result,status = $status")


}

data class Lang(val name: String, val author: String) {
    val age: Int = 0

}

data class Result(val result: Int, val status: String)

fun foo(): Result {
    return Result(1, "1")
}
