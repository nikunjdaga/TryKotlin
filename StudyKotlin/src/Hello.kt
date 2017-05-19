/**
 * Created by ssyijiu on 2017/5/19.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 */


fun main(args: Array<String>) {
//    val msg = "Hello Kotlin"  // final
//    println(msg)

//    whenTry(0)
//    whenTry(2)
//    whenTry(12)
//    whenTry(999)
//    whenTry(77)

    val p = Person(24,"lxm")
    print(p.name)

}


fun whenTry(x: Int) {
    when (x) {
        0 -> println("x is 0")
        in 1..10 -> println("x is in 1..10")
        in 10..20 -> println("x is in 1..20")
        !in 1..100 -> println("x is not in 1..100")
        else -> println("i do not know")
    }
}


open class Person(val age: Int, val name: String) {
    override fun toString(): String {
        return "Person : age = $age, name = $name"
    }
}
