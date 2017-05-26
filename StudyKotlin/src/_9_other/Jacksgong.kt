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

    val something = Values.FINAL_STATIC_PROPERTY
    println(something)

    Values.STATIC_PROPERTY = "xxx"
    println(Values.STATIC_PROPERTY)

    // 智能cast
//    if (node is Leaf) {
//        return node.symbol //智能的将node转为Leaf类型，暴露Leaf的变量(symbol)
//    }

    // 支持 Java8 的各种新特性
    val numbers = listOf(-42, 17, 13, -9, 12)
    val nonNegative = numbers.filter { it >= 0 }  // 过滤出元素大于 0 的 list
    println(nonNegative)

    var rxjava = listOf(1, 2, 3, 4)
    rxjava = rxjava.map { it * 10 }  // [10, 20, 30, 40]
    println(rxjava)
    rxjava = rxjava.filter { it > 20 }  // [30, 40]
    println(rxjava)
    rxjava.forEach {
        print(it)
        print("、")
    }


}

fun doAnything() {
    println("doAnything")
}


class Values {
    companion object {
        // 定义 final static 变量
        val FINAL_STATIC_PROPERTY: String = "final static property"
        // 定义 static 变量
        var STATIC_PROPERTY: String = "static property"
    }
}
