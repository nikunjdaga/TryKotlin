package _2_class_and_objects

/**
 * Created by ssyijiu on 2017/5/25.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 */


// 1.一个接口
interface Base {
    fun print()
}

// 2.实现它
class BaseImpl(val x: Int) : Base {
    override fun print() { print(x) }
}


// 3.将 Base 委托给 Derived
// 这样 Derived 就有了 Base 的所有内容，比继承更好
class Derived(b: Base) : Base by b {
    val a = 20
}


fun main(args: Array<String>) {
    val b = BaseImpl(10)
    val d = Derived(b)
    d.print()
    println(d.a)

}