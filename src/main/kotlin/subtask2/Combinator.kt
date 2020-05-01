package subtask2

class Combinator {

    // TODO: Complete the following function
    fun checkChooseFromArray(array: Array<Int>): Int? {
        val countItems = array.count()
        if (countItems == 2) {
            //find combination
            val allColorsCount = array[1]
            val requiredCombinations = array[0]

            if ((allColorsCount < 1) || (requiredCombinations < 1)) {
                return null;
            }

            //for all variants
            var optimalColorCount = 0

            for(i in 1 until allColorsCount) {
                val result = combinationNumberChoose(allColorsCount, i)
                if ((result == requiredCombinations) && ((optimalColorCount > i) || (optimalColorCount == 0))) {
                    optimalColorCount = i
                }
            }

            return if (optimalColorCount < 1) null else optimalColorCount;
        }
        return null
    }

    private fun combinationNumberChoose(n: Int, x: Int): Int {
        if (x == 1) {
            return n
        }
        if (x == n) {
            return 1
        }
        return combinationNumberChoose((n - 1), x) + combinationNumberChoose((n - 1), (x - 1))
    }
}
