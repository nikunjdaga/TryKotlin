package _11_others

/**
 * Created by ssyijiu on 2017/5/28.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */


// https://mp.weixin.qq.com/s?__biz=MzIzMTYzOTYzNA==&mid=2247483899&idx=2&sn=76f84bf0ca00ab11f5c7d75d72cee731&chksm=e8a05ec6dfd7d7d0691826a470e6d0f5de517e485d02082868d037b0fe6306683885e535b87a#rd

fun main(args: Array<String>) {

    println(KotlinStatic.xxx)

    // 定义数组

    // intArrayOf 避免装箱
    // Int、Short、Byte、Long、Float、Double、Char 都有类似方法
    val array = intArrayOf(1,2,3,4,5)
    array.forEach {  // 集合和数组都可以这样
        print("$it 、")
    }
    println()

    val arrayNull = arrayOfNulls<String>(10)
    arrayNull.forEach {
        print("$it 、")
    }
    println()


    // 获取 class 实例
    println(Hello::class.java)
    println(Hello().javaClass)

}

// static 变量声明
class KotlinStatic {
    companion object {
        val xxx = "123xxx"
    }
}

class Hello {

}
