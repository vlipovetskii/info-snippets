package vlfsoft.algorithms.sort

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class TestData(val name: String, val arrayToSort: Array<Int>, val arraySorted: Array<Int>)

class SortStrategyTest {

    private val sortTestData = listOf(
            TestData("emptyTest", arrayOf(), arrayOf()),
            TestData("oneElementTest", arrayOf(1), arrayOf(1)),
            TestData("twoElementsInOrderTest", arrayOf(2, 3), arrayOf(2, 3)),
            TestData("twoElementsOutOfOrderTest", arrayOf(3, 2), arrayOf(2, 3)),
            TestData("twoElementsEqualTest", arrayOf(2, 2), arrayOf(2, 2)),
            TestData("tenElementsReverseTest", arrayOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1), arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)),
            TestData("tenElementsShuffledTest", arrayOf(3, 2, 7, 6, 1, 8, 10, 9, 4, 5), arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
    )

    private fun testSortFactory(strategyToTest: SortStrategyA<Int>) =
            sortTestData.map {
                DynamicTest.dynamicTest(it.name) {
                    it.arrayToSort.sortWith(strategyToTest)
                    Assertions.assertArrayEquals(it.arraySorted, it.arrayToSort)
                }
            }

    @TestFactory
    fun testBogoSortStrategy() = testSortFactory(BogoSortStrategy())

    @TestFactory
    fun testBubbleSortStrategy() = testSortFactory(BubbleSortStrategy())

    @TestFactory
    fun testShellSortStrategy() = testSortFactory(ShellSortStrategy())

}