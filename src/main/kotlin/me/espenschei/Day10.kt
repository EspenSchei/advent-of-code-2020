package me.espenschei

class Day10(input: List<Int>) {
    private val numbers = input.plus(0).plus(input.max()!! + 3).sorted()

    fun first(): Int = numbers
        .zipWithNext { a, b -> b - a }
        .let { jolt -> jolt.count { it == 3 } * jolt.count { it == 1 } }

    fun second(): Long? = numbers
        .fold(mutableMapOf(1 to 1L, 2 to 1L, 3 to 1L)) { memory, num ->
            memory[num] = (0..3).map { memory[num - it] ?: 0 }.sum()
            memory
        }[numbers.last()]
}
