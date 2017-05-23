package _2_class

/**
 * Created by ssyijiu on 2017/5/23.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 */

fun main(args: Array<String>) {
    var k = K()
    k.isEmpty = false
    println(k.size)
}

class K {
    var size = 0

    var isEmpty: Boolean
        get() = this.size == 0
        set(value) {
            this.size = if(value) 0 else 100
        }
}