package _4_other

/**
 * Created by ssyijiu on 2017/6/1.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */

fun main(args: Array<String>) {

    var a: String = "abc"
    // a = null // 编译错误

    var b: String? = "abc"
    b = null // ok

    // a 声明的时候非 null
    val l = a.length  // 永远不会空指针

    // val len = b.length  // 编译错误 ，b 可能为 null，不能直接访问它的属性和方法

    // 自己显式检查
    val len = if (b != null) b.length else -1


    // 安全的调用，使用 ?. 这个操作符
    val len2:Int? = b?.length  // b 非 null 返回 b.length ，null 返回 null

    // 非空操作符 ?.let
    val listWithNulls: List<String?> = listOf("A", null)
    for (item in listWithNulls) {
        item?.let { println(it) } // 输出 A 并忽略 null
    }

    // ?:  当且仅当左侧为空的时候对右侧求职
    val len3:Int? = b?.length ?: -1  // b 非 null 返回 b.length ，null 返回 -1

    // !! 断言不是 null，如果 b 是 null，直接空指针
    val len4 = b!!.length

    // 可空的集合
    val nullableList: List<Int?> = listOf(1, 2, null, 4)
    val intList: List<Int> = nullableList.filterNotNull()  // 过滤 null


}


// throw 和 return 都是表达式
// 这个写法 666
fun foo(node: Node): String? {
    val parent = node.getParent(9) ?: return null
    val name = node.getName("xxx") ?: throw IllegalArgumentException("name expected")

    return ""
}

class Node {
    fun getParent(i:Int)  = if(i == 0) null else i
    fun getName(name:String?) = if(name.equals("xxx")) 1 else null
}

// 在 Kotlin 中 NullPointerException 的原因
// 1. throw NullPointerException()
// 2. !! (断言一个变量非 null，null 的话直接抛出空指针)
// 3. Java 代码导致
// 4. 对于初始化，有一些数据不一致（如一个未初始化的 this 用于构造函数的某个地方）