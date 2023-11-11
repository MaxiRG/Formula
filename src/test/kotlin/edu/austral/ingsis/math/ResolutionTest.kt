package edu.austral.ingsis.math

import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Test

class ResolutionTest {
    /**
     * Case 1 + 6
     */
    @Test
    fun shouldResolveSimpleFunction1() {
        val sumOperation = Operation(ListVariablesTest.sumLambda, "+", listOf(Number(1.0), Number(6.0)))
        val result = sumOperation.getValue(mapOf())
        MatcherAssert.assertThat(result, CoreMatchers.equalTo(7.0))
    }

    /**
     * Case 12 / 2
     */
    @Test
    fun shouldResolveSimpleFunction2() {
        val divideOperation = Operation(ListVariablesTest.divideLambda, "/", listOf(Number(12.0), Number(2.0)))
        val result = divideOperation.getValue(mapOf())
        MatcherAssert.assertThat(result, CoreMatchers.equalTo(6.0))
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    fun shouldResolveSimpleFunction3() {
        val divideOperation = Operation(ListVariablesTest.divideLambda, "/", listOf(Number(9.0), Number(2.0)))
        val mulOperation = Operation(ListVariablesTest.mulLambda, "*", listOf(divideOperation, Number(3.0)))
        val result = mulOperation.getValue(mapOf())
        MatcherAssert.assertThat(result, CoreMatchers.equalTo(13.5))
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    fun shouldResolveSimpleFunction4() {
        val divideOperation = Operation(ListVariablesTest.divideLambda, "/", listOf(Number(27.0), Number(6.0)))
        val expOperation = Operation(ListVariablesTest.exponentLambda, "^", listOf(divideOperation, Number(2.0)))
        val result = expOperation.getValue(mapOf())
        MatcherAssert.assertThat(result, CoreMatchers.equalTo(20.25))
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    fun shouldResolveSimpleFunction5() {
        val expOperation = Operation(ListVariablesTest.exponentLambda, "^", listOf(Number(36.0), Number(0.5)))
        val result = expOperation.getValue(mapOf())
        MatcherAssert.assertThat(result, CoreMatchers.equalTo(6.0))
    }

    /**
     * Case |136|
     */
    @Test
    fun shouldResolveSimpleFunction6() {
        val modOperation = Operation(ListVariablesTest.modLambda, "mod", listOf(Number(136.0)))
        val result = modOperation.getValue(mapOf())
        MatcherAssert.assertThat(result, CoreMatchers.equalTo(136.0))
    }

    /**
     * Case |-136|
     */
    @Test
    fun shouldResolveSimpleFunction7() {
        val modOperation = Operation(ListVariablesTest.modLambda, "mod", listOf(Number(-136.0)))
        val result = modOperation.getValue(mapOf())
        MatcherAssert.assertThat(result, CoreMatchers.equalTo(136.0))
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    fun shouldResolveSimpleFunction8() {
        val minusOperation = Operation(ListVariablesTest.subLambda, "-", listOf(Number(5.0), Number(5.0)))
        val mulOperation = Operation(ListVariablesTest.mulLambda, "*", listOf(minusOperation, Number(8.0)))
        val result = mulOperation.getValue(mapOf())
        MatcherAssert.assertThat(result, CoreMatchers.equalTo(0.0))
    }
}
