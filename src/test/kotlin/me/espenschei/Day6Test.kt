package me.espenschei

import io.kotest.matchers.shouldBe
import me.espenschei.Resources.readFileAsList
import me.espenschei.Resources.readFileAsText
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day6Test {
    val exampleForm = """
            abc
    
            a
            b
            c
    
            ab
            ac
    
            a
            a
            a
            a
    
            b
        """.trimIndent()

    @Nested
    @DisplayName("First part")
    inner class First {


        @Test
        fun `example answer`() {

            val answer = Day6.first(exampleForm)

            answer shouldBe 11
        }

        @Test
        fun `actual answer`() {
            val answer = Day6.first(readFileAsText("day6_forms.txt"))

            answer shouldBe 6662
        }
    }

    @Nested
    @DisplayName("Second part")
    inner class Second {
        @Test
        fun `example answer`() {

            val answer = Day6.second(exampleForm)

            answer shouldBe 6
        }


        @Test
        fun `actual answer`() {
            val answer = Day6.second(readFileAsText("day6_forms.txt"))

            answer shouldBe 3382
        }
    }
}
