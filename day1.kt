/* Trebuchet */
import java.io.*

fun main() {
  val reader = BufferedReader(FileReader("input1.txt"))
  var calibration = 0
  do {
    val line = reader.readLine()
    if (line == null) break
    calibration += firstAndLastDigits(line) ?: continue
  } while (true)
  println(calibration)
}

fun firstAndLastDigits(line: String): Int? =
  line.asIterable().filter { it.isDigit() }.let {
    it.first().digitToInt() * 10 + it.last().digitToInt()
  }

