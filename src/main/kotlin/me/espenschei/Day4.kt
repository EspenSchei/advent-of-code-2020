package me.espenschei

object Day4 {
    private val REQ_FIELDS = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

    fun first(passports: List<String>): Int = passports
        .map { passport -> REQ_FIELDS.all { passport.contains(it) } }.count { it }

    fun second(passports: List<String>): Int = passports
        .filter { passport -> REQ_FIELDS.all { passport.contains(it) } }
        .map { passport ->
            val fields = passport.replace("\n", " ").split(" ")
            fields.all { field ->
                val fieldSplit = field.split(":")
                (fieldSplit[0] to fieldSplit[1]).isValid()
            }
        }
        .count { it }

    private fun Pair<String, String>.isValid(): Boolean = when (this.first) {
        "byr" -> this.second.toInt() in 1920..2002
        "iyr" -> this.second.toInt() in 2010..2020
        "eyr" -> this.second.toInt() in 2020..2030
        "hgt" -> this.second.isValidHeight()
        "hcl" -> this.second.isValidHairColor()
        "ecl" -> listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(this.second)
        "pid" -> this.second.length == 9 && this.second.toInt() != -1
        else -> true
    }

    private fun String.isValidHeight(): Boolean = when (this.takeLast(2)) {
        "cm" -> this.length == 5 && this.take(3).toInt() in 150..193
        "in" -> this.length == 4 && this.take(2).toInt() in 59..76
        else -> false
    }

    private fun String.isValidHairColor(): Boolean =
        this.length == 7 &&
                this.startsWith('#') &&
                this.toLowerCase().takeLast(6).toCharArray().all {
                    "abcdef".toCharArray().contains(it) || it.toInt() != -1
                }
}
