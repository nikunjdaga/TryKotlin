package _2_class_and_objects

/**
 * Created by ssyijiu on 2017/5/24.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */




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

