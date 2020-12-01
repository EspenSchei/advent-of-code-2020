package me.espenschei

import java.lang.RuntimeException

object Day1 {
    fun first(numbers: List<Int>, addsTo: Int = 2020): Int? {
        numbers.forEach {
            val match = addsTo - it
            if (numbers.contains(match)) {
                return match * it
            }
        }

        return null
    }

    fun second(numbers: List<Int>): Int {
        numbers.forEach { n ->
            val subMatch = 2020 - n
            first(
                numbers = numbers.minus(n).filter { x -> x <= subMatch },
                addsTo = subMatch
            )?.let { return it.times(n) }
        }

        throw RuntimeException("Failed to find sum")
    }
}
