package me.espenschei

object Day7 {
    private const val GOLD_BAG = "shiny gold bag"

    fun first(input: List<String>): Int {
        val bagSpecs = input.map { BagSpec.parseRules(it) }
        return bagSpecs.map { canContainGoldBag(it, bagSpecs) }.count { p -> p }
    }

    private fun canContainGoldBag(bag: BagSpec, bagSpecs: List<BagSpec>): Boolean {
        if (bag.bags.containsKey(GOLD_BAG)) return true

        for (b in bag.bags) {
            if (canContainGoldBag(bagSpecs.find { it.name == b.key }!!, bagSpecs)) return true
        }

        return false
    }
    
    fun second(input: List<String>): Int {
        val bagSpecs = input.map { BagSpec.parseRules(it) }
        return countTotalBags(bagSpecs.find { it.name == GOLD_BAG }!!, bagSpecs) - 1
    }

    private fun countTotalBags(bag: BagSpec, bagSpecs: List<BagSpec>): Int {
        var count = 0

        for (b in bag.bags) {
            count += b.value * countTotalBags(bagSpecs.find { it.name == b.key }!!, bagSpecs)
        }

        return 1 + count
    }

    private data class BagSpec(val name: String, val bags: Map<String, Int>) {
        companion object {
            fun parseRules(rule: String): BagSpec {
                val spec = rule.split("s contain ")
                return BagSpec(
                    spec[0],
                    spec[1].split(", ")
                        .map {
                            if (it != "no other bags.") {
                                val nameWithoutSuffix = it.substring(2)
                                    .removeSuffix("s.")
                                    .removeSuffix("s")
                                    .removeSuffix(".")
                                mapOf(nameWithoutSuffix to it.substring(0, 1).toInt())
                            } else {
                                emptyMap()
                            }

                        }
                        .reduce { a, b -> a.plus(b) })
            }
        }
    }
}
