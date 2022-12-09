import java.io.BufferedReader
import java.io.FileReader


fun main() {
    val fileName = "src/main/resources/puzzle_inputs/day_2.txt"
    val ans: Any = day_2_2(BufferedReader(FileReader(fileName)))
    println("answer is: $ans")
}

fun day_1_1(br: BufferedReader): Any {
    var currentCalories = 0
    var maxCalories = 0
    var line: String?
    while (br.readLine().also { line = it } != null) {
        if(line!!.isEmpty()){
            currentCalories = 0
            continue
        }

        currentCalories += line!!.toInt()
        if(currentCalories > maxCalories) {
            maxCalories = currentCalories
        }
    }

    return maxCalories
}

fun day_1_2(br: BufferedReader): Any {
    val calorieList = mutableListOf<Int>()
    var currentCalories = 0
    var line: String?
    while (br.readLine().also { line = it } != null) {
        if(line!!.isEmpty()){
            calorieList.add(currentCalories)
            currentCalories = 0
            continue
        }

        currentCalories += line!!.toInt()
    }

    calorieList.sortDescending()

    return calorieList[0] + calorieList[1] + calorieList[2]
}

fun day_2_1(br: BufferedReader): Any {
    // A,X = ROCK
    // B,Y = PAPER
    // C,Z = SCISSORS
    var totalScore = 0
    var line: String?
    while (br.readLine().also { line = it } != null) {
        val gameInputs = line!!.split(" ")
        val opponentChoice = gameInputs[0]
        val yourChoice = gameInputs[1]

        totalScore += when (yourChoice) {
            "X" -> 1
            "Y" -> 2
            "Z" -> 3
            else -> 0
        }

        if(opponentChoice == "A" && yourChoice == "X" || opponentChoice == "B" && yourChoice == "Y" || opponentChoice == "C" && yourChoice == "Z") {
            totalScore += 3
        } else if (opponentChoice == "A" && yourChoice == "Y" || opponentChoice == "B" && yourChoice == "Z" || opponentChoice == "C" && yourChoice == "X") {
            totalScore += 6
        }

    }

    return totalScore
}

fun day_2_2(br: BufferedReader): Any {
    // A = ROCK
    // B = PAPER
    // C = SCISSORS
    // X = LOSE
    // Y = DRAW
    // Z = WIN
    var totalScore = 0
    var line: String?
    while (br.readLine().also { line = it } != null) {
        val gameInputs = line!!.split(" ")
        val opponentChoice = gameInputs[0]
        val yourChoice: String = when(gameInputs[1]) {
            "Y" -> opponentChoice
            "X" -> when(opponentChoice) {
                "A" -> "C"
                "B" -> "A"
                "C" -> "B"
                else -> ""
            }
            "Z" -> when(opponentChoice) {
                "A" -> "B"
                "B" -> "C"
                "C" -> "A"
                else -> ""
            }
            else -> ""
        }

        totalScore += when (yourChoice) {
            "A" -> 1
            "B" -> 2
            "C" -> 3
            else -> 0
        }

        if(opponentChoice == yourChoice) {
            totalScore += 3
        } else if (opponentChoice == "A" && yourChoice == "B" || opponentChoice == "B" && yourChoice == "C" || opponentChoice == "C" && yourChoice == "A") {
            totalScore += 6
        }

    }

    return totalScore
}
