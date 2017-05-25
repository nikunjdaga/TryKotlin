package _2_class_and_objects

/**
 * Created by ssyijiu on 2017/5/24.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */

fun main(args: Array<String>) {

    // 4. values 获取所有的枚举元素，和 Java 一样
    val color = Color.values()
    color.forEach {
        println(it)
    }

    // 5. 通过枚举名称获取枚举元素 throw IllegalArgumentException
    val state = ProtocolState.valueOf("TALKING")
    println(state)


    printAllValues<RGB>() // 输出 RED, GREEN, BLUE

}


// 1. 最简单的枚举类
enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

// 2. 初始化枚举类
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}


// 3. 匿名类
enum class ProtocolState {

    // 枚举元素必须实现抽象方法
    WAITING {
        override fun signal() = TALKING
    },

    TALKING {
        override fun signal() = WAITING
    };


    // 抽象方法
    abstract fun signal(): ProtocolState
}

// 6. 每个枚举常量都具有在枚举类声明中获取其名称和位置的属性
// val name: String
// val ordinal: Int


// 7. 枚举常量还实现了 Comparable 接口， 其中自然顺序是它们在枚举类中定义的顺序。



// 8 .
enum class RGB { RED, GREEN, BLUE }

inline fun <reified T : Enum<T>> printAllValues() {
    print(enumValues<T>().joinToString { it.name })
}



