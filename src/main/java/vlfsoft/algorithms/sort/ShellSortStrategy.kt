package vlfsoft.algorithms.sort

import vlfsoft.patterns.BehavioralPattern

/**
 * See <a href="https://en.wikipedia.org/wiki/Shellsort">Shellsort</a>
 */
@ComparisonSort(oBest = Sort.O.n_log_n, oAverage = Sort.O.n_log2_n_or_n5_4, oWorst = Sort.O.n_log2_n, memory = SORT_MEMORY_1, stable = Sort.Stable.No, method = Sort.Method.Insertion)
@BehavioralPattern.Strategy.Implementation
class ShellSortStrategy<T : Comparable<T>> : SortStrategyA<T> {
    override fun perform(arrayToSort: Array<T>) {

        var k = arrayToSort.size / 2
        while (k > 0) {
            var i = k
            while (i < arrayToSort.size) {
                val tmp = arrayToSort[i]
                var j: Int = i
                while (j >= k) {
                    if (tmp < arrayToSort[j - k])
                        arrayToSort[j] = arrayToSort[j - k]
                    else
                        break
                    j -= k
                }
                arrayToSort[j] = tmp
                i ++
            }
            k /= 2
        }

    }
}