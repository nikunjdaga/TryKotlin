#### 可见性修饰符
- 类、对象、接口、构造方法、方法、属性、setter 都有可见性修饰符，
  getter 的可见性和属性一样
  
- 可见性修饰符有四种，private、protected、internal、public
  默认 public
  
  
#### 包名
- 函数、属性、类、对象、接口可以直接在包内声明
  ```kotlin
  // 文件名：example.kt
  package foo
  
  fun baz() {}
  class Bar {}

  private fun foo() {}    // 在 example.kt 内可见

  public var bar: Int = 5 // 该属性随处可见
      private set         // setter 只在 example.kt 内可见
    
  internal val baz = 6    // 相同模块内可见
  
  // protected 不适用于顶层声明
  ```
  
#### 类和接口

- 类内部成员
  ```kotlin
  // private 类本身
  // protected  类本身 + 子类
  // internal  模块内
  // public  任何地方

  open class Outer {
      private val a = 1
      protected open val b = 2
      internal val c = 3
      val d = 4  // 默认 public
      
      protected class Nested {
          public val e: Int = 5
      }
  }
  
  class Subclass : Outer() {
      // a 不可见
      // b、c、d 可见
      // Nested 和 e 可见
  
      // 覆盖 protected 人仍为 protected
      override val b = 5   //  b 为 protected
      
  }
  
  class Unrelated(o: Outer) {
      // o.a、o.b 不可见
      // o.c 和 o.d 可见（相同模块）
      // Outer.Nested 不可见，Nested::e 也不可见
  }
  ```
  
#### 构造函数

- 指定主构造的可见性
  ```kotlin
  // 使用可见修饰符必须在后面加 constructor
  class C private constructor(a: Int) { …… }
  ```
  
#### 模块 
- 一个 IntelliJ IDEA 模块；
- 一个 Maven 或者 Gradle 项目；
- 一次 ＜kotlinc＞ Ant 任务执行所编译的一套文件。