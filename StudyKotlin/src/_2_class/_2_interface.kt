package _2_class

/**
 * Created by ssyijiu on 2017/5/23.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 */

fun main(args: Array<String>) {
    var c = Child()
    c.bar()
    c.foo()
}

interface MyInterface {
    fun bar()
    fun foo() {
        // 默认的方法体
        println("foo")
    }
}

class Child : MyInterface {
    override fun bar() {
        println("bar")
    }
}

interface MyInterface2 {
    val prop: Int // 抽象的

    val propertyWithImplementation: String
        get() = "foo"
}

class Child2 : MyInterface2 {
    override val prop: Int = 29
}