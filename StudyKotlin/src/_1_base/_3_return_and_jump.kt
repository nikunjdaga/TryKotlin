package _1_base

/**
 * Created by ssyijiu on 2017/5/22.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 */

fun main(args: Array<String>) {
    foo_3()
}


// 1.通过 @ 跳出循环
fun _break() {
    x@ for (i in 1..100) {
        println("i = $i")
        for (j in 1..100) {
            if (j == 10) {
                println("j = $j")
                break@x
            }
        }
    }
}


// 2.标签处返回
fun foo_1() {
    val ints = listOf(1, 2, 3)
    ints.forEach {
        if (it == 1) {
            print(it)
            return
        }

    }
    println("foo")
}

fun foo_2() {
    val ints = listOf(1, 2, 3)
    ints.forEach lit@ {
        if (it == 1) {
            println(it)
            return@lit
        }
    }
    println("foo")
}

fun foo_3() {
    val ints = listOf(1, 2, 3)
    ints.forEach {
        if (it == 1) {
            println(it)
            return@forEach
        }
    }
    println("foo")
}