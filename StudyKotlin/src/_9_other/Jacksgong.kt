package _9_other

/**
 * Created by ssyijiu on 2017/5/25.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */

// https://blog.dreamtobe.cn/2016/11/30/kotlin/

fun main(args: Array<String>) {

    var a: String = "abc" // 定义一个非 null 字符串
    //a = null           // 编译失败

    var b: String? = "abc" // 定义一个可以为 null 的字符串
    b = null
    //var l = b.length    // 编译失败，b 可能 null
    var l = b?.length     // b 为 null 时，返回 null
    l = b?.length ?: -1   // b 为 null 时，返回 -1
    //l = b!!.length      // 断言 b 不为 null，b null 空指针（KotlinNullPointerException）
    b?.let {
        // b 不为 null，执行 let 代码块
        println("b is not null")
    }

    val aInt: Int? = a as? Int  //（a as Int） a 强转 Int
    //（a as? Int）强转失败返回 null

    val nullableList = listOf(1, 2, null, 4)
    val intList = nullableList.filterNotNull()  // 过滤出不是 null 的元素


    val lazyValue: String by lazy {
        doAnything()       // 第一次 get 时执行这段代码
        "build lazy value" // 给 lazyValue 赋值

    }

    println(lazyValue)  // 执行 doAnything
    println(lazyValue)  // 不执行 doAnything

}

fun doAnything() {
    println("doAnything")
}

