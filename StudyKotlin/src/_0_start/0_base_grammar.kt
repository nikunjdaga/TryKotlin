package _0_start

/**
 * Created by ssyijiu on 2017/5/19.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 */

// 主函数
fun main(args: Array<String>) {

    hi(maxOf(2, 9).toString())
    hi(getStringLen("xxx").toString())
    hi(getStringLen2("xxx").toString())

}


// 7.使用 for 循环

// 6.使用类型检测及自动类型转换

// Any 相当于 Java 中的 Object
// is 相当于 instance，不属于是 !is

fun getStringLen(obj: Any): Int? {
    if (obj is String) {
        // obj 在该条件分支内自动转换成 String
        return obj.length
    }

    // 在离开类型检测分支后，obj 仍然是 Any 类型
    return null
}

// 或者
fun getStringLen2(obj: Any) :Int? = if(obj !is String) null else obj.length

// 甚至
fun getStringLen3(obj: Any) :Int? {

    // 在 && 的左边 obj 自动转型为 String
    if(obj is String && obj.length > 0) {
        return obj.length
    }

    return null;
}

// 5.使用空值及 null 检查

fun parseInt(str: String): Int? {
    try {
        val x = str.toInt()
        return x
    } catch (e: NumberFormatException) {
        return null  // 想返回 null 必须使在返回值后面用 ? 标记
    }
}

fun checknull() {
    val x = parseInt("xx")
    val y = parseInt("77")

    // 直接使用 x、y 会报错，因为他们可能为 null
    if (x != null && y != null) {
        // 在空检测后，x 和 y 会自动转换为非空值（non-nullable）
        val sum = x + y;
        hi(sum.toString())
    }


    // 或者
    if (x == null) {
        return
    }
    if (y == null) {
        return
    }

    // 在空检测后，x 和 y 会自动转换为非空值
    val sum = x + y
    hi(sum.toString())

}

// 4.使用条件表达式
fun max(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

fun maxOf(a: Int, b: Int) = if (a > b) a else b  // 这样写 666


// 3.使用字符串模板
fun _3() {
    var a = 1
    val s1 = "a is $a"  // 使用 $ 可以直接取出字符串的值

    a = 2
    val s2 = "${s1.replace("is", "was")},but now is $a"
    hi(s2)
}

// 2.定义局部变量
fun _2() {
    // val 常量，只能赋值一次，相当于 final
    val a: Int = 1
    val b = 5       // b 的类型自动推断出
    val c: Int      // 定义时候不赋值必须明确类型


    // var 变量，可以赋值多次
    var x = 5
    x += 1
}


// 1.定义函数

// 参数：int int 返回值：int
fun sum(a: Int, b: Int): Int {
    return a + b
}

// 参数：String 无返回值
fun hi(str: String) {
    println(str)
}

// 参数 int int 返回值 int (由 a-b 自动推断出)
fun less(a: Int, b: Int) = a - b

