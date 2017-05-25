

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




