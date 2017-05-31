package _4_other

/**
 * Created by ssyijiu on 2017/5/31.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */

fun main(args: Array<String>) {

    val i = 3
    if (i in 1..10) {  // i>=1 && i<=10
        println(i)
    }


    // IntRange、 LongRange、 CharRange 可以迭代
    for (i in 1..3) {
        print("$i、")
    }
    println()

    // 逆序迭代
    for (i in 3 downTo 1) {
        print("$i、")
    }
    println()

    // 步长
    for (i in 10 downTo 1 step 2) {
        print("$i、")
    }
    println()

    // 排除结束元素
    for (i in 1 until 10) {   // i in [1, 10) 排除了 10
        print("$i、")
    }
}