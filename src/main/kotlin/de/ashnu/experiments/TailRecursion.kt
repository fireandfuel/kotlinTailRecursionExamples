package de.ashnu.experiments

fun factorial(value: Int): Int = when (value) {
    1 -> 1
    else -> value * factorial(value - 1)
}

tailrec fun factorialTailRecursive(value: Int, accumulator: Int = 1): Int = when (value) {
    1 -> accumulator
    else -> factorialTailRecursive(value - 1, value * accumulator)
}

fun fibonacci(value: Int): Int = when (value) {
    0 -> 0
    1 -> 1
    else -> fibonacci(value - 1) + fibonacci(value - 2)
}

tailrec fun fibonacciTailRecursive(value: Int, first: Int = 0, second: Int = 1): Int = when (value) {
    0 -> first
    1 -> second
    else -> fibonacciTailRecursive(value - 1, second, first + second)
}