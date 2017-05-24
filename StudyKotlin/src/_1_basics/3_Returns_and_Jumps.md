#### 返回和跳转
- return
- break
- continue

#### Break 和 Continue 标签

- ```kotlin
  // 通过 @ 创建标签，break 会跳出标签标记的循环
  loop@ for (i in 1..100) {
      for (j in 1..100) {
          if (……) break@loop
      }
  }
  ```
  
#### 标签处返回

- ```kotlin
  fun foo_1() {
      val ints = listOf(1, 2, 3)
      ints.forEach {
          if (it == 1) {
              print(it)
              return  // 从 foo_1 函数返回
          }
  
      }
      println("foo")  // 不会打印
  }


  fun foo_2() {
      val ints = listOf(1, 2, 3)
      ints.forEach lit@ {  // 从 lit@ 处返回
          if (it == 1) {
              println(it)
              return@lit
          }
      }
      println("foo")  // 会打印
  }

  // foo_2 的简化形式
  fun foo_3() {
      val ints = listOf(1, 2, 3)
      ints.forEach {
          if (it == 1) {
              println(it)
              return@forEach
          }
      }
      println("foo")
  }
  ```