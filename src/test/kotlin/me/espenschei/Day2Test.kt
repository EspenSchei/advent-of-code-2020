package me.espenschei

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test


@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class Day2Test {
    private val input = this.javaClass.classLoader.getResourceAsStream("day2_passwords.txt")
        .bufferedReader()
        .readLines()

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
