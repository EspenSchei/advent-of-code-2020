package me.espenschei

class Day9(private val input: List<Long>) {

    fun first(preambleSize: Int): Long? = input
        .drop(preambleSize)
        .mapIndexed { index, num ->
            addsTo(input.subList(index, index + preambleSize), num).let { if (it) null else num }
        }
        .first { it != null }

    fun second(invalidNumber: Long): Long? {
        for (i in 0..input.indexOf(invalidNumber)) {
            var sum = 0L
            var j = i
            while (sum < invalidNumber) {
                sum += input[j]
                if (sum == invalidNumber) {
                    input.subList(i, j).sorted().let { return it.first() + it.last() }
                }
                j++
            }
        }

        return null
    }

    private fun addsTo(preamble: List<Long>, num: Long): Boolean = preamble
        .map { n -> preamble.any { it + n == num } }
        .any { it }
}
