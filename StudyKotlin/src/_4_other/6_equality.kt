package _4_other

/**
 * Created by ssyijiu on 2017/5/31.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */

fun main(args: Array<String>) {
    val a: String? = ""
    val b: String? = null

    a?.equals(b) ?: (b === null)
    // a 不是 null 调用 .equals(b)
    // a 是 null 判断 b === null

    // 调用格式  xxx?.(调用方法) ?:(否则)  yyyyy 返回值



}

// 引用相等 === ，!==
// a === b 当且仅当 a 和 b 指向同一个对象时

// 值相等  == , !=
// a == b
// a?.equals(b) ?: (b === null)