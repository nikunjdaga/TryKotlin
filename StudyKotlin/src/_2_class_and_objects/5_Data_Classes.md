#### 数据类
- JavaBean 使用 data 标记即可
  ```kotlin
  data class User(val name: String, val age: Int)
  // 使用 data 标记后
  // 主构造参数自动生产 equals、hashCode、toString、copy、cmponentN ???

  // 如果这些函数中的任何一个在类体中显式定义或继承自其基类型，则不会生成该函数。
  // 这句什么意思看不懂啊 ???
  ```