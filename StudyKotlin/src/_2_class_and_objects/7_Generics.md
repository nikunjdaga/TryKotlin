#### 泛型

- ```kotlin
  // 和 Java 一样在类上生命泛型
  class Box<T>(t: T) {
      var value = t
  }

  // 创建时指定泛型
  val box: Box<Int> = Box<Int>(1)
 
  // 泛型可以从构造函数推断出来，可以省略
  val box = Box(1)
  ```
#### 函数泛型

- 类型参数放在函数之前
  ```kotlin
  fun <T> singletonList(item: T): List<T> {
      // ……
  }
  
  fun <T> T.basicToString() : String {  // 扩展函数
      // ……
  }
  
  // 要调用泛型函数，在调用处函数名之后指定类型参数即可
  val l = singletonList<Int>(1)
  ```
  
#### 泛型约束

- 上界
    ```kotlin
    // T 只能是 User 的子类型
    fun <T : User> sort(list: List<T>) {
        // ……
    }
    
    // 默认上界是 Any?
    ```
    
- 一个函数需要多个上界

    ```kotlin
    fun <T> cloneWhenGreater(list: List<T>, threshold: T): List<T>
        where T : Comparable,
              T : Cloneable {
      return list.filter { it > threshold }.map { it.clone() }
    }
    ```
    
- 指定多个上界

    ```kotlin
    // 使用 where 在返回值的后面指定多个上界
    // 看不懂
    fun <T> cloneWhenGreater(list: List<T>, threshold: T): List<T>
        where T : Comparable,
              T : Cloneable {
      return list.filter { it > threshold }.map { it.clone() }
    }
    ```

