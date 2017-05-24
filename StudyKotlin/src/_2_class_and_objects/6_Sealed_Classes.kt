package _2_class_and_objects

/**
 * Created by ssyijiu on 2017/5/24.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 */

// 密封类，看不懂

sealed class Expr
data class Const(val number: Double) : Expr()
data class Sum(val e1: Expr, val e2: Expr) : Expr()
object NotANumber : Expr()

fun eval(expr: Expr): Double = when (expr) {
    is Const -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    NotANumber -> Double.NaN

    // 不需要 else
}