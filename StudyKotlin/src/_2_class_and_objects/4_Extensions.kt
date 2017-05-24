package _2_class_and_objects

/**
 * Created by ssyijiu on 2017/5/24.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 */

fun main(args: Array<String>) {
    printFoo(D())
}


class Ex(var x: Int) {
    fun printX() = println(x)
}

fun Ex.setX(x: Int) {
    this.x = x
}


// -------------------------

open class C {
    open fun foo() = "c"
}

class D: C() {
    override fun foo(): String {
        return "d"
    }
}

fun printFoo(c: C) {
    println(c.foo())
}
