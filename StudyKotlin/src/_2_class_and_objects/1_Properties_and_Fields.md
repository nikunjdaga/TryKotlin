#### 声明属性   

- 使用 var 声明的属性可变
- 使用 val 声明的属性只能读（final）
- 使用属性 KotlinClass.xxx = xxx

#### Getters 和 Setters

- 声明一个属性的完整语法
  ```kotlin
  var <propertyName>[: <PropertyType>] [= <property_initializer>]
      [<getter>]
      [<setter>]
    
  // 一个完整的定义
  class K {
      var size = 0
      var isEmpty: Boolean
          get() = this.size == 0
          private set(value) {
              this.size = if(value) 0 else 100
          }
  
  }
  // 1. 为 k.isEmpty 赋值会执行 set(value) 方法
  // 2. 读取 k.isEmpty 会执行 get 方法
  // 3. get/set 不声明的时候是默认什么也不做
  // 4. get 和 isEmpty 的初始化冲突，只能有一个，必须有一个
  // 5. val 不允许 set
  // 6. 类型如果可以从初始化或者 get 推断出来可以省略
  // 7. set 前面可以用 修饰限定符或者注解修饰
  ```
  
#### 幕后字段
#### 幕后属性
#### 编译期常量
```kotlin
// 位于顶层或者是 object 的一个成员 ?
// 用 String 或原生类型 值初始化
// 没有自定义 getter
const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"
```
#### 惰性初始化属性

- ```kotlin
  // 不声明 lateinit 的话，必须为 recyclerView 附一个初始值
  // 这很不方便
  lateinit var mRecycler: RecyclerView
  ```
#### 委托属性
