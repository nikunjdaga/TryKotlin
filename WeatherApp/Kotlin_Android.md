# Kotlin for android developers

- kotlin-android-extensions 一个强大的插件，替代 findViewById

  - apply plugin: 'kotlin-android-extensions'

  - 给 View 声明 id

  - 使用

    ```kotlin
    import kotlinx.android.synthetic.main.activity_main.*

    // 一个 id 是 hello 的 TextView
    hello.text = "Hi!"
    ```

    ​

- 函数默认参数，完美替代了 Java 的重载函数

  ```kotlin
  fun toast(message:String,length:Int = Toast.LENGTH_SHORT) {
  	Toast.makeText(this,message,length).show()
  }

  // 调用
  toast("Kotlin")
  toast("Kotlin",Toast.LENGTH_LONG)
  ```

- String 可以数组那样访问和迭代

  ```kotlin
  val s = "Example"
  val c = s[2] // 这是一个字符'a'
  // 迭代String
  val s = "Example"
  for(c in s){
      print(c)
  }
  ```

  ​

- Kotlin 中访问属性会访问默认的 setter、getter

  ```kotlin
  // 使用自己的 getter、setter
  public classs Person {
      var name: String = ""
    		
    		// 注意：这里我们使用 field 访问 name 
    		// 如果直接使用 name 会调用 getter，最后爆栈
          // field 只能在属性访问器内访问
          get() = field.toUpperCase()
          set(value){
              field = "Name: $value"
          }
  }
  ```

- Anko

  Anko 是一个由 JetBrains 开发的一个用于快速开发 Android 的 Kotlin 库，目前包括以下几部分：

  - *Anko Commons*: a lightweight library full of helpers for intents, dialogs, logging and so on;
  - *Anko Layouts*: a fast and type-safe way to write dynamic Android layouts;
  - *Anko SQLite*: a query DSL and parser collection for Android SQLite;
  - *Anko Coroutines*: utilities based on the [kotlinx.coroutines](https://github.com/Kotlin/kotlinx.coroutines) library.

- Kotlin 的网络请求

  ```kotlin
  val json = URL(url).readText()
  // Kotlin 给 URL 实现了一个扩展函数 readText
  // 创建 URL、使用 HttpURLConnection 请求网络、将 InputStream 转换为 String
  // 想想 Java 的代码，蠢哭了
  
  doAsync { // 子线程

    	val json = URL(url).readText()
    	uiThread {  // UI 线程
      	toast("After request")
    	}
  }
  // 注意：doAsync、uiThread、toast 都是 Anko 封装的
  ```

- 一切
  ```