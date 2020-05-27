package de.ashnu.experiments

import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import kotlin.system.measureNanoTime
import kotlin.test.Test
import kotlin.test.assertEquals

class TailRecursionTest {
    @Test
    fun testFactory() {
        val time = measureNanoTime {
            (1..100).forEach { value -> factorial(value) }
        }
        println("testFactory: \n" + time)
    }

    @Test
    fun testFactorialTailRecursive() {
        val time = measureNanoTime {
            (1..100).forEach { value -> factorialTailRecursive(value) }
        }
        println("testFactoryTailRecursive: \n" + time)
    }

    @TestFactory
    fun testFactorialEquals() = (1..100).map { value ->
        DynamicTest.dynamicTest(
            "factorial " + value,
            {
                val expected = factorial(value)
                val actual = factorialTailRecursive(value)
                assertEquals(expected, actual)
            })
    }

    @Test
    fun testFibonacci() {
        val time = measureNanoTime {
            (0..20).forEach { value -> fibonacci(value) }
        }
        println("testFibonacci: \n" + time)
    }

    @Test
    fun testFibonacciTailRecursive() {
        val time = measureNanoTime {
            (0..20).forEach { value -> fibonacciTailRecursive(value) }
        }
        println("testFibonacciTailRecursive: \n" + time)
    }

    @TestFactory
    fun testFibonacciEquals() = (1..20).map { value ->
        DynamicTest.dynamicTest(
            "fibonacci " + value,
            {
                val expected = fibonacci(value)
                val actual = fibonacciTailRecursive(value)
                assertEquals(expected, actual)
            })
    }
}