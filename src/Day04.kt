
fun main() {
    fun part1(input: List<String>): Int {
        var count = 0
        val pairs = input.map { line ->
            Pair(
                Pair(
                    line.substringBefore(",").substringBefore("-").toInt(),
                    line.substringBefore(",").substringAfter("-").toInt()
                ),
                Pair(
                    line.substringAfter(",").substringBefore("-").toInt(),
                    line.substringAfter(",").substringAfter("-").toInt()
                )
            )
        }
        pairs.forEach {
            val secondFitsInFirst = it.first.first <= it.second.first && it.first.second >= it.second.second
            val firstFitsInSecond = it.second.first <= it.first.first && it.second.second >= it.first.second
            if (secondFitsInFirst || firstFitsInSecond){
                it.println()
                count++
            }
        }
        count.println()
        return count
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)

    val input = readInput("Day04")
    part1(input).println()
    part2(input).println()
}
