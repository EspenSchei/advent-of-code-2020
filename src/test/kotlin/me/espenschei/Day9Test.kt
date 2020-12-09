package me.espenschei

import io.kotest.matchers.shouldBe
import me.espenschei.Resources.readFileAsIntList
import me.espenschei.Resources.readFileAsList
import me.espenschei.Resources.readFileAsLongList
import me.espenschei.Resources.readFileAsText
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.lang.System.lineSeparator

class Day9Test {
    val exampleNumbers = """
        35
        20
        15
        25
        47
        40
        62
        55
        65
        95
        102
        117
        150
        182
        127
        219
        299
        277
        309
        576
        """.trimIndent().split(lineSeparator()).map { it.toLong() }

    @Nested
    @DisplayName("First part")
    inner class First {

        @Test
        fun `example answer`() {

            val answer = Day9(exampleNumbers).first(5)

            answer shouldBe 127
        }

        @Test
        fun `actual answer`() {
            val answer = Day9(readFileAsLongList("day9_numbers.txt")).first(25)

            answer shouldBe 1_504_371_145
        }
    }

    @Nested
    @DisplayName("Second part")
    inner class Second {

        @Test
        fun `example answer`() {

            val answer = Day9(exampleNumbers).second(127)

            answer shouldBe 62
        }

        @Test
        fun `actual answer`() {
            val answer = Day9(readFileAsLongList("day9_numbers.txt")).second(1_504_371_145)

            answer shouldBe 183278487
        }
    }
}
