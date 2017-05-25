package _3_functions_and_lambdas


/**
 * Created by ssyijiu on 2017/5/25.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 */

fun main(args: Array<String>) {
    default(1, z = 3)

    B().foo()

    val a = arrayOf(1, 2, 3)
    val list = asList(*a)
    println(list)

    addY(1)

}

fun default(x: Int = 1, y: String = "", z: Int = 4) {
    println("x = $x")
    println("y = $y")
    println("z = $z")
}


open class A {
    open fun foo(i: Int = 10) {}
}

class B : A() {
    override fun foo(i: Int) {
        println(i)
    }  // 不能有默认值
}


fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) // ts is an Array
        result.add(t)
    return result
}

tailrec fun addY(y: Int = 1): Int {
    if (y == 100) {
        return y
    } else {
        val x = y + 1
        println(x)
        return addY(x)
    }
}