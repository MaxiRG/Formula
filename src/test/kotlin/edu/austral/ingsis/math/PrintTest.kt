package edu.austral.ingsis.math

import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Test

class PrintTest {
    /**
     * Case 1 + 6
     */
    @Test
    fun shouldPrintFunction1() {
        val sumOperation = Operation(ListVariablesTest.sumLambda, "+", listOf(Number(1.0), Number(6.0)))
        val result = sumOperation.getString()
        val expected = "1 + 6"

        MatcherAssert.assertThat(result, CoreMatchers.equalTo(expected))
    }

    /**
     * Case 12 / 2
     */
    @Test
    fun shouldPrintFunction2() {
        val divideOperation = Operation(ListVariablesTest.divideLambda, "/", listOf(Number(12.0), Number(2.0)))
        val result = divideOperation.getString()
        val expected = "12 / 2"
        MatcherAssert.assertThat(
            result,
            CoreMatchers.equalTo(expected)
        )
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    fun shouldPrintFunction3() {
        val divideOperation = Operation(ListVariablesTest.divideLambda, "/", listOf(Number(9.0), Number(2.0)))
        val mulOperation = Operation(ListVariablesTest.mulLambda, "*", listOf(divideOperation, Number(3.0)))
        val result = mulOperation.getString()
        val expected = "(9 / 2) * 3"
        MatcherAssert.assertThat(
            result,
            CoreMatchers.equalTo(expected)
        )
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    fun shouldPrintFunction4() {
        val divideOperation = Operation(ListVariablesTest.divideLambda, "/", listOf(Number(27.0), Number(6.0)))
        val expOperation = Operation(ListVariablesTest.exponentLambda, "^", listOf(divideOperation, Number(2.0)))
        val result = expOperation.getString()
        val expected = "(27 / 6) ^ 2"
        MatcherAssert.assertThat(
            result,
            CoreMatchers.equalTo(expected)
        )
    }

    /**
     * Case |value| - 8
     */
    @Test
    fun shouldPrintFunction6() {
        val modOperation = Operation(ListVariablesTest.modLambda, "mod", listOf(Variable("value")))
        val minusOperation = Operation(ListVariablesTest.subLambda, "+", listOf(modOperation, Number(8.0)))
        val result = minusOperation.getString()
        val expected = "|value| - 8"
        MatcherAssert.assertThat(
            result,
            CoreMatchers.equalTo(expected)
        )
    }

    /**
     * Case |value| - 8
     */
    @Test
    fun shouldPrintFunction7() {
        val modOperation = Operation(ListVariablesTest.modLambda, "mod", listOf(Variable("value")))
        val minusOperation = Operation(ListVariablesTest.subLambda, "+", listOf(modOperation, Number(8.0)))
        val result = minusOperation.getString()
        val expected = "|value| - 8"
        MatcherAssert.assertThat(
            result,
            CoreMatchers.equalTo(expected)
        )
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    fun shouldPrintFunction8() {
        val minusOperation = Operation(ListVariablesTest.subLambda, "-", listOf(Number(5.0), Variable("i")))
        val mulOperation = Operation(ListVariablesTest.mulLambda, "*", listOf(minusOperation, Number(8.0)))
        val result = mulOperation.getString()
        val expected = "(5 - i) * 8"
        MatcherAssert.assertThat(
            result,
            CoreMatchers.equalTo(expected)
        )
    }
}
