package me.espenschei

object Day5 {

    fun first(input: List<String>): Int? = input.map { it.findSeatId() }.maxOrNull()

    fun second(input: List<String>): Int? = input
        .map { it.findSeatId() }
        .sorted()
        .zipWithNext { l, r -> if (l + 1 < r) return l + 1 }
        .run { return null }

    private fun String.findSeatId(): Int = this.take(7).findPos(128).first * 8 + this.takeLast(3).findPos(7).second

    private fun String.findPos(max: Int): Pair<Int, Int> = this.fold(0 to max) { range, char ->
        if (listOf('F', 'L').contains(char)) (range.first to (range.second + range.first) / 2)
        else ((range.second + range.first) / 2 to range.second)
    }
}
