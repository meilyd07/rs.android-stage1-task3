package subtask1

import java.lang.StringBuilder
import kotlin.math.abs

class PolynomialConverter {

    // TODO: Complete the following function
    fun convertToStringFrom(numbers: Array<Int>): String? {
        val countItems = numbers.count()
        if (countItems == 0) return null

        val resultString: StringBuilder = StringBuilder()
        for(i in 0 until countItems){
            val currentInt = numbers[i]
            val absCurrentInt = abs(currentInt)
            val currentDegree = countItems - i - 1

            if (currentInt != 0) {
                resultString.append(if (currentInt > 0) (if (currentDegree == countItems - 1) "" else " + ") else (if (currentDegree == countItems - 1) "-" else " - "))
                resultString.append(if ((currentDegree == 0) || ((currentDegree > 0) && (absCurrentInt != 1))) absCurrentInt else "")
                resultString.append(if (currentDegree > 0) "x" else "")
                resultString.append(if (currentDegree > 1) "^$currentDegree" else "")
            }
        }

        return resultString.toString()
    }
}
