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

- 一切 Kotlin 函数都会返回一个值，如果没有指定返回 Unit。

- DTO (服务器获取的数据)  -> Mapper -> VO (视图显示的数据)

- with 

  ```kotlin
  data class Person(var name:String,var age:Int) {
      fun eat() {
          MLog.i("Person is eating")
      }
  }

  val p = Person("lxm",24)
  with(p) {
      // with 的作用域内可以直接使用 Persion 的属性和方法
    	MLog.i("name = $name, age = $age")  // name = lxm, age = 24
    	eat()  // Person is eating
  }
  ```

- 操作符重载

  - 一些操作符会和一些函数一一对应，我们重载这个函数，可以改变其对应操作的符的作用
  - 重载操作符使用关键字 operator
  - [操作符和函数对应表](https://www.kotlincn.net/docs/reference/operator-overloading.html)

  举一个例子：

  ```kotlin
  // [] 和 get 对应
  // list[i] 实际上是调用 list.get(i)
  // 我们重载 get(i) 这个方法，就可以使用 list[i] 按照我们自己的需求起作用
  data class ForecastList(val city: String, val country: String,
                          val dailyForecast:List<Forecast>) {
      // 重载 get 方法，可以直接使用 ForecastList[i] 了
      operator fun get(position:Int):Forecast = dailyForecast[position]
      fun size():Int = dailyForecast.size
  }
  ```

  再来一个例子：

  ```kotlin
  // invoke 对应 ()
  // 重载操作符，itemClick(forecast) 就调用了 invoke 这个方法
  interface OnItemClickListener {
    	operator fun invoke(forecast: Forecast)
  }
  ```

  ​

- 扩展函数中的操作符

  ```Kotlin
  // 为 ViewGroup 扩展一个方法，重载 get
  operator fun ViewGroup.get(position: Int): View = getChildAt(position)

  // 使用 [] 代替 get
  val container: ViewGroup = find(R.id.container)
  val view = container[2]
  ```

- 扩展属性

  ```kotlin
  // 给 View 添加一个扩展属性
  // ctx 返回 context
  val View.ctx:Context
      get() = context

  // 写一个 ViewExtensions.kt 完全不用 UIUtils 了
  ```

- 创建一个匿名内部类

  ```kotlin
  // 写一个接口
  interface OnItemClickListener {
  	operator fun invoke(forecast: Forecast)
  }

  // 创建这个接口的匿名内部类
  object : OnItemClickListener {
    	override fun invoke(forecast: Forecast) {
      	toast(forecast.date)
  }
  ```

  ​