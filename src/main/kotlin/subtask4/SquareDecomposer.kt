package subtask4

class SquareDecomposer {

    // TODO: Complete the following function
    fun decomposeNumber(number: Int): Array<Int>? {
        val longNumber = number.toLong()
        var decomposeArray = decomposeNumberAndRemaining(longNumber, longNumber*longNumber)

        if (decomposeArray != null) {
            decomposeArray.remove(decomposeArray.last())
            val decomposeList = mutableListOf<Int>()

            for(item in decomposeArray) {
                val value = item.toInt()
                decomposeList.add(value)
            }
            return decomposeList.toTypedArray()
        }

        return null
    }

        private fun decomposeNumberAndRemaining(current: Long, rest: Long) : MutableList<Long>? {
            if (rest == 0L) {
                val resultList: MutableList<Long> = mutableListOf<Long>()
                resultList.add(current)
                return resultList
            }

            //foreach number less than current
            for (i in  (current - 1).toLong() downTo 0 step 1) {
                if ((rest - i * i) >= 0) {
                    val resultList = decomposeNumberAndRemaining(i, (rest - i * i))
                    if (resultList != null) {
                        resultList.add(current)
                        return resultList
                    }
                }
            }
            return null
    }
}
