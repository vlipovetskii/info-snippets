package vlfsoft.algorithms.sort

import vlfsoft.patterns.BehavioralPattern

/**
 * See <a href="https://en.wikipedia.org/wiki/Bogo_sort">Bogosort</a>
 */
@OtherSort(oBest = Sort.O.n, oAverage = Sort.O.n2, oWorst = Sort.O.n2, memory = SORT_MEMORY_1, comparison = Sort.Comparison.Yes)
@BehavioralPattern.Strategy.Implementation
class BogoSortStrategy<T : Comparable<T>> : SortStrategyA<T> {
    override fun perform(arrayToSort: Array<T>) {
        while (!arrayToSort.isSortedAsc) {
            arrayToSort.shuffle()
        }
    }

}