package vlfsoft.algorithms.sort

import vlfsoft.patterns.BehavioralPattern
import java.util.*

@BehavioralPattern.Strategy.Interface
interface SortStrategyA<T : Comparable<T>> {
    fun perform(arrayToSort: Array<T>)
}

fun <T> Array<T>.swap(i: Int, j: Int) {
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
}

fun <T : Comparable<T>> Array<T>.sortWith(sortStrategy: SortStrategyA<T>) {
    sortStrategy.perform(this)
}

/**
 * The function shuffles the elements of the array
 */
fun <T> Array<T>.shuffle() {
    val random = Random()
    for (i in 0 until size) {
        swap(i, random.nextInt(size))
    }
}

val <T : Comparable<T>> Array<T>.isSortedAsc: Boolean get() = (1 until size).none { this[it - 1] > this[it] }

