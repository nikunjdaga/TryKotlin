#### 类
- 使用 class 声明类
  ```kotlin
  class Invoice {
  }
  ```


- 一个类没有类体，可以省略 {}
  ```kotlin
  class Empty
  ```
  
  
#### 构造函数

- 主构造函数
  ```kotlin
  class Person constructor(firstName: String) {
  }
  // 没有任何注解或者可见性修饰符，可以省略这个 constructor 关键字。
  ```
  
- 主构造函数不能包含任何代码，初始化放在 init 
  ```kotlin
  class Customer(name: String) {
      init {
          logger.info("Customer initialized with value ${name}")
      }
  }
  ```
  
- 主构造函数的参数可用用来初始化类的属性
  ```kotlin
  class Customer(name: String) {
      val customerKey = name.toUpperCase()
  }

  // 更简单的做法
  // 在主构造函数声明参数的时候，加上 val 或者 var，主构造的参数会变成类的属性
  class Person(val firstName: String, val lastName: String, var age: Int) {
      // ……
  }
  ```
  
-  构造函数使用注解或者可见性修饰符修饰
  ```kotlin
  // 注解、可见性修饰符后面必须跟 constructor
  class Dog public constructor(name: String) {
      init {
          println("Dog's name is $name")
      }
  
      val name = name
  }
  ```
  
- 次构造函数
  ```kotlin
  // 次构造函数必须调用主构造函数，
  // 可以直接调用，也可以通过的别的次构造函数调用
  // 次构造函数的参数不能通过 val、var 声明成为类的属性
  class Dog(val name: String) {
      constructor(age: Int) : this("Tom") { // 调用主构造函数
          println("Dog's age is $age")
          this.age = age
      }
  
      var age = 0
  }
  ```
  
- 非抽象类没有任何构造函数，默认生成 public 空参的主构造函数
  ```kotlin
  // 不希望有一个公有构造函数，需要声明一个带有非默认可见性的空的主构造函数
  class DontCreateMe private constructor () {
  }
  ```
  
- 创建类的实例
  ```kotlin
  // Kotlin 没有 new
  val invoice = Invoice()
  val customer = Customer("Joe Smith")
  ```
  
#### 继承
- Kotlin 中所有的类都默认继承 Any
- Kotlin 的类默认 final，一个类要想被其他类继承，必须声明 open
  ```kotlin
  open class Base(p: Int)

  // 如果有主构造函数，基类必须使用主构造函数就地初始化
  class Derived(p: Int) : Base(p)

  // 如果没有构造函数，每个次构造函数必须 使用 super 关键字初始化其基类型
  // 或委托给另一个构造函数做到这一点
  class MyView : View {
      constructor(ctx: Context) : super(ctx)
  
      constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)
  }
  ```
  
- 覆盖方法
  ```kotlin
  // 1.基类是 open 的
  // 2.方法是 open 的
  // 3.子类强制 override 标记
  // 4. override 的方法可以被子类覆盖，不想被覆盖用 final 标记
  open class Base {
      open fun v() {}
      fun nv() {}
  }
  class Derived() : Base() {
      final override fun v() {}
  }
  ```
  
- 覆盖属性，规则和覆盖方法相同
  注意类型兼容，var 属性可以覆盖 val 属性
  
- 覆盖规则
  ```kotlin
  open class A {
      open fun f() { print("A") }
      fun a() { print("a") }
  }
  
  interface B {
      fun f() { print("B") } // 接口成员默认就是“open”的
      fun b() { print("b") }
  }
  
  class C() : A(), B {
      // f() 有歧义，必须手动覆盖
      override fun f() {
          super<A>.f() // 调用 A.f()
          super<B>.f() // 调用 B.f()
      }
  }
  ```
  
- 抽象类
  ```kotlin
  // 使用 abstract 标记类和方法
  // abstract 肯定要被继承，所以默认 open 
  abstract class Abs {
      abstract fun f()
  }
  ```
 