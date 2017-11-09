package vlfsoft.algorithms.sort

import vlfsoft.patterns.BehavioralPattern
import vlfsoft.patterns.StructuralPattern

/**
 * See <a href="https://en.wikipedia.org/wiki/Bubble_sort">Bubble sort</a>
 */
@ComparisonSort(oBest = Sort.O.n, oAverage = Sort.O.n2, oWorst = Sort.O.n2, memory = SORT_MEMORY_1, stable= Sort.Stable.Yes, method = Sort.Method.Exchanging)
@BehavioralPattern.Strategy.Implementation
class BubbleSortStrategy<T : Comparable<T>> : SortStrategyA<T> {
    override fun  perform(arrayToSort: Array<T>) {

        @StructuralPattern.LocalMethod
        fun <T : Comparable<T>> atLeastOneSwapOccurredDuringPass(unsortedElements: Int, arrayToSort: Array<T>): Boolean {
            var atLeastOneSwapOccurred = false
            for (i in 1 until unsortedElements) {
                if (arrayToSort[i] < arrayToSort[i - 1]) {
                    arrayToSort.swap(i, i - 1)
                    atLeastOneSwapOccurred = true
                }
            }
            return atLeastOneSwapOccurred
        }

        for (unsortedElements in arrayToSort.size downTo 0 step 1) {
            if (atLeastOneSwapOccurredDuringPass(unsortedElements, arrayToSort)) continue
        }


        // Functional programming paradigm style is less readable than imperative one
/*
        (arrayToSort.size downTo 0 step 1)
                .takeWhile { atLeastOneSwapOccurredDuringPass(it, arrayToSort) }
                .forEach { }
*/
    }

}