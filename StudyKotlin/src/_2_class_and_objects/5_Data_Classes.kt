package _2_class_and_objects

/**
 * Created by ssyijiu on 2017/5/24.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 */

fun main(args: Array<String>) {
    val lxm = User()
    lxm.name = "lxm"
    println(lxm)
    val cjq = lxm.copy("cjq",8)
    println(cjq)

    val jane = User("Jane", 35)
    val (name, age) = jane
    println("$name, $age years of age") // 输出 "Jane, 35 years of age"

    println(Pair("a","b"))
}


data class User(var name: String = "",
                var age: Int = 0,
                var address : String = "China")