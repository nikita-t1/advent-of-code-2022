fun main() {
    fun createColumnsLists(numbers: Int, startingStack: List<String>): List<MutableList<String>> {
        val listOfLists = mutableListOf<MutableList<String>>()
        val list = mutableListOf<String>()
        for (i in 1..(numbers * 4) step 4) {
            startingStack.forEach {
                val letter = it.getOrNull(i)
                if (letter == null) {
                    list.add("")
                } else {
                    list.add(letter.toString().trim())
                }
            }
            val dropEmpty = list.toList().dropWhile { it.isEmpty() }
            val reversedList = dropEmpty.reversed().toMutableList()
            listOfLists.add(reversedList)
            list.clear()
        }
        return listOfLists
    }

    fun moveCrate(fromList: List<String>, toList: MutableList<String>): List<String> {
        val latest = fromList[fromList.size - 1]
        val updatedFromList = fromList.dropLast(1)
        toList.add(latest)
        return updatedFromList
    }

    fun moveCrate9001(fromList: List<String>, toList: MutableList<String>, amountCrates: Int): List<String> {
        val latest = fromList.subList(fromList.size - amountCrates, fromList.size)
        val updatedFromList = fromList.dropLast(amountCrates)
        toList.addAll(latest)
        return updatedFromList
    }


    fun part1(input: List<String>): String {
        val emptyLineIndex = input.lastIndexOf("")
        val numbers = input[emptyLineIndex - 1].last().toString().toInt()
        val rearrangementInstructions =
            input
                .subList(emptyLineIndex + 1, input.size)
                .map { it.split(" ") }
                .map { Triple(it[1].toInt(), it[3].toInt(), it[5].toInt()) }

        val startingStack = input.subList(0, emptyLineIndex - 1)
        val listOfLists = createColumnsLists(numbers, startingStack).toMutableList()

        rearrangementInstructions.forEach { instruction ->
            (1..instruction.first).forEach { _ ->
                val updatedFromList = moveCrate(listOfLists[instruction.second - 1], listOfLists[instruction.third - 1])
                listOfLists[instruction.second - 1] = updatedFromList.toMutableList()
            }
        }


        var string = ""
        listOfLists.forEach {
            string += it[it.size - 1]
        }
        return string
    }

    fun part2(input: List<String>): String {
        val emptyLineIndex = input.lastIndexOf("")
        val numbers = input[emptyLineIndex - 1].last().toString().toInt()
        val rearrangementInstructions =
            input
                .subList(emptyLineIndex + 1, input.size)
                .map { it.split(" ") }
                .map { Triple(it[1].toInt(), it[3].toInt(), it[5].toInt()) }

        val startingStack = input.subList(0, emptyLineIndex - 1)
        val listOfLists = createColumnsLists(numbers, startingStack).toMutableList()

        rearrangementInstructions.forEach { instruction ->
            val updatedFromList = moveCrate9001(listOfLists[instruction.second - 1], listOfLists[instruction.third - 1], instruction.first)
            listOfLists[instruction.second - 1] = updatedFromList.toMutableList()
        }


        var string = ""
        listOfLists.forEach {
            string += it[it.size - 1]
        }
        return string
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part1(testInput) == "CMZ")
    check(part2(testInput) == "MCD")

    val input = readInput("Day05")
    part1(input).println()
    part2(input).println()
}