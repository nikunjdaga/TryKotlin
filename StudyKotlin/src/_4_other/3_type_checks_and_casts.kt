package _4_other

/**
 * Created by ssyijiu on 2017/5/31.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */

fun main(args: Array<String>) {
    // is 和 !is
    val str = "1235"
    if(str is String) {
        println("str is String, length = ${str.length}")
    }


    val y = ""

    // 不安全的强转 as
    val x: String = y as String
    // y 为 null 抛出异常


    // 安全的强转 as?
    val xx: String? = y as? String
    // y 为 null 时 xx 为 null


}

// 智能转换
fun demo(x: Any) {
    if (x is String) {
        print(x.length) // x 自动转换为字符串
    }

    // 甚至可以这样
    if (x !is String) return
    print(x.length) // x 自动转换为字符串

    // 居然可以这样

    // `||` 右侧的 x 自动转换为字符串
    if (x !is String || x.length == 0) return
    // x !is String || 右边一定是 x is String


    // `&&` 右侧的 x 自动转换为字符串
    if (x is String && x.length > 0) {
        print(x.length) // x 自动转换为字符串
    }


    // 还可以用在 when 里面
    when (x) {
        is Int -> print(x + 1)
        is String -> print(x.length + 1)
        is IntArray -> print(x.sum())
    }
}