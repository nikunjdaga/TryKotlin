package _12_list

/**
 * Created by ssyijiu on 2017/6/9.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 */

fun main(args: Array<String>) {

    val list = listOf(1, 2, 3, 4, 5, 6)

    // dorp，去掉前 n 个元素
    println(list.drop(4))  // [5, 6]

    // dropWhile，从第一个元素开始，去掉截止到第一个不符合条件的元素
    println(list.dropWhile { it < 4 })       // [4, 5, 6]

    // dropLastWhile，和 dropWhile 一样，不过是从最后一个元素开始
    println(list.dropLastWhile { it > 4 })   // [1, 2, 3, 4]

    // filter，保留所有符合条件的元素，去掉其他元素
    println(list.filter { it % 2 == 0 })    // [2, 4, 6]

    // filterNot，去掉所有符合条件的元素
    println(list.filterNot { it % 2 == 0 })  // [1, 3, 5]

    // filterNotNull, 去掉所有 null
    val listWithNull = listOf(1, null, 3, null, 5, 6)
    println(listWithNull.filterNotNull())    // [1, 3, 5, 6]

    // slice，保留 index 区间内的元素
    // 保留 [1,2,3] index
    println(list.slice(1..3))            // [2, 3, 4]
    // list 也是一个区间，保留 [1,2,4] index
    println(list.slice(listOf(1, 3, 4))) // [2, 4, 5]

    // take，保留从第一个元素开始的 n 个元素
    println(list.take(2))                // [1, 2]

    // takeLast，保留从最后一个开始的 n 个元素
    println(list.takeLast(2))            // [5, 6]

    // takeWhile，从第一个元素开始，保留截止到第一个不符合条件的元素
    println(list.takeWhile { it < 3 })   // [1, 2]

    // 当然，还有 takeLastWhile , take 和 drop 刚好相反，一个保留一个去掉
}
