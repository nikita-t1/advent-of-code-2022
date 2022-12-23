fun main() {

    fun part1(input: List<String>): Int {
        for (i in 0..input.size - 4) {
            val areAllDifferent = input.subList(i, i + 4)
            if (areAllDifferent.distinct().size == 4) return i + 4
        }
        return 0
    }

    fun part2(input: List<String>): Int {
        for (i in 0..input.size - 14) {
            val areAllDifferent = input.subList(i, i + 14)
            if (areAllDifferent.distinct().size == 14) return i + 14
        }
        return 0
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
    check(part1(testInput[0].toList().map { it.toString() }) == 5)
    check(part1(testInput[1].toList().map { it.toString() }) == 6)
    check(part1(testInput[2].toList().map { it.toString() }) == 10)
    check(part1(testInput[3].toList().map { it.toString() }) == 11)

    check(part2(testInput[0].toList().map { it.toString() }) == 23)
    check(part2(testInput[1].toList().map { it.toString() }) == 23)
    check(part2(testInput[2].toList().map { it.toString() }) == 29)
    check(part2(testInput[3].toList().map { it.toString() }) == 26)

    val input = readInput("Day06")[0].toList().map { it.toString() }
    part1(input).println()
    part2(input).println()
}