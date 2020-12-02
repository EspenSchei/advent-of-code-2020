package me.espenschei

import io.kotest.matchers.shouldBe
import me.espenschei.Resources.readFileAsList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day2Test {
    private val input = readFileAsList("day2_passwords.txt")

    @Nested
    @DisplayName("First part")
    inner class First {
        @Test
        fun `actual answer`() {
            val answer = Day2.first(input)

            answer shouldBe 447
        }
    }

    @Nested
    @DisplayName("Second part")
    inner class Second {
        @Test
        fun `actual answer`() {
            val answer = Day2.second(input)

            answer shouldBe 249
        }
    }
}
