// Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
//
// Example 1:
// Input: [1,4,3,2]
// Output: 4
// Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
//
// Note:
// * n is a positive integer, which is in the range of [1, 10000].
// * All the integers in the array will be in the range of [-10000, 10000].
fun main() {
    val arrays = listOf(intArrayOf(1,4,3,2))
    for (array in arrays) {
        println("array: ${array.contentToString()} => max sum of mins: ${array_partition(array)}")
    }
}

fun array_partition(array: IntArray): Int {
    array.sort()
    var sum = 0
    for (i in 0..array.lastIndex step 2) {
        sum = minOf(array[i], array[i+1])
    }
    return sum
}