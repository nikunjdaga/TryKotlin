package _2_class_and_objects

import kotlin.reflect.KProperty

/**
 * Created by ssyijiu on 2017/5/25.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 */


fun main(args: Array<String>) {
    val e = Example()
    println(e.p)

}

class Example {
    var p: String by Delegate()
}

// 完全看不懂好吗 。。
class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name} in $thisRef.'")
    }
}