package _2_class_and_objects

/**
 * Created by ssyijiu on 2017/5/25.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 */

fun main(args: Array<String>) {

    println(ab.y)
    println(ab is B)
    foo()

}

open class A(x: Int) {
    open val y: Int = x
}

interface B {
    val x : Int
}

// 1.继承与实现接口
// ab 继承 A，实现 B
// 声明的时候是 A 无法调用 B 的方法
val ab: A = object : A(1), B {
    override val x = 7
    override val y = 15
}

// 2.匿名对象
fun foo() {
    val adHoc = object {
        var x: Int = 3
        var y: Int = 7
    }
    print(adHoc.x + adHoc.y)
}

// 3.
class CC {
    // 私有函数，所以其返回类型是匿名对象类型
    private fun foo() = object {
        val x: String = "x"
    }

    // 公有函数，所以其返回类型是 Any
    fun publicFoo() = object {
        val x: String = "x"
    }

    fun bar() {
        val x1 = foo().x        // 没问题
        // val x2 = publicFoo().x  // 错误：未能解析的引用“x”
    }
}

// 4. 单例模式