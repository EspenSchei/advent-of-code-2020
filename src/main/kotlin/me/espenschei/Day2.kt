package me.espenschei

object Day2 {
    fun first(lines: List<String>): Int = lines.filter { line ->
        val policy = line.split(":")[0]
        val password = line.split(":")[1]

        val minCount = policy.split("-")[0].toInt()
        val maxCount = policy.split("-")[1].dropLast(2).toInt()

        val actualCount = password.count { it == policy.last() }

        actualCount in minCount..maxCount
    }.count()

    fun second(lines: List<String>): Int = lines.filter { line ->
        val policy = line.split(":")[0]
        val password = line.split(":")[1]

        val firstOption = policy.split("-")[0].toInt()
        val secondOption = policy.split("-")[1].dropLast(2).toInt()
        val characterToMatch = policy.last()

        val firstIsMatch = password[firstOption] == characterToMatch
        val secondIsMatch = password[secondOption] == characterToMatch

        firstIsMatch != secondIsMatch
    }.count()

}
