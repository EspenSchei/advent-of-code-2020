package me.espenschei

class Day8(private val input: List<String>) {

    fun first(): Int = run(input).accumulator

    fun second(): Int = input
        .asSequence()
        .map { it.toggleInstructionOrNull() }
        .mapIndexedNotNull { i, instruction -> instruction?.let { run(input.updated(i, it)) } }
        .first { it is ProgramResultOk }.accumulator

    private fun run(instructions: List<String>): ProgramResult {
        val seen = mutableListOf<Int>()
        var accumulator = 0
        var index = 0

        while (index < instructions.size) {
            seen.add(index)

            when (instructions[index].take(3)) {
                "acc" -> {
                    accumulator += instructions[index].drop(4).toInt()
                    index++
                }
                "jmp" -> index += instructions[index].drop(4).toInt()
                else -> index++
            }
            if (seen.contains(index)) return ProgramResultFailed(accumulator)
        }
        return ProgramResultOk(accumulator)
    }
}

fun String.toggleInstructionOrNull(): String? = when (this.take(3)) {
    "nop" -> if (this.drop(4).toInt() > 0) this.replace("nop", "jmp") else null
    "jmp" -> this.replace("jmp", "nop")
    else -> null
}

fun <E> Iterable<E>.updated(index: Int, new: E) = mapIndexed { i, existing -> if (i == index) new else existing }

sealed class ProgramResult(val accumulator: Int)
private data class ProgramResultOk(val acc: Int) : ProgramResult(acc)
private data class ProgramResultFailed(val acc: Int) : ProgramResult(acc)
