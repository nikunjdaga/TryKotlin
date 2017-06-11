package _12_list

/**
 * Created by ssyijiu on 2017/6/11.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */

fun main(args: Array<String>) {

    val list = listOf(1, 2, 3, 4, 5, 6)
    val listRepeated = listOf(2, 2, 3, 4, 5, 5, 6)
    // merge 没找到这个操作符


    // partition，根据一个函数将集合分成两个，返回一个 Pair
    // Pair first 是函数返回 true 的元素组成的集合
    // Pair second 是函数返回 false 的元素组成的集合
    val pair = list.partition { it % 2 == 0 }
    println(pair)
    println(pair.first)
    println(pair.second)
}