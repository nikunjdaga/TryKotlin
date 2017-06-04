# Kotlin for android developers

- kotlin-android-extensions 一个强大的插件，替代 findViewById

  - apply plugin: 'kotlin-android-extensions'

  - 给 View 声明 id

  - 使用

    ```kotlin
    import kotlinx.android.synthetic.main.activity_main.*

    // 一个 id 是 hello 的 TextView
    hello.text = "Hi!"

    // adapter、自定义View 都可以使用
    mView.hello = "Hi"
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
    	
    	// 可以直接使用 this 代替 p
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

- Lambdas 的演化

  ```kotlin
  // 1. 定义一个函数式接口(只有一个方法的接口)
  public interface OnClickListener {
      void onClick(View v);
  }

  // 2. Java 正常使用
  view.setOnClickListener(new OnClickListener(){
      @Override
      public void onClick(View v) {
          Toast.makeText(v.getContext(), "Click", Toast.LENGTH_SHORT).show();
      }
  })

  // 3. Java 使用 Lambdas
  view.setOnClickListener(v -> {
    	Toast.makeText(v.getContext(), "Click", Toast.LENGTH_SHORT).show();
  })

  // 4. Kotlin 正常使用
  view.setOnClickListener(object : OnClickListener {
      override fun onClick(v: View) {
          toast("Click")
      }
  }
                          
  // 5. 在 Kotlin 中，函数式接口可以直接定义成一个函数
  // 函数名 listener 参数 View 返回值 Unit
  fun setOnClickListener(listener: (View) -> Unit)
                          
  // 6. 使用 Lambdas
  view.setOnClickListener({ view -> toast("Click")})
  // 一个lambda表达式通过参数的形式被定义在箭头的左边（被圆括号包围），然后在箭头的右边返回结果值。
  // 在这个例子中，我们接收一个View，然后返回一个Unit（没有东西)

  // 7. 左边参数没有用到，可以省略
  view.setOnClickListener({ toast("Click") })

  // 8. 如果 Lambdas 在是最后一个参数，可以移到 () 外面
  view.setOnClickListener() { toast("Click") }
                          
  // 9. 如果只有 Lambdas 一个参数，可以省略 ()
  view.setOnClickListener { toast("Click") }                                   
  ```



- 扩展函数

  ```kotlin
  // 声明一个扩展函数，函数名：code，参数：无，返回值：Unit
  // inline 声明为内联函数
  inline fun supportsLollipop(code: () -> Unit) {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
          code()
      }
  }

  // 使用
  supportsLollipop {
    	toast("supportsLollipop")
  }
  ```

- 可见性修饰符


-   private：如果定义在了文件中，只对被定义的文件可见；如果被定义在了类、接口中，只对这个类、接口可见。
  - protected：只能用来修饰类或接口的成员 ，可以被自己和子类可见。
  - internal：moudle 内可见。
  - public：默认的修饰符，随处可见。

- 委托属性

  ```kotlin
  class Example {
      // 使用 by 给我们的属性指定一个委托对象
      // 当我们使用属性的 get 或者 set 的时候，委托对象的 getValue 和 setValue 就会被调用
      var p: String by Delegate()
  }
  ```

- 自定义委托属性

  ```kotlin

  // 继承 ReadWriteProperty
  // T 委托属性的类型
  // thisRef 委托属性所在类的引用
  // property 属性的元数据

  class NotNullSingleValueVar<T> : ReadWriteProperty<Any?, T> {

      // 默认为 null
      private var value: T? = null
      override fun getValue(thisRef: Any?, property: KProperty<*>): T {
          // value 为 null 抛出异常
          return value ?: throw IllegalStateException("${property.name} " +
              "not initialized")
      }

      override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
          // 只有 value 是 null 的时候，才能 setValue
          // setValue 只能正确执行一次，value 只能被赋值一次
          this.value = if (this.value == null) value
          else throw IllegalStateException("${property.name} already initialized")
      }
  }

  // 使用 NotNullSingleValueVar
  class App : Application() {

      companion object {   // thisRef
          var instance: App by NotNullSingleValueVar() // App 是 T
      }

      override fun onCreate() {
          super.onCreate()
          instance = this   // 只能赋值一次，再次赋值会抛出异常
      }
  }
  ```

  ​

