package _12_list

/**
 * Created by ssyijiu on 2017/6/9.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 */

fun main(args: Array<String>) {

    val list = listOf(1, 2, 3, 4, 5, 6)

    // flatMap，遍历所有元素，为每一个元素创建一个集合，合并集合
    println(list.flatMap { listOf(it, it + 1) })  // [1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7]

    // groupBy，根据函数给 list 分组，最后保存到 map 中
    val map = list.groupBy { if (it % 2 == 0) "even" else "odd" }
    println(map)         // {odd=[1, 3, 5], even=[2, 4, 6]}
    println(map["even"]) // [2, 4, 6]
    println(map["odd"])  // [1, 3, 5]

    // map，将集合中每个元素进行变换组成新的集合
    println(list.map { it * 2 })  // [2, 4, 6, 8, 10, 12]

    // mapIndexed，比 map 多了一个 index 参数，可以使用 index 参与变换
    println(list.mapIndexed { index, it -> index * it })   // [0, 2, 6, 12, 20, 30]

}
