fun main() {
    fun part1(input: List<String>): Int {
        val caloriesList = mutableListOf<Int>()
        var currentElfCalories = 0
        input.forEach { line ->
            run {
                if (line.isBlank()) {
                    caloriesList.add(currentElfCalories)
                    currentElfCalories = 0
                } else {
                    currentElfCalories += line.toInt()
                }
            }
        }
        return caloriesList.maxOf { it }
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
