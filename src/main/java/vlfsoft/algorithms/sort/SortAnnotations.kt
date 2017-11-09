package vlfsoft.algorithms.sort

/**
 * See <a href="https://en.wikipedia.org/wiki/Sorting_algorithm">Sorting algorithm</a>
 */
interface Sort {

    /**
     * See <a href="https://en.wikipedia.org/wiki/Big_O_notation">Big O notation</a>
     */
    enum class O { n, n2, n_log_n, n_log2_n_or_n5_4, n_log2_n }
    enum class Stable { Yes, No, YesAndNo }
    enum class Method { Partitioning, Merging, Selection, Insertion, PartitioningAndSelection, InsertionAndMerging, Exchanging, DistributionAndMerge, Unknown }
    enum class Comparison { Yes, No, Polling }

}

const val SORT_MEMORY_1: String = "1"

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION,
        AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
annotation class ComparisonSort(val oBest: Sort.O, val oAverage: Sort.O, val oWorst: Sort.O, val memory: String, val stable: Sort.Stable, val method: Sort.Method)

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION,
        AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
annotation class NonComparisonSort(val oBest: Sort.O, val oAverage: Sort.O, val oWorst: Sort.O, val memory: String, val stable: Sort.Stable)

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION,
        AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
annotation class OtherSort(val oBest: Sort.O, val oAverage: Sort.O, val oWorst: Sort.O, val memory: String, val comparison: Sort.Comparison)
