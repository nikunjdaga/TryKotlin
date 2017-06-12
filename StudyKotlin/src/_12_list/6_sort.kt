package _12_list

/**
 * Created by ssyijiu on 2017/6/12.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 */

fun main(args: Array<String>) {

    val list = listOf(3, 2, 7, 5)

    // reversed，反转
    println(list.reversed())  // [5, 7, 2, 3]

    // sorted，排序（升序）
    println(list.sorted())    // [2, 3, 5, 7]

    // sortedBy 根据函数结果排序（升序）
    println(list.sortedBy { it % 3 })  // [3, 7, 2, 5]

    // sortedDescending，排序（降序）
    println(list.sortedDescending())   // [7, 5, 3, 2]

    // sortedBy 根据函数结果排序（降序）
    println(list.sortedByDescending { it % 3 })  // [2, 5, 7, 3]
}