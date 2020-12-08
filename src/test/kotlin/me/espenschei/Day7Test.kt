package me.espenschei

import io.kotest.matchers.shouldBe
import me.espenschei.Resources.readFileAsList
import me.espenschei.Resources.readFileAsText
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.lang.System.lineSeparator

class Day7Test {
    val exampleRules = """
            light red bags contain 1 bright white bag, 2 muted yellow bags.
            dark orange bags contain 3 bright white bags, 4 muted yellow bags.
            bright white bags contain 1 shiny gold bag.
            muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
            shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
            dark olive bags contain 3 faded blue bags, 4 dotted black bags.
            vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
            faded blue bags contain no other bags.
            dotted black bags contain no other bags.
        """.trimIndent().split(lineSeparator())

    @Nested
    @DisplayName("First part")
    inner class First {

        @Test
        fun `example answer`() {

            val answer = Day7.first(exampleRules)

            answer shouldBe 4
        }

        @Test
        fun `actual answer`() {
            val answer = Day7.first(readFileAsList("day7_bags.txt"))

            answer shouldBe 148
        }
    }

    @Nested
    @DisplayName("Second part")
    inner class Second {

        @Test
        fun `example answer`() {
            val answer = Day7.second(exampleRules)

            answer shouldBe 32
        }

        @Test
        fun `example answer 2`() {
            val exampleInput = """
                shiny gold bags contain 2 dark red bags.
                dark red bags contain 2 dark orange bags.
                dark orange bags contain 2 dark yellow bags.
                dark yellow bags contain 2 dark green bags.
                dark green bags contain 2 dark blue bags.
                dark blue bags contain 2 dark violet bags.
                dark violet bags contain no other bags.
            """.trimIndent().split(lineSeparator())

            val answer = Day7.second(exampleInput)

            answer shouldBe 126
        }

        @Test
        fun `actual answer`() {
            val answer = Day7.second(readFileAsList("day7_bags.txt"))

            answer shouldBe 24867
        }
    }
}
