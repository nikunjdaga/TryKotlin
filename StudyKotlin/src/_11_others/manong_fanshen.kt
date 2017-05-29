package _11_others

/**
 * Created by ssyijiu on 2017/5/29.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */

// https://mp.weixin.qq.com/s?__biz=MzAxOTc0NzExNg==&mid=2665513670&idx=1&sn=5972f3563cb9e4b574ad946c97dd6d54&chksm=80d67a85b7a1f39317259196e2203e6f6ab4eb5ac25e17eb304b67dc06cde18cb4e53339d3ca&mpshare=1&scene=1&srcid=0519e1ZkErOmr9eS1BPxfW5g#rd

fun main(args: Array<String>) {

    // 兼容 Java
    java.lang.System.out.println("hello world")

    // set
    val set = setOf("a","b","c")
    for (it in set) {
        print("$it 、")
    }
    println()

    val sortSet = sortedSetOf("b","b","c","a")
    for (it in sortSet) {
        print("$it 、")  // a 、b 、c 、 (有序、set 不能重复)
    }
    println()
}