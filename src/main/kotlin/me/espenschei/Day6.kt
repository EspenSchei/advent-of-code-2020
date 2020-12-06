package me.espenschei

import java.lang.System.*

object Day6 {

    fun first(input: String): Int = input
        .split(lineSeparator() + lineSeparator())
        .map { it.replace(lineSeparator(), "") }
        .map { it.toSet().size }
        .sum()

    fun second(input: String): Int = input
        .split(lineSeparator() + lineSeparator())
        .map { it.split(lineSeparator()) }
        .map { it.first().map { answer -> it.all { form -> form.contains(answer) } } }
        .sumOf { it.count { p -> p } }

}
