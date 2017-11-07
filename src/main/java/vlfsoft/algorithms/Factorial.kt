package vlfsoft.algorithms

import vlfsoft.paradigms.ProgrammingParadigm
import java.lang.IllegalArgumentException

// https://en.wikipedia.org/wiki/Factorial

/**
 * The function demonstrates using: <ul>
 * <li> https://docs.oracle.com/javase/9/docs/api/index.html?java/lang/IllegalArgumentException.html</li>
 * <li> https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing.html</li>
 * <li> https://kotlinlang.org/docs/reference/exceptions.html#try-is-an-expression</li>
 * <li> https://kotlinlang.org/docs/reference/exceptions.html#the-nothing-type</li>
 * <li> https://kotlinlang.org/docs/reference/functions.html#single-expression-functions</li>
 * <li> https://kotlinlang.org/docs/reference/functions.html#single-expression-functions</li>
 * </ul>
 */
@ProgrammingParadigm.Declarative.Functional
private fun illegalFactorialArgumentException(num: Long): Nothing = throw IllegalArgumentException("num $num < 0")

/**
 * The function demonstrates using: <ul>
 * <li> https://kotlinlang.org/docs/reference/control-flow.html#when-expression</li>
 * </ul>
 */
@ProgrammingParadigm.Structured.Recursion
fun factorial1(num: Long): Long =
        when {
            (num == 0L) -> 1
            (num > 0L) -> num * factorial1(num - 1)
            else -> illegalFactorialArgumentException(num)
        }

/**
 * The function demonstrates using: <ul>
 * <li> https://kotlinlang.org/docs/reference/control-flow.html#for-loops</li>
 * <li> https://kotlinlang.org/docs/reference/ranges.html#ranges</li>
 * <li> https://kotlinlang.org/docs/reference/operator-overloading.html#binary-operations</li>
 * </ul>
 */
@ProgrammingParadigm.Imperative.Procedural
fun factorial2(num: Long): Long {
    if (num >= 0L) {
        var result = 1L
        for (i in 2L..num) result *= i
        return result
    } else {
        throw illegalFactorialArgumentException(num)
    }
}

/**
 * The function demonstrates using: <ul>
 * <li> https://kotlinlang.org/docs/reference/control-flow.html#when-expression</li>
 * <li> https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html#extension-functions</li>
 * <li> https://kotlinlang.org/docs/reference/ranges.html#ranges</li>
 * <li> https://kotlinlang.org/docs/reference/operator-overloading.html#binary-operations</li>
 * </ul>
 */
@ProgrammingParadigm.Declarative.Functional
fun factorial3(num: Long) =
        when {
            (num == 0L) -> 1
            (num > 0L) -> (1L..num).reduce(Long::times)
            else -> illegalFactorialArgumentException(num)
        }

/**
 * The function demonstrates using: <ul>
 * <li> https://kotlinlang.org/docs/reference/control-flow.html#if-expression</li>
 * <li> https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html#extension-functions</li>
 * <li> https://kotlinlang.org/docs/reference/operator-overloading.html#binary-operations</li>
 * <li> https://kotlinlang.org/docs/reference/ranges.html#ranges</li>
 * </ul>
 */
@ProgrammingParadigm.Declarative.Functional
fun factorial4(num: Long) = if (num >= 0L) (2L..num).fold(1L, Long::times) else illegalFactorialArgumentException(num)

/**
 * The function demonstrates using: <ul>
 * <li> https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html#extension-functions</li>
 * <li> https://kotlinlang.org/docs/reference/lambdas.html#higher-order-functions</li>
 * <li> https://kotlinlang.org/docs/reference/inline-functions.html</li>
 * <li> https://kotlinlang.org/docs/reference/lambdas.html#function-types</li>
 * <li> https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.sequences/index.html</li>
 * </ul>
 */
private inline fun LongRange.factorialSequence(crossinline factorialFun: (Long) -> Long) = asSequence().map { factorialFun(it) }

fun LongRange.factorialSequence1() = factorialSequence(::factorial1)
fun LongRange.factorialSequence2() = factorialSequence(::factorial2)
fun LongRange.factorialSequence3() = factorialSequence(::factorial3)
fun LongRange.factorialSequence4() = factorialSequence(::factorial4)