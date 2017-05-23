/**
 * Created by ssyijiu on 2017/5/22.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 */

fun main(args: Array<String>) {
    val dog = Dog(12)
    println(dog)
    println(dog.age)
}

open class Dog(val name: String) {
    init {
        println("Dog's name is $name")
    }

    constructor(age: Int) : this("Tom") {
        println("Dog's age is $age")
        this.age = age
    }

    var age = 0
}

class Tom : Dog("tom")


open class Base {
    open fun v() {}
    fun nv() {}
}
class Derived() : Base() {
    override fun v() {
        super.v()
    }
}

open class Foo {
    open val x: Int get() { return 0 }
}


open class A {
    open fun f() { print("A") }
    fun a() { print("a") }
}

interface B {
    fun f() { print("B") } // 接口成员默认就是“open”的
    fun b() { print("b") }
}

class C() : A(), B {
    // 编译器要求覆盖 f()：
    override fun f() {
        super<A>.f() // 调用 A.f()
        super<B>.f() // 调用 B.f()
    }
}

abstract class Abs {
    abstract fun f()
}
