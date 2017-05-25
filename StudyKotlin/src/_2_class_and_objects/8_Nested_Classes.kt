package _2_class_and_objects

/**
 * Created by ssyijiu on 2017/5/24.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */

fun main(args: Array<String>) {
    val demo = OuterClass.Nested().foo()
    val demo2 = OuterClass.Nested().foo2()
    println("OuterClass foo is $demo")
    println("OuterClass foo2 is $demo2")

    val inner = OuterA().Inner().foo()
    println("OuterA inner is $inner")

    start()
}

// 1. 嵌套类
class OuterClass {

    private val bar: Int = 1

    // 一个类可以嵌套到其他类中
    class Nested {
        fun foo() = 2
        // 嵌套类不是内部类，不能直接访问外部类的成员
        // 需要这样
        fun foo2() = OuterClass().bar
    }
}

// 2. 内部类

class OuterA {
    private val bar: Int = 1

    // 内部类使用 inner 标记
    inner class Inner {
        // 内部类可以直接访问外部类的成员
        fun foo() = bar
    }
}

// 3. 匿名内部类
fun start() {

    // 匿名内部类
    Thread(object : Runnable {
        override fun run() {
        }
    }).start()

    // 写成 lambda 形式
    Thread(Runnable {
        print(Thread.currentThread().name)
    }).start()
}

