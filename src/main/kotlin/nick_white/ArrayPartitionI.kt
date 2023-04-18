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

fun array_partition_nick(array: IntArray): Int {
    array.sort()
    var sum = 0
    for (i in 0..array.lastIndex step 2) {
        sum += array[i]
    }
    return sum
}