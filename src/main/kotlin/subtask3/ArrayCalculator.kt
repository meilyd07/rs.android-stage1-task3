package subtask3

import java.util.*
import kotlin.Comparator

class ArrayCalculator {

    // TODO: Complete the following function
    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        val filteredArray = itemsFromArray.filterIsInstance<Int>();
        val filteredCount = filteredArray.count()

        if (filteredCount > 0) {
            val sortedArray = Arrays.sort(filteredArray.toTypedArray(), Comparator.comparingInt(Math::abs));
            var result: Int = 1

            if (numberOfItems >= (sortedArray as Array<Int>).size) {
                for (item in sortedArray) {
                    result *= item
                }
                return result
            } else {
                //multiple last n numbers
                val positiveNumbers = (sortedArray.filter { e -> e >= 0 }).toMutableList()
                if (positiveNumbers.isEmpty() && (numberOfItems % 2 == 0)) {
                    //all negative and odd number to multiply
                    sortedArray.reverse()
                }

                var lastNegativeIndex = -1

                for(i in 0 until numberOfItems) {
                    val intToMultiply = sortedArray[i]
                    result *= intToMultiply

                    positiveNumbers.remove(intToMultiply) //removed already used
                    if (intToMultiply < 0) {
                        lastNegativeIndex = i
                    }
                }

                if ((result < 0) && (lastNegativeIndex >= 0) && (positiveNumbers.isNotEmpty())) {
                    result = result / sortedArray[lastNegativeIndex] * positiveNumbers.first()
                }

                return result
            }
        }
        return 0
    }

}
