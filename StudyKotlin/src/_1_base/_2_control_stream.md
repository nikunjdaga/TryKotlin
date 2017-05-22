#### if 

- if 作为流程控制语句
  ```kotlin
  // 用法和 Java 一样
  if(a > b) {
    println("a > b")
  }
  ```
  
- if 和 else 一起使用可以作为一个表达式，返回某个值
  ```kotlin
  // Kotlin 中没有三元表达式
  val max = if (a > b) a else b

  // 甚至可以这样，既控制流程，又作为表达式
  val max = if (a > b) {
      print("Choose a") 
      a
  } else {
      print("Choose b")
      b
  }
  ```
  
- When 取代了 switch
  ```kotlin
  // 一般用法
  when (x) {
      1 -> print("x == 1")
      2 -> print("x == 2")
      else -> { // 注意这个块
          print("x is neither 1 nor 2")
      }
  }

  // 作为表达式，必须有 else
  val x = when (i) {
                1 -> {
                     print("x == 1")
                     1
                   }
                2 -> {
                     print("x == 2")
                     2
                   }
                else -> { 
                    print("x is neither 1 nor 2")
                    3
                }
              }
            
  // 多个分支合并，使用 ，
  when (x) {
      0, 1 -> print("x == 0 or x == 1")
      else -> print("otherwise")
  }


  // 分支条件可以是任意表达式
  when (x) {
      parseInt(s) -> print("s encodes x")
      else -> print("s does not encode x")
  }

  // 分支条件可以检测是否在一个区间内
  when (x) {
      in 1..10 -> print("x is in the range")
      in validNumbers -> print("x is valid")
      !in 10..20 -> print("x is outside the range")
      else -> print("none of the above")
  }

  // 分支条件可以使用 is 检测是不是一个类型
  when(x) {
      is String -> println("x is String")
      else -> println("x is not String")
  }


  // when 没有参数，所有分支条件都是 布尔表达式
  // 一个分支为真时，执行该分支，然后跳出 when
  // 可以用来代替 if-else-if
  when { 
      x.isOdd() -> print("x is odd")
      x.isEven() -> print("x is even")
      else -> print("x is funny")
  }
  ```
  
#### for 循环

- 对任何迭代器进行遍历
  ```kotlin
  
  // item 的类型是通过 collection 自动推断出来的
  for (item in collection) print(item)

  for (item: Int in ints) {
      // ……
  }
  ```
  
- 遍历数组或者集合

  ```kotlin
  // array.indices 元素的下标区间 
  for (i in array.indices) {
      print(array[i])
  }

  for ((index, value) in array.withIndex()) {
      println("the element at $index is $value")
  }
  ```

#### While 循环

- ```kotlin
  // 和 Java 一样
  while (x > 0) {
      x--
  }
  
  do {
    val y = retrieveData()
  } while (y != null) // y 在此处可见
  ```