#### 扩展
- Kotlin 能够扩展一个类的新功能而无需继承该类或使用像装饰者这样的任何类型的设计模式
- Kotlin 支持_扩展函数_ 和 扩展属性。

#### 扩展函数
- ````kotlin
  fun main(args: Array<String>) {
      val ex = Ex(77)
      ex.printX()   // 77
      ex.setX(100)  // 调用扩展函数
      ex.printX()   // 100
  }
  
  
  // 声明一个类
  class Ex(var x: Int) {
      fun printX() = println(x)
  }
  
  // 给他扩展一个函数
  fun Ex.setX(x: Int) {
      this.x = x
  }
  ````
  
#### 扩展是静态解析的

- 扩展不能真正的修改他们所扩展的类。通过定义一个扩展，你并没有在一个类中插入新成员， 仅仅是可以通过该类型的变量用点表达式去调用这个新函数。

- 调用的扩展函数是由函数调用所在的表达式的类型来决定的， 而不是由表达式运行时求值结果决定的
  ```kotlin
  open class C
  
  class D: C()
  
  fun C.foo() = "c"
  
  fun D.foo() = "d"
  
  fun printFoo(c: C) {
      println(c.foo())
  }
  
  printFoo(D())  // 输出 c


  // 如果是重写，则根据运行时结果决定
  open class C {
      open fun foo() = "c"
  }
  
  class D: C() {
      override fun foo(): String {
          return "d"
      }
  }
  
  fun printFoo(c: C) {
      println(c.foo())
  }
  printFoo(D())  // 输出 d
  ```
 
 - 成员函数与扩展函数重复、优先调用成员函数
 
 #### 可空接收者
 
 - ```kotlin
   fun Any?.toString(): String {
       if (this == null) return "null"
       // 空检测之后，“this”会自动转换为非空类型，所以下面的 toString()
       // 解析为 Any 类的成员函数
       return toString()
   }
   ```
   
#### 扩展属性

- ```kotlin
  // 扩展属性不能有 初始化器
  // 他们的行为只能由显式提供的 getters/setters 定义
  val <T> List<T>.lastIndex: Int
      get() = size - 1
  ```
#### 伴生对象的扩展

#### 动机
- 代替工具类的使用
  ```kotlin
  // Java
  Collections.swap(list, Collections.binarySearch(list, Collections.max(otherList)), Collections.max(list))
  
  // Kotlin 我们不希望在 List 类内实现这些所有可能的方法，对吧？这时候扩展将会帮助我们
  list.swap(list.binarySearch(otherList.max()), list.max())
  ```