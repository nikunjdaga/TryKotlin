package _0_getting_start

/**
 * Created by ssyijiu on 2017/5/19.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 */

// 主函数
fun main(args: Array<String>) {

    _10()
}

// 14. 使用字符串
fun _14() {
    val str: String = "hello_world"

    println(str[1])

    for (c in str) {
        print(c + "、")
    }

    val s = "Hello, world!\n"

    val text = """


    for (c in "foo")
        print(c)\n """

    print(s)
    println(text.trim())


    val text2 = """
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """.trimMargin()    // 去除换行后 | 及前面的空格

    print(text2)

    val price = """
    ${s}9.99
    """

    println(price)
}

// 13. 使用数组

fun _13() {
    val items = arrayOf(1, 2, 3)

    // 也可以使用 set(index: Int, value: T)
    items[2] = 7

    // 遍历
    for (x in items) {
        println(x)
    }

    // items[2] 和 items.get(2) 取的值相同
    println(items[2] == items.get(2))

    // 创建一个 4 个元素都是 null 的数组
    val itemsNull = arrayOfNulls<String>(4)

    // 强大的迭代 ！！！
    itemsNull.forEach {
        println(it)
    }

    // 指定元素个数、根据下标创建数组
    val asc = Array(5, { i -> ((i + 1) * i).toString() })

    asc.forEach {
        println(it)
    }


}

// 12.使用集合
fun _12() {
    val items = listOf(1, 2, 3, 4, 5)

    // 想迭代区间那样迭代集合
    for (x in items) {
        print(x)
    }
    hi("")

    // 可以使用 in 判断一个元素是否在集合中
    hi((1 in items).toString())
    hi((7 in items).toString())
}

// 11.区间迭代
fun _11() {

    // for 里面的变量不用定义，厉害了
    for (x in 1..5) {
        hi(x.toString())
    }

    // step 2，一次走两步，从 1 直接到 3
    for (x in 1..10 step 2) {
        print(x)
    }

    hi("")

    // 9 downTo 1 ，递减区间的表示方法
    for (x in 9 downTo 1 step 3) {
        print(x)
    }

}


// 10.使用区间
fun _10() {

    // 1..10 表示 [1,10] 两边都是闭区间
    // 使用 in 表示是否在一个区间

    val x = 11
    val y = 9
    if (x in 1..y + 1) {
        hi("x is in 1..y+1")
    } else {
        hi("x is not in 1..y+1")
    }

    val list = listOf("a", "b", "c")

    // lastIndex 最后一个元素的下标，这里是 2
    hi("list.lastIndex = ${list.lastIndex}")

    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }

    // list.indices list 元素下表的区间，这里是 0..2
    hi("list.indices = ${list.indices}")

    for ((index, value) in list.withIndex()) {
        println("the element at $index is $value")
    }

    hi("list.size = ${list.size}")

    if (list.size !in list.indices) {
        println("list size is out of valid list indices range too")
    }


}

// 9.使用 when 表达式
fun whenTry(x: Int) {   // 相当于 Java 的 switch，更简洁
    when (x) {
        0 -> println("x is 0")
        in 1..10 -> println("x is in 1..10")
        in 10..20 -> println("x is in 1..20")
        !in 1..100 -> println("x is not in 1..100")
        else -> println("i do not know")
    }
}

// 8.使用 while 循环
fun _8() {
    val items = listOf("apple", "banana", "kiwi")
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index++]}")
    }
}


// 7.使用 for 循环
fun _7() {
    val items = listOf("java", "android", "kotlin")

    for (i in items) {
        hi(i)
    }

    hi("也可以这样")

    for (i in items.indices) {
        hi(items[i])
    }

}


// 6.使用类型检测及自动类型转换

// Any 相当于 Java 中的 Object
// is 相当于 instance，不属于: !is

fun getStringLen(obj: Any): Int? {
    if (obj is String) {
        // obj 在该条件分支内自动转换成 String
        return obj.length
    }

    // 在离开类型检测分支后，obj 仍然是 Any 类型
    return null
}

// 或者
fun getStringLen2(obj: Any): Int? = if (obj !is String) null else obj.length

// 甚至
fun getStringLen3(obj: Any): Int? {

    // 在 && 的左边 obj 自动转型为 String
    if (obj is String && obj.length > 0) {
        return obj.length
    }

    return null;
}

// 5.使用空值及 null 检查

fun parseInt(str: String): Int? {
    try {
        val x = str.toInt()
        return x
    } catch (e: Throwable) {
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

