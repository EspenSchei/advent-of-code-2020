package me.espenschei

object Day3 {
    fun first(lines: List<String>, route: Pair<Int, Int>): Int {
        var position = 0
        var counter = 0

        for (i in lines.indices step route.second) {
            if (lines[i][position] == '#') {
                counter++
            }
            position = (position + route.first) % lines[0].length
        }

        return counter
    }

    fun second(lines: List<String>, routes: List<Pair<Int, Int>>): Long =
        routes
            .map { route -> first(lines, route) }
            .map { it.toLong() }
            .reduce { a, b -> a * b }
}
