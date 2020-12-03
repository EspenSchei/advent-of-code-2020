package me.espenschei

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day3Test {
    private val exampleMap = """
        ..##.......
        #...#...#..
        .#....#..#.
        ..#.#...#.#
        .#...##..#.
        ..#.##.....
        .#.#.#....#
        .#........#
        #.##...#...
        #...##....#
        .#..#...#.#
    """.trimIndent().split("\n")
    private val actualMap = Resources.readFileAsList("day3_map.txt")

    @Nested
    @DisplayName("First part")
    inner class First {
        private val route: Pair<Int, Int> = (3 to 1)

        @Test
        fun `example answer`() {
            val answer = Day3.first(exampleMap, route)

            answer shouldBe 7
        }

        @Test
        fun `actual answer`() {
            val answer = Day3.first(actualMap, route)

            answer shouldBe 203
        }
    }

    @Nested
    @DisplayName("Second part")
    inner class Second {
        private val routes = listOf(1 to 1, 3 to 1, 5 to 1, 7 to 1, 1 to 2)

        @Test
        fun `example answer`() {
            val answer = Day3.second(exampleMap, routes)

            answer shouldBe 336
        }

        @Test
        fun `actual answer`() {
            val answer = Day3.second(actualMap, routes)

            answer shouldBe 3_316_272_960L
        }
    }
}
