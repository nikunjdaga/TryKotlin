

#### 函数用法

- 函数声明
  ```kotlin
  // fun 关键字
  // x:Int 参数及类型
  // :Int 返回值
  fun double(x: Int): Int {
      return 0
  }
  ```


- 函数用法
  ```kotlin
  val result = double(2)
  Sample().foo() // 创建类 Sample 实例并调用 foo
  ```



- 中缀表示
  ```kotlin
  // 前提：成员函数或扩展函数、一个参数、infix
  // 给 Int 定义扩展
  infix fun Int.shl(x: Int): Int {
  }

  // 用中缀表示法调用扩展函数
  1 shl 2
  
  // 等同于这样
  1.shl(2)
  ```
  
- 默认参数

  ```kotlin
  // x 默认 1
  // y 默认 ""
  // z 默认 4
  fun default(x:Int = 1 ,y:String = "",z :Int = 4) {
      println("x = $x")
      println("y = $y")
      println("z = $z")
  }

  // 调用
  default()   // 全部使用默认值
  default(1,"xxx")  // 给 y 赋值，y 前面的参数必须赋值

  // 覆盖方法，不能修改默认值
  open class A {
      open fun foo(i: Int = 10) { }
  }
  
  class B : A() {
      override fun foo(i: Int) {}  // 不能修改默认值
  }
  ```
  
- 命名参数

  ```kotlin
  // 默认参数时候
  default(1,"xxx")  // 给 y 赋值，y 前面的参数必须赋值
  
  // 现在我们可以用命名参数解决这个问题
  // 非常牛逼的功能，配合默认参数，完全不要 Builder 模式了
  default(1, z = 3) // 跳过 y 直接给 z 赋值
  ```
  
-  返回 Unit 的函数
  ```kotlin
  // 如果一个函数不返回任何有用的值，它的返回类型是 Unit。Unit 是一种只有一个值——Unit 的类型。这个 值不需要显式返回
  fun printHello(name: String?): Unit {
      if (name != null)
          println("Hello ${name}")
      else
          println("Hi there!")
      // `return Unit` 或者 `return` 是可选的
  }

  // 以上代码可以简化为
  fun printHello(name: String?) {
  }
  ```
  
- 单表达式函数
  ```kotlin
  // 当函数返回单个表达式时，可以省略花括号并且在 = 符号之后指定代码体即可
  fun double(x: Int): Int = x * 2

  // 当返回值类型可由编译器推断时，显式声明返回类型是可选的
  fun double(x: Int) = x * 2
  ```
  
- 可变参数
  ```kotlin
  // 通常在最后一个参数用 vararg 表示
  // 只有一个参数可以标注为 vararg。如果 vararg 参数不是列表中的最后一个参数， 可以使用 命名参数语法传递其后的参数的值
  
  fun <T> asList(vararg ts: T): List<T> {
      val result = ArrayList<T>()
      for (t in ts) // ts is an Array
          result.add(t)
      return result
  }

  // 调用
  val list = asList(1, 2, 3)

  // 在给可变参数直接传递数组时，需要用 * 展开
  val a = arrayOf(1, 2, 3)
  val list = asList(-1, 0, *a, 4)
  ```
  
- 局部函数

  ```kotlin
  kotlin 支持在函数定义函数，局部函数可以直接访问外部函数的变量
  ```

- 泛型函数
  ```kotlin
  // 函数可以有泛型参数，通过在函数名前使用尖括号指定。
  fun <T> singletonList(item: T): List<T> {
      // ……
  }
  ```
  
- 尾递归函数

  ```kotlin
  // 使用 tailrec 标记函数
  // 函数必须将其自身调用作为它执行的最后一个操作。
  // 在递归调用后有更多代码时，不能使用尾递归，并且不能用在 try/catch/finally 块中
  
  tailrec fun findFixPoint(x: Double = 1.0): Double
          = if (x == Math.cos(x)) x else findFixPoint(Math.cos(x))
        
  // 传统写法
  private fun findFixPoint(): Double {
      var x = 1.0
      while (true) {
          val y = Math.cos(x)
          if (x == y) return y
          x = y
      }
  }
  ```




