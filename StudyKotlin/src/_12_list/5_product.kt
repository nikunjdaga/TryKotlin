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
    println(pair.first)      // [2, 4, 6]
    println(pair.second)     // [1, 3, 5]


    // plus，可以用 + 代替，合并两个集合
    println(list.plus(listOf(7, 8)))   // [1, 2, 3, 4, 5, 6, 7, 8]
    println(list + listOf(7, 8, 9))    // [1, 2, 3, 4, 5, 6, 7, 8, 9]

    // zip，返回由 pair组成的 List，每个 pair由两个集合中相同 index的元素组成。
    // 这个返回的List的大小由最小的那个集合决定。
    println(list.zip(listOf(7, 8)))    // [(1, 7), (2, 8)]


    // unzip，将一个 List<Pair> 转为 Pair(List,List)
    // Pair 的 first 是 List<Pair> 中每个 Pair 的 first 组成的 List
    // Pair 的 second 是 List<Pair> 中每个 Pair 的 second 组成的 List
    val listPair = listOf(Pair(5, 7), Pair(6, 8))   // [(5, 7), (6, 8)]
    println(listPair.unzip())    // ([5, 6], [7, 8])
}