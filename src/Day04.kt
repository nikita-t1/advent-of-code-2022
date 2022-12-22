
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
        var count = 0
        val pairs = input.map { line ->
            val firstPairFirst = line.substringBefore(",").substringBefore("-").toInt()
            val firstPairSecond = line.substringBefore(",").substringAfter("-").toInt()
            val secondPairFirst = line.substringAfter(",").substringBefore("-").toInt()
            val secondPairSecond = line.substringAfter(",").substringAfter("-").toInt()

            val firstRange = {
                val list = mutableListOf<Int>()
                for (i in firstPairFirst..firstPairSecond){
                    list.add(i)
                }
                list
            }
            val secondRange = {
                val list = mutableListOf<Int>()
                for (i in secondPairFirst..secondPairSecond){
                    list.add(i)
                }
                list
            }
            if (firstRange().any { it in secondRange() }) {
                count++
            }
        }
        return count
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    part1(input).println()
    part2(input).println()
}
