import kotlin.system.exitProcess

enum class RockPaperScissors(val letter: String, val score: Int, private val beatenBy: Int){
    ROCK("A", 1, 2),
    PAPER("B", 2, 3),
    SCISSORS("C", 3, 1);

    fun score(opponent: Int): Int {
        if (this.score == opponent) { // Draw
            return 3
        } else {
            return if (this.beatenBy == opponent) 0 else 6
        }

    }
}

fun main() {

    fun part1(input: List<String>): Int {
        var totalScore = 0
        input.forEach { line ->
            run {
                val opponent = when(line.substringBefore(" ")) {
                    "A" -> RockPaperScissors.ROCK
                    "B" -> RockPaperScissors.PAPER
                    "C" -> RockPaperScissors.SCISSORS
                    else -> RockPaperScissors.ROCK
                }
                val me = when(line.substringAfter(" ")) {
                    "X" -> RockPaperScissors.ROCK
                    "Y" -> RockPaperScissors.PAPER
                    "Z" -> RockPaperScissors.SCISSORS
                    else -> RockPaperScissors.ROCK
                }

                val shapeScore : Int = me.score

                val outcome = me.score(opponent.score)
                totalScore += (outcome + shapeScore)
            }
        }
        return totalScore
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
