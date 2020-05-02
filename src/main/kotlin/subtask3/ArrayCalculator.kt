package subtask3

import java.util.*
import kotlin.Comparator

class ArrayCalculator {

    // TODO: Complete the following function
    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        val filteredArray = itemsFromArray.filterIsInstance<Int>();
        val filteredCount = filteredArray.count()

        if (filteredCount > 0) {
            var sortedList = filteredArray.sortedWith(Comparator.comparingInt(Math::abs)).reversed()
            var result: Int = 1

            if (numberOfItems >= sortedList.size) {
                for (item in sortedList) {
                    result *= item
                }
                return result

            } else {
                //multiple last n numbers
                val positiveNumbers = mutableListOf<Int>()
                for (item in sortedList) {
                    if (item >= 0) {
                        positiveNumbers.add(item)
                    }
                }

                if (positiveNumbers.isEmpty() && (numberOfItems % 2 == 0)) {
                    //all negative and odd number to multiply
                    sortedList = sortedList.reversed()
                }

                var lastNegativeIndex = -1

                for(i in 0 until numberOfItems) {
                    val intToMultiply = sortedList[i]
                    result *= intToMultiply

                    positiveNumbers.remove(intToMultiply) //removed already used
                    if (intToMultiply < 0) {
                        lastNegativeIndex = i
                    }
                }

                if ((result < 0) && (lastNegativeIndex >= 0) && (positiveNumbers.isNotEmpty())) {
                    result = result / sortedList[lastNegativeIndex] * positiveNumbers.first()
                }

                return result
            }
        }
        return 0
    }

}
