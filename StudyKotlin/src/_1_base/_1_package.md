- 导入包的指定内容
  ```kotlin
  import foo.Bar
  ```
- 导入包的所有内容
  ```kotlin
  import foo.* // “foo”中的一切都可访问
  ```
- 出现命名冲突，使用 as 重命名
  ```kotlin
  import foo.Bar // Bar 可访问
  import bar.Bar as bBar // bBar 代表“bar.Bar”
  ```
- 没有 Java import static 语法，都是有 import