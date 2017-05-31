package _4_other

/**
 * Created by ssyijiu on 2017/5/31.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */

fun main(args: Array<String>) {

    val numbers:MutableList<Int> = mutableListOf(1,2,3)
    val onlyRead:List<Int> = numbers  // 直接使用 = 赋值的集合只能读
    println(numbers)
    numbers.add(4)

    println(onlyRead)

    // onlyRead.add(4)

    // Set 会去除重复，里面只有 a b c 三个元素
    val strings = hashSetOf("a", "b", "c", "c")
    strings.add("d")
    println(strings.size)


    // listOf 的集合只能读
    val lists = listOf("11","22","33")

    // setOf 的集合只能读
    val sets = setOf(1,2,3,4,4)


    // 集合的其他方法
    val items = listOf(1, 2, 3, 4)
    println(items.first())
    println(items.last())

    println(items.filter { it % 2 == 0 } )

    val rwList = mutableListOf(1, 2, 3)

    println(rwList.requireNoNulls() )       // 返回 [1, 2, 3]

    if (rwList.none { it > 6 }) println("No items above 6")  // 输出“No items above 6”

    val item = rwList.firstOrNull()
    println(item)

    // Map 的其他方法
    val readWriteMap = hashMapOf("foo" to 1, "bar" to 2)
    println(readWriteMap["foo"])  // 输出“1”

    val snapshot: Map<String, Int> = HashMap(readWriteMap)
    println(snapshot)   // {bar=2, foo=1}


}