package _12_list

/**
 * Created by ssyijiu on 2017/6/9.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 */

fun main(args: Array<String>) {

    val list = listOf(1, 2, 3, 4, 5, 6)

    // contains，集合是否包含一个元素
    println(list.contains(2))  // true

    // elementAt，取出 index 为 n 的元素，内部是调用的 get(index)
    // 如果 index 越界，抛出 IndexOutOfBoundsException
    println(list.elementAt(1))  // 2


    // elementAtOrElse，和 elementAt 相同，数组越界返回默认值
    // 这里 it 就是 7
    println(list.elementAtOrElse(7, { 2 * it }))  // 14

    // elementAtOrNull，和 elementAt 相同，数组越界返回 null
    println(list.elementAtOrNull(10))  // null

    // first，返回符合条件的第一个元素
    println(list.first { it % 2 == 0 })   // 2

    // firstOrNull，返回符合条件的第一个函数，没有返回 null
    println(list.firstOrNull { it % 7 == 0 })  // null

    // indexOf，返回指定元素的第一个 index，不存在返回 -1
    println(list.indexOf(4))    // 3
    println(list.indexOf(7))    // -1

    // indexOfFirst，返回第一个符合条件元素的 index，不存返回 -1
    println(list.indexOfFirst { it % 2 == 0 })   // 1

    // indexOfLast，返回最后一个符合条件元素的 index，不存返回 -1
    println(list.indexOfLast { it % 2 == 0 })   // 5

    // last，返回最后一个符合条件的元素
    println(list.last { it % 2 == 0 })  // 6

    // lastIndexOf，返回指定元素的最后一个 index
    println(list.lastIndexOf(3))


}