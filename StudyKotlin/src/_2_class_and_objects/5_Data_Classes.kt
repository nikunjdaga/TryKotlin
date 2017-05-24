package _2_class_and_objects

/**
 * Created by ssyijiu on 2017/5/24.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 */

fun main(args: Array<String>) {
    val lxm = User("lxm", 18)
    println(lxm)
    val cjq = lxm.copy("cjq", 17)
    println(cjq)
}


data class User(val name: String,
                val age: Int)