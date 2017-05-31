package _4_other

/**
 * Created by ssyijiu on 2017/5/31.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */


fun main(args: Array<String>) {

}

// 1. 在类的成员中，this 指该类的当前对象
// 2. 在扩展函数或者带接受者的函数字面值中，this 表示点左侧传递的 接收者 参数。

// 限定 this
class A { // 隐式标签 @A
    inner class B { // 隐式标签 @B
        fun Int.foo() { // 隐式标签 @foo
            val a = this@A // A 的 this
            val b = this@B // B 的 this

            val c = this // foo() 的接收者，一个 Int 例如：5.foo this 指 5
            val c1 = this@foo // foo() 的接收者，一个 Int



            //--------看不懂-----------
            val funLit = lambda@ fun String.() {
                val d = this // funLit 的接收者
            }


            val funLit2 = { s: String ->
                // foo() 的接收者，因为它包含的 lambda 表达式
                // 没有任何接收者
                val d1 = this
            }
        }
    }
}