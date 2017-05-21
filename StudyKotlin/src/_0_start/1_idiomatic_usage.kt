package _0_start

/**
 * Created by ssyijiu on 2017/5/19.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 */

fun main(args: Array<String>) {
    _1()
}

// 1.DTOs
data class Person(val name: String, var age: Int)

fun _1() {
    var p = Person("lxm",25)

    p.age = 22

    // class 用 data 标记输出：Person(name=lxm, age=25)
    // 如果不用 data 标记输出： _0_start.Person@5e481248
    hi(p.toString())
}
