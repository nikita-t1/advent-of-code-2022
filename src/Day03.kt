
fun main() {

    fun part1(input: List<Pair<List<Char>, List<Char>>>): Int {
        var sum = 0
        input.forEach { pair ->
            val firstCompartment = pair.first
            val secondCompartment = pair.second
            val inBoth = firstCompartment.find { it in secondCompartment }!!
            val priority = if (inBoth.isLowerCase()) inBoth.code - 96 else inBoth.code - 38
            sum += priority
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test").map { line ->
        Pair(
            line.substring(0, line.length/2).map { it },
            line.substring(line.length/2).map { it }
        )
    }
    check(part1(testInput) == 157)

    val input = readInput("Day03").map { line ->
        Pair(
            line.substring(0, line.length/2).map { it },
            line.substring(line.length/2).map { it }
        )
    }
    part1(input).println()
//    part2(input).println()
}
