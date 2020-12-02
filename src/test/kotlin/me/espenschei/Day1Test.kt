package me.espenschei

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day1Test {
    private val testNumbers = listOf(1721, 979, 366, 299, 675, 1456)
    private val actualNumbers = Resources.readFileAsIntList("day1_numbers.txt")

    @Nested
    @DisplayName("First part")
    inner class First {

        @Test
        fun `example answer`() {
            val answer = Day1.first(testNumbers)

            answer shouldBe (299 * 1721)
        }

        @Test
        fun `actual answer`() {
            val answer = Day1.first(actualNumbers)

            answer shouldBe 1_003_971
        }
    }

    @Nested
    @DisplayName("Second part")
    inner class Second {

        @Test
        fun `example answer`() {
            val answer = Day1.second(testNumbers)

            answer shouldBe (979 * 366 * 675)
        }

        @Test
        fun `actual answer`() {
            val answer = Day1.second(actualNumbers)

            answer shouldBe 84_035_952
        }
    }
}
