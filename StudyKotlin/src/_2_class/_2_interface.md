#### 接口
- 使用 interface 声明接口
  ```kotlin
  interface MyInterface {
      fun bar()
      fun foo() {
        // 默认方法
      }
  }
  ```
  
- 实现接口
  ```kotlin
  class Child : MyInterface {
      override fun bar() {
          // 方法体
      }
  }
  ```
  
- 接口中的属性
  ```kotlin
  interface MyInterface {
      // 接口中的属性要么是抽象的、要么使用 get 赋值
      // 不能直接用 = 初始化
  
      val prop: Int // 抽象的
  
      // 使用 get 初始化
      val propertyWithImplementation: String
          get() = "foo"
  }
  ```
  
- 解决覆盖冲突，和 Class 样
  ```kotlin
  interface A {
      fun foo() { print("A") }
      fun bar()
  }
  
  interface B {
      fun foo() { print("B") }
      fun bar() { print("bar") }
  }
  
  class C : A {
      override fun bar() { print("bar") }
  }
  
  // A、B 中都有 foo() 和 bar()
  // D 不知道该用那一个，要覆盖重写
  class D : A, B {
      override fun foo() {
          super<A>.foo()
          super<B>.foo()
      }
  
      override fun bar() {
          super<B>.bar()
      }
  }
  ```