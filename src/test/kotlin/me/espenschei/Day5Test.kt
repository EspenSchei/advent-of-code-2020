package me.espenschei

import io.kotest.matchers.shouldBe
import me.espenschei.Resources.readFileAsList
import me.espenschei.Resources.readFileAsText
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day5Test {

    @Nested
    @DisplayName("First part")
    inner class First {

        @Test
        fun `example answer`() {
            val exampleSeats = listOf("BFFFBBFRRR", "FFFBBBFRRR", "BBFFBBFRLL")

            val answer = Day5.first(exampleSeats)

            answer shouldBe 820
        }
    }

        @Test
        fun `actual answer`() {
            val answer = Day5.first(readFileAsList("day5_seats.txt"))

            answer shouldBe 245
        }

    @Nested
    @DisplayName("Second part")
    inner class Second {

        @Test
        fun `actual answer`() {
            val answer = Day5.second(readFileAsList("day5_seats.txt"))

            answer shouldBe 739
        }
    }
}
