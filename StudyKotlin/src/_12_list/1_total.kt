package _12_list

/**
 * Created by ssyijiu on 2017/6/8.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */

fun main(args: Array<String>) {
    val list = listOf(1, 2, 3, 4, 5, 6)

    // any 集合中只要有一个元素符合条件返回 true，都不符合返回 false
    println(list.any { it % 2 == 0 })   // true
    println(list.any { it > 10 })       // false


    // all，集合中所有的元素都符合条件返回 true，否则返回 false
    println(list.all { it % 2 == 0 })  // false
    println(list.all { it < 10 })      // true

    // count，计算集合中符合条件的元素个数
    println(list.count { it % 2 == 0 })  // 3

    // fold，给定初始值，按照公式计算集合中每个元素的计算一遍
    // total 初始值 4，4 + 1 + 2 + 3 + 4 + 5 + 6 = 25
    println(list.fold(4) { init, next -> init + next })


    // foldRight，与fold一样，但是顺序是从最后一项到第一项
    // 2 * 6 * 5 * 4 * 3 * 2 * 1 = 1440
    println(list.foldRight(2) { init, next -> init * next })

    // forEach，遍历所有的元素，并给出指定操作
    list.forEach {
        print("$it 、")  // 1 、2 、3 、4 、5 、6 、
    }
    println()

    // max，返回最大的一项
    println(list.max())  // 6

    // maxBy，根据给定的函数返回最大的一项
    println(list.maxBy { -it })   // 1, 最大的一项是 -1

    // min，返回最小的一项
    println(list.min())  // 1

    // minBy，根据给定的函数返回最小的一项
    println(list.minBy { -it })   // 6, 最小的一项是 -6

    // none，没有任何元素符合条件返回 true，否则返回 false
    println(list.none { it % 7 == 0 })  // true

    // reduce，与 fold 一样，初始值为永远为 0
    println(list.reduce { init, next -> init + next })  // 21

    // reduceRight，与 foldRight 一样，初始值为永远为 0
    println(list.reduceRight { init, next -> init * next })  // 720

    // sumBy，每个元素经过函数计算后，累加求和
    println(list.sumBy { it % 2 })  // 3

}