package vlfsoft.algorithms

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.function.Executable
import vlfsoft.paradigms.ProgrammingParadigm
import kotlin.reflect.KFunction
import kotlin.streams.asStream

// https://en.wikipedia.org/wiki/Factorial
class FactorialTest {

    /**
     * The function demonstrates using: <ul>
     * <il>https://kotlinlang.org/docs/reference/functions.html#infix-notation</li>
     * <il>https://kotlinlang.org/docs/reference/extensions.html#extension-functions</li>
     * <il>https://kotlinlang.org/docs/reference/functions.html#variable-number-of-arguments-varargs</li>
     * <il>https://kotlinlang.org/docs/reference/basic-syntax.html#defining-variables with inferred type</il>
     * </ul>
     */
    private val factorialTestData = listOf(
            -2L to "IllegalArgumentException",
            -1L to "IllegalArgumentException",
            0L to 1L,
            1L to 1L,
            2L to 2L,
            3L to 6L,
            4L to 24L)

    /**
     */
    /**
     * The function demonstrates using: <ul>
     * <il>https://kotlinlang.org/docs/reference/functions.html#infix-notation</li>
     * <li> https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html#extension-functions</li>
     * <li> http://junit.org/junit5/docs/current/user-guide/</li>
     * <li> http://junit.org/junit5/docs/current/user-guide/#writing-tests-dynamic-tests</li>
     * <li> http://kotlinlang.org/docs/reference/basic-syntax.html#using-string-templates</li>
     * <li> JUnit 5 features: assertThrows</li>
     * <li> https://kotlinlang.org/docs/reference/reflection.html#function-references</li>
     * <li> https://kotlinlang.org/docs/reference/reflection.html</li>
     * <li> https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-function/index.html</li>
     * </ul>
     */
    @ProgrammingParadigm.Declarative.Functional
    private fun testFactorial1Factory(factorialFun: (Long) -> Long) =
            factorialTestData
                    .map { (input, expected) ->
                        DynamicTest.dynamicTest("when I calculate ${(factorialFun as KFunction<*>).name}($input) then I get $expected") {
                            if (input < 0) assertThrows(IllegalArgumentException::class.java) { factorial1(input) }
                            else assertEquals(expected, factorialFun(input))
                        }
                    }

    @ProgrammingParadigm.Declarative.Functional
    @TestFactory
    fun testFactorial1Factory1() = testFactorial1Factory(::factorial1)

    @ProgrammingParadigm.Declarative.Functional
    @TestFactory
    fun testFactorial1Factory2() = testFactorial1Factory(::factorial2)

    @ProgrammingParadigm.Declarative.Functional
    @TestFactory
    fun testFactorial1Factory3() = testFactorial1Factory(::factorial3)

    @ProgrammingParadigm.Declarative.Functional
    @TestFactory
    fun testFactorial1Factory4() = testFactorial1Factory(::factorial4)

    /**
     * The function demonstrates using: <ul>
     * <li> JUnit 5 features: assertThrows, assertAll</li>
     * <li> https://kotlinlang.org/docs/reference/reflection.html#function-references</li>
     * <li> https://kotlinlang.org/docs/reference/reflection.html#function-references</li>
     * <li> https://kotlinlang.org/docs/reference/reflection.html#function-references</li>
     * </ul>
     */
    @ProgrammingParadigm.Declarative.Functional
    private fun factorialSequenceTest(factorialSequenceFun: LongRange.() -> Sequence<Long>) {

        // The code block demonstrates using:
        // http://junit.org/junit5/docs/current/api/org/junit/jupiter/api/Assertions.html#assertAll-org.junit.jupiter.api.function.Executable...-
        assertAll(
                Executable { assertThrows(IllegalArgumentException::class.java) { (-2L..-2L).factorialSequenceFun().first() } },
                Executable { assertThrows(IllegalArgumentException::class.java) { (-1L..-1L).factorialSequenceFun().first() } },
                Executable { assertEquals(1L, (0L..0L).factorialSequenceFun().first()) },
                Executable { assertEquals(2L, (2L..2L).factorialSequenceFun().first()) },
                Executable { assertEquals(6L, (3L..3L).factorialSequenceFun().first()) },
                Executable { assertEquals(24L, (4L..4L).factorialSequenceFun().first()) }
        )

        // The code block demonstrates using:
        // http://junit.org/junit5/docs/current/api/org/junit/jupiter/api/Assertions.html#assertAll-java.util.stream.Stream-
        // https://docs.oracle.com/javase/9/docs/api/java/util/stream/package-summary.html
        assertAll(
                factorialTestData.asSequence().asStream()
                        .map { inputPair ->
                            if (inputPair.first < 0) Executable { assertThrows(IllegalArgumentException::class.java) { (inputPair.first..inputPair.first).factorialSequenceFun().first() } }
                            else Executable {
                                assertEquals(inputPair.second, (inputPair.first..inputPair.first).factorialSequenceFun().first())
                            }
                        }
        )

    }

    @ProgrammingParadigm.Declarative.Functional
    @Test
    fun factorialSequenceTest1() {
        factorialSequenceTest(LongRange::factorialSequence1)
    }

    @ProgrammingParadigm.Declarative.Functional
    @Test
    fun factorialSequenceTest2() {
        factorialSequenceTest(LongRange::factorialSequence2)
    }

    @ProgrammingParadigm.Declarative.Functional
    @Test
    fun factorialSequenceTest3() {
        factorialSequenceTest(LongRange::factorialSequence3)
    }

    @ProgrammingParadigm.Declarative.Functional
    @Test
    fun factorialSequenceTest4() {
        factorialSequenceTest(LongRange::factorialSequence4)
    }

}