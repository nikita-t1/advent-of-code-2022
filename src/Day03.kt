
fun main() {

    fun part1(input: List<String>): Int {
        val list = input.map { line ->
            Pair(
                line.substring(0, line.length / 2).map { it },
                line.substring(line.length / 2).map { it }
            )
        }
        var sum = 0
        list.forEach { pair ->
            val firstCompartment = pair.first
            val secondCompartment = pair.second
            val inBoth = firstCompartment.find { it in secondCompartment }!!
            val priority = if (inBoth.isLowerCase()) inBoth.code - 96 else inBoth.code - 38
            sum += priority
        }
        return sum
    }

    fun part2(input: List<String>): Int {

        var prioritySum = 0

        val currentSet: MutableList<String> = mutableListOf()
        input.forEachIndexed { index, item ->
            run {
                if (((index + 1) % 3) == 0) {
                    currentSet.add(item)

                    val first: List<Char> = currentSet[0].map { it }
                    val second: List<Char> = currentSet[1].map { it }
                    val third: List<Char> = currentSet[2].map { it }
                    val match = first.find { it in second && it in third }!!
                    val priority = if (match.isLowerCase()) match.code - 96 else match.code - 38
                    prioritySum += priority

                    currentSet.clear()
                } else {
                    currentSet.add(item)
                }
            }
        }
        return prioritySum
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)

    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}
