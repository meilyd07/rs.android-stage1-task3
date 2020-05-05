package subtask6

import java.lang.StringBuilder

class FullBinaryTrees {

    // TODO: Complete the following function
    private var nodesDictionary: HashMap<Int, Array<Any?>> = hashMapOf()

    fun stringForNodeCount(count: Int): String {
        return binaryToString(count)
    }

    private fun binaryToString (count: Int): String {
        val inputArray = arrayOfPossibleFBT(count)

        var resultString = "["
        val countTrees = inputArray?.size ?: return ""

        for (i in 0 until countTrees) {
            resultString += "["

            val arrayItem = inputArray[i]
            val castArray = arrayItem as Array<*>
            val item = castArray[0]
            if (item is Int) {
                if (item.toInt() == 0) {
                    resultString += "0"
                }
            }

            val secondItem = castArray[1]
            if (secondItem != null) {//left
                resultString += ",0,0" // 2 or null children

                for (s in 1..2) {
                    val castArrayItem = castArray[s]
                    val innerArray = castArrayItem as Array<*>

                    for (j in 1..2) {
                        if (innerArray[j] == null) {
                            resultString += ",null"
                        } else {
                            resultString += ",0"
                        }
                    }

                    for (m in 1..2) {
                        if (innerArray[m] != null) {
                            for (k in 1..2) {

                                val castInnerArray = innerArray[m] as Array<*>
                                if (castInnerArray[k] == null) {//left
                                    resultString += ",null"
                                } else {
                                    resultString += ",0"
                                }
                            }
                        }
                    }

                    for (n in 1..2) {
                        if (innerArray[n] != null) {
                            for (d in 1..2) {

                                val castInnerArray = innerArray[n] as Array<*>
                                if (castInnerArray[d] != null) {
                                    for (c in 1..2) {
                                        val mostInnerArray = castInnerArray[d] as Array<*>

                                        if (mostInnerArray[c] == null) {
                                            resultString += ",null"
                                        } else {
                                            resultString += ",0"
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            val lastIndex = resultString.lastIndexOf("0")
            if (lastIndex >= 0) {
                resultString = resultString.substring(0, lastIndex + 1)
            }

            resultString += "]"
        }
        resultString += "]"
        return resultString
    }

    private fun arrayOfPossibleFBT(countNodes: Int): Array<Any?>? {
        if (!nodesDictionary.containsKey(countNodes)) {
            var possible = arrayOf<Any?>()
            if (countNodes == 1) {
                val treeNode: Array<Any?> = arrayOf(0, null, null)
                val copyArray = possible.copyOf(1)
                copyArray[0] = treeNode
                possible = copyArray
            } else if (countNodes % 2 == 1) {
                for (x in 0 until countNodes) {
                    val y = countNodes - 1 - x
                    val left = arrayOfPossibleFBT(x)
                    val right = arrayOfPossibleFBT(y)

                    if (left != null) {
                        for (l in left) {
                            if (right != null) {
                                for (r in right) {
                                    val node: Array<Any?> = arrayOf(0, l, r)
                                    val copyArray = possible.copyOf(possible.size + 1)
                                    copyArray[possible.size] = node
                                    possible = copyArray
                                }
                            }
                        }
                    }
                }
            }
            nodesDictionary[countNodes] = possible

        }
        return nodesDictionary[countNodes]
    }
}
