package subtask5

import kotlin.reflect.KClass

class TelephoneFinder {

    // TODO: Complete the following function
    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        if (number.toInt() < 0) {
            return null
        }

        val map: HashMap<Char, Array<Int>> = hashMapOf(
            '0' to arrayOf(8),
            '1' to arrayOf(2, 4),
            '2' to arrayOf(1, 3, 5),
            '3' to arrayOf(2, 6),
            '4' to arrayOf(1, 5, 7),
            '5' to arrayOf(2, 4, 6, 8),
            '6' to arrayOf(3, 5, 9),
            '7' to arrayOf(4, 8),
            '8' to arrayOf(5, 7, 9, 0),
            '9' to arrayOf(6, 8)
        )

        val resultList = mutableListOf<String>()
        for(i in number.indices) {
            val iChar = number[i]

            //find array in dictionary
            if (map.containsKey(iChar)) {
                val arrayDict = map.get(iChar)

                for (j in arrayDict!!.indices) {
                    val phoneString = number.replaceRange(i, i + 1, arrayDict[j].toString())
                    resultList.add(phoneString)
                }
            }
        }
        return resultList.toTypedArray()
    }
}
