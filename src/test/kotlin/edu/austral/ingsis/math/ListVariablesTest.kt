package edu.austral.ingsis.math

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.Test
import kotlin.math.*

class ListVariablesTest {

    companion object {
        val sumLambda: (List<Double>) -> Double = { numbers ->
            numbers.reduceOrNull { acc, next -> acc + next } ?: 0.0
        }

        val divideLambda: (List<Double>) -> Double = { numbers ->
            if (numbers[1] != 0.0) {
                numbers[0] / numbers[1]
            } else {
                throw IllegalArgumentException("Cannot divide by zero")
            }
        }
        val mulLambda: (List<Double>) -> Double = { numbers ->
            numbers[0] * numbers[1]
        }

        val exponentLambda: (List<Double>) -> Double = { numbers ->
            numbers[0].pow(numbers[1])
        }

        val modLambda: (List<Double>) -> Double = { numbers ->
            abs(numbers[0])
        }

        val subLambda: (List<Double>) -> Double = { numbers ->
            numbers.reduceOrNull { acc, next -> acc - next } ?: 0.0
        }
    }
    /**
     * Case 1 + 6
     */
    @Test
    fun shouldListVariablesFunction1() {
        val sumOperation = Operation(sumLambda, "+", listOf(Number(1.0), Number(6.0)))
        val result = sumOperation.getVariables(listOf())
        MatcherAssert.assertThat(result, Matchers.empty())
    }

    /**
     * Case 12 / div
     */
    @Test
    fun shouldListVariablesFunction2() {
        val divideOperation = Operation(divideLambda, "/", listOf(Number(12.0), Variable("div")))
        val result = divideOperation.getVariables(listOf())
        MatcherAssert.assertThat(result, Matchers.containsInAnyOrder("div"))
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    fun shouldListVariablesFunction3() {
        val divideOperation = Operation(divideLambda, "/", listOf(Number(9.0), Variable("x")))
        val mulOperation = Operation(mulLambda, "*", listOf(divideOperation, Variable("y")))
        val result = mulOperation.getVariables(listOf())
        MatcherAssert.assertThat(result, Matchers.containsInAnyOrder("x", "y"))
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    fun shouldListVariablesFunction4() {
        val divideOperation = Operation(divideLambda, "/", listOf(Number(27.0), Variable("a")))
        val expOperation = Operation(exponentLambda, "^", listOf(divideOperation, Variable("b")))
        val result = expOperation.getVariables(listOf())
        MatcherAssert.assertThat(result, Matchers.containsInAnyOrder("a", "b"))
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    fun shouldListVariablesFunction5() {
        val expOperation = Operation(exponentLambda, "^", listOf(Variable("z"), Number(0.5)))
        val result = expOperation.getVariables(listOf())
        MatcherAssert.assertThat(result, Matchers.containsInAnyOrder("z"))
    }

    /**
     * Case |value| - 8
     */
    @Test
    fun shouldListVariablesFunction6() {
        val modOperation = Operation(modLambda, "mod", listOf(Variable("value")))
        val minusOperation = Operation(subLambda, "+", listOf(modOperation, Number(8.0)))
        val result = minusOperation.getVariables(listOf())
        MatcherAssert.assertThat(result, Matchers.containsInAnyOrder("value"))
    }

    /**
     * Case |value| - 8
     */
    @Test
    fun shouldListVariablesFunction7() {
        val modOperation = Operation(modLambda, "mod", listOf(Variable("value")))
        val minusOperation = Operation(subLambda, "+", listOf(modOperation, Number(8.0)))
        val result = minusOperation.getVariables(listOf())
        MatcherAssert.assertThat(result, Matchers.containsInAnyOrder("value"))
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    fun shouldListVariablesFunction8() {
        val minusOperation = Operation(subLambda, "-", listOf(Number(5.0), Variable("i")))
        val mulOperation = Operation(mulLambda, "*", listOf(minusOperation, Number(8.0)))
        val result = mulOperation.getVariables(listOf())
        MatcherAssert.assertThat(result, Matchers.containsInAnyOrder("i"))
    }
}
