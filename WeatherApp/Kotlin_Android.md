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

- 标准委托（还未用到，先占个坑）

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

  - 使用 Kotlin 简化 SqlLite 操作

    ```kotlin
    compile "org.jetbrains.anko:anko-sqlite:$anko_version"
    ```

  - 定义表：

    ```kotlin
    object CityForecastTable {
        val NAME = "CityForecast"
        val ID = "_id"
        val CITY = "city"
        val COUNTRY = "country"
    }
    ```

  - 实现 SqliteOpenHelper

    ```kotlin
    // 继承 ManagedSQLiteOpenHelper
    class ForecastDbHelper() : ManagedSQLiteOpenHelper(
        App.instance,                 // context
        ForecastDbHelper.DB_NAME,     // 数据库名称
        null,                         // 游标工厂
        ForecastDbHelper.DB_VERSION   // 数据库版本
    ) {

        override fun onCreate(db: SQLiteDatabase) {

            // 创建表
            db.createTable(CityForecastTable.NAME, // 表名
                true, // true 创建之前检查这个表是否存在
                
                // CityForecastTable.ID：列名
                // INTEGER：SqlType 类型，用来描述列的数据类型
                // 其他的 SqlType 还有 NULL、REAL、TEXT、BLOB
                // PRIMARY_KEY：SqlTypeModifier 类型，用来描述列的特性
                // 其他的 NOT_NULL、AUTOINCREMENT、UNIQUE
                // SqlType 和 SqlTypeModifier 可以用 + 链接 (操作符重载)
                           
                Pair(CityForecastTable.ID, INTEGER + PRIMARY_KEY),   // 列
                Pair(CityForecastTable.CITY, TEXT),
                Pair(CityForecastTable.COUNTRY, TEXT)

            db.createTable(DayForecastTable.NAME, true,
                // Pair 的重载函数
                DayForecastTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                DayForecastTable.DATE to INTEGER,
                DayForecastTable.DESCRIPTION to TEXT,
                DayForecastTable.HIGH to INTEGER,
                DayForecastTable.LOW to INTEGER,
                DayForecastTable.ICON_URL to TEXT,
                DayForecastTable.CITY_ID to INTEGER)
        }

      
        // 数据库升级时调用
        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            // 删除表，然后重建
            // 注意：这样处理数据库升级是不正确的 ！
    		db.dropTable(CityForecastTable.NAME, true)
        	db.dropTable(DayForecastTable.NAME, true)
        	onCreate(db)
        }

      
        // static 定义一些长量
        companion object {
            val DB_NAME = "forecast.db"
            val DB_VERSION = 1

            // ForecastDbHelper 单例，懒加载，线程安全
            val instance: ForecastDbHelper by lazy { ForecastDbHelper() }
        }
    }
    ```

  - 一些集合

    - **Iterable**：所有集合的父类，我们可以遍历的集合都是实现了这个接口
    - **MutableIterable**：一个支持遍历的同时可以执行删除的 Iterable
    - **Collection**：这个类相是一个范性集合，我们通过函数访问可以返回集合的 size、是否为空、是否包含一个或者一些 item，这个集合的所有方法提供查询
    - **MutableCollection**：一个支持增加和删除item的 Collection，它提供了额外的函数，比如`add`、`remove`、`clear` 等等

