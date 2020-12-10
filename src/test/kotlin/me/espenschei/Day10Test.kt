package me.espenschei

import io.kotest.matchers.shouldBe
import me.espenschei.Resources.readFileAsIntList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.lang.System.lineSeparator

class Day10Test {
    val exampleNumbers = """
        28
        33
        18
        42
        31
        14
        46
        20
        48
        47
        24
        23
        49
        45
        19
        38
        39
        11
        1
        32
        25
        35
        8
        17
        7
        9
        4
        2
        34
        10
        3
        """.trimIndent().split(lineSeparator()).map { it.toInt() }

    @Nested
    @DisplayName("First part")
    inner class First {

        @Test
        fun `example answer`() {

            val answer = Day10(exampleNumbers).first()

            answer shouldBe 220
        }

        @Test
        fun `actual answer`() {
            val answer = Day10(readFileAsIntList("Day10_numbers.txt")).first()

            answer shouldBe 3000
        }
    }

    @Nested
    @DisplayName("Second part")
    inner class Second {

        @Test
        fun `example answer`() {

            val answer = Day10(exampleNumbers).second()

            answer shouldBe 19208L
        }

        @Test
        fun `actual answer`() {
            val answer = Day10(readFileAsIntList("Day10_numbers.txt")).second()

            answer shouldBe 193434623148032L
        }
    }
}
