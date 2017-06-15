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

- String 可以像数组那样访问和迭代

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
                          
  // 5. 在 Kotlin 中，函数式接口可以直接定义成一个 lambda
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



- 创建 Adapter

  ```kotlin

  // 注意这里 val itemClick: (ForecastVO) -> Unit，itemClick 的类型实际是一个 lambda 表达式
  class ForecastListAdapter(val datas: ForecastListVO, val itemClick: (ForecastVO) -> Unit) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

      override fun getItemCount() = datas.size()

      override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

          val view = LayoutInflater.from(parent.ctx)
              .inflate(R.layout.item_forecast, parent, false)
          return ViewHolder(view, itemClick)
      }

      override fun onBindViewHolder(holder: ViewHolder, position: Int) {

          holder.bindForecast(datas[position])
      }
  ```


      class ViewHolder(itemView: View, val itemClick: (ForecastVO) -> Unit) :
          RecyclerView.ViewHolder(itemView) {
    
          fun bindForecast(forecast: ForecastVO) {
    
              with(forecast) {
                  Picasso.with(itemView.ctx).load(iconUrl).into(itemView.icon)
                  itemView.date.text = date
                  itemView.description.text = description
                  itemView.maxTemperature.text = high.toString()
                  itemView.minTemperature.text = low.toString()
                  itemView.setOnClickListener { itemClick(this) }
              }
          }
      }
  }

  // 使用这个 adapter
  rvForecastList.adapter = ForecastListAdapter(result) {
  	toast(it.date)
  }
  ```

  ​

- 扩展语言

  ```kotlin
  // 参数声明一个 lamdba，函数名：code，参数：无，返回值：Unit
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

  - map

    ```kotlin
    // 构造函数传一个 map，map[_id] 会赋值给 _id，map[city] 会赋值给 city
    class CityForecast(val map: MutableMap<String, Any?>,
                               val dailyForecast: List<DayForecast>) {
        var _id: Long by map     // 以 _id 为 key 和 map 映射
        var city: String by map
        var country: String by map

        // "id"，"city"，"country" 会作为 key 将只值保存到 HashMap() 中
        constructor(id: Long, city: String, country: String,
                    dailyForecast: List<DayForecast>) : this(HashMap(), dailyForecast) {
            this._id = id
            this.city = city
            this.country = country
        }
    }
    ```

    ​

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

  ​


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

       // static 定义一些常量
       companion object {
           val DB_NAME = "forecast.db"
           val DB_VERSION = 1

           // ForecastDbHelper 单例，懒加载，线程安全
           val instance: ForecastDbHelper by lazy { ForecastDbHelper() }
       }
   }
  ```



- 一些集合


-   **Iterable**：所有集合的父类，我们可以遍历的集合都是实现了这个接口

  - **MutableIterable**：一个支持遍历的同时可以执行删除的 Iterable

  - **Collection**：这个类相是一个范性集合，我们通过函数访问可以返回集合的 size、是否为空、是否包含一个或者一些 item，这个集合的所有方法提供查询

  - **MutableCollection**：一个支持增加和删除 item 的 Collection，它提供了额外的函数，比如`add`、`remove`、`clear` 等等

  - **List**：可能是最流行的集合，有序

  - **MutableList**：一个支持增加和删除 item 的 List

  - **Set**：一个无序并不支持重复 item 的集合

  - **MutableSet**：一个支持增加和删除 item 的 Set

  - **Map**：一个 key-value 对的 collection，key 在 map 中是唯一的

  - **MutableMap**：一个支持增加和删除 item 的 map

- 总数操作符

  ```kotlin
   val list = listOf(1, 2, 3, 4, 5, 6)

   // any 集合中只要有一个元素符合条件返回 true，都不符合返回 false
   println(list.any { it % 2 == 0 })   // true
   println(list.any { it > 10 })       // false

   // all，集合中所有的元素都符合条件返回 true，否则返回 false
   println(list.all { it % 2 == 0 })  // false
   println(list.all { it < 10 })      // true

   // count，计算集合中符合条件的元素个数
   println(list.count { it % 2 == 0 })  // 3

   // fold，给定初始值，按照公式计算集合中每个元素的计算一遍
   // total 初始值 4，4 + 1 + 2 + 3 + 4 + 5 + 6 = 25
   println(list.fold(4) { init, next -> init + next })

   // foldRight，与fold一样，但是顺序是从最后一项到第一项
   // 2 * 6 * 5 * 4 * 3 * 2 * 1 = 1440
   println(list.foldRight(2) { init, next -> init * next })

   // forEach，遍历所有的元素，并给出指定操作
   list.forEach {
       print("$it 、")  // 1 、2 、3 、4 、5 、6 、
   }
   println()

   // max，返回最大的一项
   println(list.max())  // 6

   // maxBy，根据给定的函数返回最大的一项
   println(list.maxBy { -it })   // 1, 最大的一项是 -1

   // min，返回最小的一项
   println(list.min())  // 1

   // minBy，根据给定的函数返回最小的一项
   println(list.minBy { -it })   // 6, 最小的一项是 -6

   // none，没有任何元素符合条件返回 true，否则返回 false
   println(list.none { it % 7 == 0 })  // true

   // reduce，与 fold 一样，初始值为永远为 0
   println(list.reduce { init, next -> init + next })  // 21

   // reduceRight，与 foldRight 一样，初始值为永远为 0
   println(list.reduceRight { init, next -> init * next })  // 720

   // sumBy，每个元素经过函数计算后，累加求和
   println(list.sumBy { it % 2 })  // 3
  ```

  ​




- 过滤操作符

  ```kotlin
  val list = listOf(1, 2, 3, 4, 5, 6)

  // dorp，去掉前 n 个元素
  println(list.drop(4))  // [5, 6]

  // dropWhile，从第一个元素开始，去掉截止到第一个不符合条件的元素
  println(list.dropWhile { it < 4 })       // [4, 5, 6]

  // dropLastWhile，和 dropWhile 一样，不过是从最后一个元素开始
  println(list.dropLastWhile { it > 4 })   // [1, 2, 3, 4]

  // filter，保留所有符合条件的元素，去掉其他元素
  println(list.filter { it % 2 == 0 })     // [2, 4, 6]

  // filterNot，去掉所有符合条件的元素
  println(list.filterNot { it % 2 == 0 })  // [1, 3, 5]

  // filterNotNull, 去掉所有 null
  val listWithNull = listOf(1, null, 3, null, 5, 6)
  println(listWithNull.filterNotNull())    // [1, 3, 5, 6]

  // slice，保留 index 区间内的元素
  // 保留 [1,2,3] index
  println(list.slice(1..3))            // [2, 3, 4]
  // list 也是一个区间，保留 [1,2,4] index
  println(list.slice(listOf(1, 3, 4))) // [2, 4, 5]

  // take，保留从第一个元素开始的 n 个元素
  println(list.take(2))                // [1, 2]

  // takeLast，保留从最后一个开始的 n 个元素
  println(list.takeLast(2))            // [5, 6]

  // takeWhile，从第一个元素开始，保留截止到第一个不符合条件的元素
  println(list.takeWhile { it < 3 })   // [1, 2]

  // 当然，还有 takeLastWhile , take 和 drop 刚好相反，一个保留一个去掉
  ```

  ​

- 映射操作符

  ```kotlin
  val list = listOf(1, 2, 3, 4, 5, 6)

  // flatMap，遍历所有元素，为每一个元素创建一个集合，合并集合
  println(list.flatMap { listOf(it, it + 1) })  // [1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7]

  // groupBy，根据函数给 list 分组，最后保存到 map 中
  val map = list.groupBy { if (it % 2 == 0) "even" else "odd" }
  println(map)         // {odd=[1, 3, 5], even=[2, 4, 6]}
  println(map["even"]) // [2, 4, 6]
  println(map["odd"])  // [1, 3, 5]

  // map，将集合中每个元素进行变换组成新的集合
  println(list.map { it * 2 })  // [2, 4, 6, 8, 10, 12]

  // mapIndexed，比 map 多了一个 index 参数，可以使用 index 参与变换
  println(list.mapIndexed { index, it -> index * it })   // [0, 2, 6, 12, 20, 30]
  ```

- 元素操作符

  ```kotlin
  fun main(args: Array<String>) {

      val list = listOf(1, 2, 3, 4, 5, 6)

      // contains，集合是否包含一个元素
      println(list.contains(2))  // true

      // elementAt，取出 index 为 n 的元素，内部是调用的 get(index)
      // 如果 index 越界，抛出 IndexOutOfBoundsException
      println(list.elementAt(1))  // 2
  ```


      // elementAtOrElse，和 elementAt 相同，数组越界返回默认值
      // 这里 it 就是 7
      println(list.elementAtOrElse(7, { 2 * it }))  // 14
    
      // elementAtOrNull，和 elementAt 相同，数组越界返回 null
      println(list.elementAtOrNull(10))  // null
    
      // first，返回符合条件的第一个元素，不存在抛出 NoSuchElementException
      println(list.first { it % 2 == 0 })   // 2
    
      // firstOrNull，返回符合条件的第一个函数，没有返回 null
      println(list.firstOrNull { it % 7 == 0 })  // null
    
      // indexOf，返回指定元素的第一个 index，不存在返回 -1
      println(list.indexOf(4))    // 3
      println(list.indexOf(7))    // -1
    
      // lastIndexOf，返回指定元素的最后一个 index，不存在返回 -1
      println(list.lastIndexOf(3))    // 2
    
      // indexOfFirst，返回第一个符合条件元素的 index，不存返回 -1
      println(list.indexOfFirst { it % 2 == 0 })   // 1
    
      // indexOfLast，返回最后一个符合条件元素的 index，不存返回 -1
      println(list.indexOfLast { it % 2 == 0 })   // 5
    
      // last，返回最后一个符合条件的元素，不存在抛出 NoSuchElementException
      println(list.last { it % 2 == 0 })  // 6
    
      // lastOrNull，返回最后一个符合条件的元素，没有返回 null
      println(list.lastOrNull { it % 7 == 0 })  // null
    
      // single，返回符合条件的唯一元素
      // 不存在抛出 NoSuchElementException，多个符合抛出 IllegalArgumentException
      println(list.single{it % 5 == 0})   // 5
    
      // singleOrNull，返回符合条件的唯一元素，不存在或多个返回 null
      println(list.singleOrNull{it % 2 == 0})  // null
      println(list.singleOrNull{it % 7 == 0})  // null

  }
  ```

- 生产操作符

  ```kotlin
  fun main(args: Array<String>) {

      val list = listOf(1, 2, 3, 4, 5, 6)
      val listRepeated = listOf(2, 2, 3, 4, 5, 5, 6)
      // merge 没找到这个操作符
      

      // partition，根据一个函数将集合分成两个，返回一个 Pair
      // Pair first 是函数返回 true 的元素组成的集合
      // Pair second 是函数返回 false 的元素组成的集合
      val pair = list.partition { it % 2 == 0 }
      println(pair)
      println(pair.first)      // [2, 4, 6]
      println(pair.second)     // [1, 3, 5]


      // plus，可以用 + 代替，合并两个集合
      println(list.plus(listOf(7, 8)))   // [1, 2, 3, 4, 5, 6, 7, 8]
      println(list + listOf(7, 8, 9))    // [1, 2, 3, 4, 5, 6, 7, 8, 9]

      // zip，返回由 pair组成的 List，每个 pair由两个集合中相同 index的元素组成。
      // 这个返回的List的大小由最小的那个集合决定。
      println(list.zip(listOf(7, 8)))    // [(1, 7), (2, 8)]


      // unzip，将一个 List<Pair> 转为 Pair(List,List)
      // Pair 的 first 是 List<Pair> 中每个 Pair 的 first 组成的 List
      // Pair 的 second 是 List<Pair> 中每个 Pair 的 second 组成的 List
      val listPair = listOf(Pair(5, 7), Pair(6, 8))   // [(5, 7), (6, 8)]
      println(listPair.unzip())    // ([5, 6], [7, 8])
  }
  ```

- 排序操作符

  ```kotlin
  fun main(args: Array<String>) {

      val list = listOf(3, 2, 7, 5)

      // reversed，反转
      println(list.reversed())  // [5, 7, 2, 3]

      // sorted，排序（升序）
      println(list.sorted())    // [2, 3, 5, 7]

      // sortedBy 根据函数结果排序（升序）
      println(list.sortedBy { it % 3 })  // [3, 7, 2, 5]

      // sortedDescending，排序（降序）
      println(list.sortedDescending())   // [7, 5, 3, 2]

      // sortedBy 根据函数结果排序（降序）
      println(list.sortedByDescending { it % 3 })  // [2, 5, 7, 3]
  }
  ```

- 保存和读取数据库

  ```kotlin
  // 太复杂，先占坑
  ```

- null 安全

  - 黄金准则：如果变量是可以是null，编译器强制我们去用某种方式去处理。

    ```kotlin
    val a: Int? = null
    a.toString()  // 不能编译

    vala:Int? = null
    if(a != null) {
        // if 代码块中，a 的类型从 Int? 智能转换为 Int
        a.toString()  
    }

    a?.toString()   // a 不为 null 才调用 toString 方法

    val a:Int? = null
    val myString = a?.toString() ?: "null"   // a 不为 null 返回 toString，null 返回 "null"

    a!!.toString()  // 断言 a != null，null 直接抛出异常
    ```

  - 记住，如果你使用了 `!!`，可能是因为你确信对象不可能为null，如果是这样，请定义为非null。