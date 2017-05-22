## 基本类型

#### 数字类型

- Kotlin 的数字类型和 Java 一样
- Byte   8bit
- Short   16bit
- Int   32bit
- Long   64bit
- Float   32bit
- Double   64bit

#### 字面常量

- 十进制：123
  - Long：123L
- 十六进制：0x0F
- 二进制：0b00001001
- 没有八进制
- 浮点数默认 Double：123.78、123.3e10
- Float：123.6F


#### 表示方式

- 可空引用 Int? 和泛型 <Int> 会自动装箱

- 数字装箱不会保持同一性

  ```java
  // 使用 === 判断是不是一个对象，即同一性
  val a: Int = 10000
  print(a === a) // 输出“true”
  val boxedA: Int? = a
  val anotherBoxedA: Int? = a
  print(boxedA === anotherBoxedA) // ！！！输出“false”！！！
  ```

- 数字装箱会保持相等性

  ```java
  // 使用 == 判断是不是相等，相当于 Java 的 equals
  val a: Int = 10000
  print(a == a) // 输出“true”
  val boxedA: Int? = a
  val anotherBoxedA: Int? = a
  print(boxedA == anotherBoxedA) // 输出“true”
  ```
  

#### 显示转换

- 较小的类型不能隐式转换为较大的类型

  ```java
  // 假想的代码，实际上并不能编译：
  val a: Int? = 1  // 1. 一个装箱的 Int (java.lang.Integer)
  val b: Long? = a // 2. 一个装箱的 Int 转换为一个装箱的 Long（假设可以，实际并不可以）
  // 3. 这将打印 "false" 鉴于 Long 的 equals() 检测其他部分也是 Long
  //    所以 2 可以的话就会很奇怪
  print(a == b) 
  ```
  
- 
  
  ```aidl
  val b: Byte = 1 // OK, 字面值是静态检测的
  val i: Int = b  // 错误

  val l = 1L + 3  // Long + Int => Long
  ```
  
#### 字符

- ```aidl
  val c: Char = 1  // 错误，类型不兼容
  // 字符字面值用单引号括起来: '1'。 特殊字符可以用反斜杠转义。 
  // 支持这几个转义序列：\t、 \b、\n、\r、\'、\"、\\ 和 \$。 
  // 编码其他字符要用 Unicode 转义序列语法：'\uFF00'。
  ```
  
#### 布尔

- Boolean 只有两个值：true、false
- 布尔运算符   
  - || 短路或
  - && 短路与
  - ！ 逻辑非

  ​
#### 数组

- ```aidl
  class Array<T> private constructor() {
      val size: Int   
      operator fun get(index: Int): T
      operator fun set(index: Int, value: T): Unit
  
      operator fun iterator(): Iterator<T>
      // ……
  }
  ```
  
- 创建数组
 
  ```aidl
  val items = arrayOf(1,2,3)  // [1,2,3]
  val itemsNull = arrayOfNulls<String>(4)  // [null,null,null,null]
  // ["0", "1", "4", "9", "16"]
  val asc = Array(5, { i -> (i * i).toString() })
  ```
  
- 无装箱数组
  ```kotlin
  val x: IntArray = intArrayOf(1, 2, 3)
  x[0] = x[1] + x[2]
  ```
  
#### 字符串

- ```kotlin
  val str: String = "hello_world"
  
      println(str[1])   // e
  
      for (c in str) {
          print(c + "、")
      }
  ```
  
- 字符串字面值
  - 包含转义字符
    ```kotlin
    val s = "Hello, world!\n"
    ```
       
  - 原生字符串
  
    ```kotlin
    // 内部无转义，可以包含任何换行、任何字符
    val text = """
        for (c in "foo")
            print(c)
    """
    ```
    
  - 字符串模板 - $
  
    ```kotlin
    val i = 10
    val s = "i = $i" // 求值结果为 "i = 10"

    val s = "abc"
    val str = "$s.length is ${s.length}" 
    // 求值结果为 "abc.length is 3"


    // 在原生字符串中使用 $
    val price = """
    ${s}9.99
    """
    ```
  