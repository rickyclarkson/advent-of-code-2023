/* Trebuchet */
import java.io.*

fun main() {
  val reader = BufferedReader(FileReader("input1.txt"))
  var calibration = 0
  do {
    val line = reader.readLine()
    if (line == null) break
    calibration += (calibrationBeginning(line) ?: continue) * 10
    calibration += calibrationEnding(line) ?: continue
  } while (true)
  println(calibration)
}

fun calibrationBeginning(line: String): Int? {
  for (x in 0..<line.length) {
    if (line[x].isDigit()) return line[x].digitToInt()
    for ((word, digit) in wordDigitPairs) {
      if (line.substring(x).startsWith(word)) return digit
    }
  }
  return null
}

fun calibrationEnding(line: String): Int? {
  for (x in line.length - 1 downTo 0) {
    if (line[x].isDigit()) return line[x].digitToInt()
    for ((word, digit) in wordDigitPairs) {
      if (line.substring(x).startsWith(word)) return digit
    }
  }
  return null
}

val wordDigitPairs = listOf("one" to 1, "two" to 2, "three" to 3, "four" to 4, "five" to 5, "six" to 6, "seven" to 7, "eight" to 8, "nine" to 9)
