package me.espenschei

import io.kotest.matchers.shouldBe
import me.espenschei.Resources.readFileAsList
import me.espenschei.Resources.readFileAsText
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.lang.System.lineSeparator

class Day8Test {
    val exampleInstructions = """
        nop +0
        acc +1
        jmp +4
        acc +3
        jmp -3
        acc -99
        acc +1
        jmp -4
        acc +6
        """.trimIndent().split(lineSeparator())

    @Nested
    @DisplayName("First part")
    inner class First {

        @Test
        fun `example answer`() {

            val answer = Day8(exampleInstructions).first()

            answer shouldBe 5
        }

        @Test
        fun `actual answer`() {
            val answer = Day8(readFileAsList("day8_bootcode.txt")).first()

            answer shouldBe 1475
        }
    }

    @Nested
    @DisplayName("Second part")
    inner class Second {

        @Test
        fun `example answer`() {

            val answer = Day8(exampleInstructions).second()

            answer shouldBe 8
        }

        @Test
        fun `actual answer`() {
            val answer = Day8(readFileAsList("day8_bootcode.txt")).second()

            answer shouldBe 1270
        }
    }
}
