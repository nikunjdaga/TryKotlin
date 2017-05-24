#### 数据类
- JavaBean 使用 data 标记即可
  ```kotlin
  data class User(val name: String, val age: Int)
  // 使用 data 标记后
  // 主构造参数自动生产 equals、hashCode、toString、copy、cmponentN ???

  // 如果这些函数中的任何一个在类体中显式定义或继承自其基类型，则不会生成该函数。
  // 这句什么意思看不懂啊 ???

  // 数据类的规则
  // 1. 主构造函数需要至少有一个参数；
  // 2. 主构造函数的所有参数需要标记为 val 或 var；
  // 3. 数据类不能是抽象、开放、密封或者内部的；
  ```
  
- 使用无参构造
  ```kotlin
  data class User(val name: String = "", val age: Int = 0)
  // 这样就可以 var user = User()
  ```
  
#### 复制

- 在很多情况下，我们需要复制一个对象改变它的一些属性，但其余部分保持不变。 copy() 函数就是为此而生成。
  ```kotlin
  // 数据类
  data class User(var name: String = "",
                  var age: Int = 0,
                  var address : String = "China")
                
  val lxm = User()  // 无参构造
  lxm.name = "lxm"
  val cjq = lxm.copy("cjq",8)  // 复制
  // 注意：copy 的参数必须和数据类一致，可以缺省
  ```

#### 数据类和解构声明
- ```kotlin
  val jane = User("Jane", 35)

  // 从数据类中提取数据，同样可以缺省参数
  val (name, age) = jane
  println("$name, $age years of age") // 输出 "Jane, 35 years of age"
  ```
  
#### 标准数据类
- Pair 和 Triple，快速声明两个元素和三个元素的集合