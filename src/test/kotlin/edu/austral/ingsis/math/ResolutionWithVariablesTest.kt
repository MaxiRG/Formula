package edu.austral.ingsis.math

import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Test

class ResolutionWithVariablesTest {
    /**
     * Case 1 + x where x = 3
     */
    @Test
    fun shouldResolveFunction1() {
        val sumOperation = Operation(ListVariablesTest.sumLambda, "+", listOf(Number(1.0),Variable("x")))
        val result = sumOperation.getValue(mapOf("x" to 3.0))
        MatcherAssert.assertThat(result, CoreMatchers.equalTo(4.0))
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    fun shouldResolveFunction2() {
        val divideOperation = Operation(ListVariablesTest.divideLambda, "/", listOf(Number(12.0), Variable("div")))
        val result = divideOperation.getValue(mapOf("div" to 4.0))
        MatcherAssert.assertThat(result, CoreMatchers.equalTo(3.0))
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    fun shouldResolveFunction3() {
        val divideOperation = Operation(ListVariablesTest.divideLambda, "/", listOf(Number(9.0), Variable("x")))
        val mulOperation = Operation(ListVariablesTest.mulLambda, "*", listOf(divideOperation, Variable("y")))
        val result = mulOperation.getValue(mapOf("x" to 3.0, "y" to 4.0))
        MatcherAssert.assertThat(result, CoreMatchers.equalTo(12.0))
    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    fun shouldResolveFunction4() {
        val divideOperation = Operation(ListVariablesTest.divideLambda, "/", listOf(Number(27.0), Variable("a")))
        val expOperation = Operation(ListVariablesTest.exponentLambda, "^", listOf(divideOperation, Variable("b")))
        val result = expOperation.getValue(mapOf("a" to 9.0, "b" to 3.0))
        MatcherAssert.assertThat(result, CoreMatchers.equalTo(27.0))
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    fun shouldResolveFunction5() {
        val expOperation = Operation(ListVariablesTest.exponentLambda, "^", listOf(Variable("z"), Number(0.5)))
        val result = expOperation.getValue(mapOf("z" to 36.0))
        MatcherAssert.assertThat(result, CoreMatchers.equalTo(6.0))
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    fun shouldResolveFunction6() {
        val modOperation = Operation(ListVariablesTest.modLambda, "mod", listOf(Variable("value")))
        val minusOperation = Operation(ListVariablesTest.subLambda, "+", listOf(modOperation, Number(8.0)))
        val result = minusOperation.getValue(mapOf("value" to 8.0))
        MatcherAssert.assertThat(result, CoreMatchers.equalTo(0.0))
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    fun shouldResolveFunction7() {
        val modOperation = Operation(ListVariablesTest.modLambda, "mod", listOf(Variable("value")))
        val minusOperation = Operation(ListVariablesTest.subLambda, "+", listOf(modOperation, Number(8.0)))
        val result = minusOperation.getValue(mapOf("value" to 8.0))
        MatcherAssert.assertThat(result, CoreMatchers.equalTo(0.0))
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    fun shouldResolveFunction8() {
        val minusOperation = Operation(ListVariablesTest.subLambda, "-", listOf(Number(5.0), Variable("i")))
        val mulOperation = Operation(ListVariablesTest.mulLambda, "*", listOf(minusOperation, Number(8.0)))
        val result = mulOperation.getValue(mapOf("i" to 2.0))
        MatcherAssert.assertThat(result, CoreMatchers.equalTo(24.0))
    }
}
