package _1_base

import _0_start.parseInt


/**
 * Created by ssyijiu on 2017/5/22.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 */

fun main(args: Array<String>) {
    _when_4(1)
}

// 1. if
fun _if(a: Int, b: Int) {
    val max = if (a > b) {
        println("Choose a")
        a
    } else {
        println("Choose b")
        b
    }
    println("max = $max")
}

// 2. when
fun _when_1(x: Int) {
    when (x) {
        1 -> print("x == 1")
        2 -> print("x == 2")
        else -> { // 注意这个块
            print("x is neither 1 nor 2")
        }
    }
}


fun _when_2(i: Int) {
    val x = when (i) {
        1 -> {
            println("x == 1")
            1
        }
        2 -> {
            println("x == 2")
            2
        }
        else -> {
            println("x is neither 1 nor 2")
            3
        }
    }

    println("x = $x")
}

fun _when_3(x: Int) {
    when (x) {
        0, 1 -> print("x == 0 or x == 1")
        else -> print("otherwise")
    }
}


fun _when_4(x: Int) {
    when (x) {
        parseInt("1") -> print("s encodes x")
        else -> print("s does not encode x")
    }
}

