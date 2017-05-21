## 基本类型

### 数字类型

- Kotlin 的数字类型和 Java 一样
- Byte   8bit
- Short   16bit
- Int   32bit
- Long   64bit
- Float   32bit
- Double   64bit

### 字面常量

- 十进制：123
  - Long：123L
- 十六进制：0x0F
- 二进制：0b00001001
- 没有八进制
- 浮点数默认 Double：123.78、123.3e10
- Float：123，6F



### 表示方式

- 可空引用 Int? 和泛型 <Int> 会自动装箱

- 数字装箱不会保持同一性

  ```java
  // 使用 === 判断是不是一个对象，即统一性
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

  ​