package nick_white

fun main() {
    val arrays = listOf(intArrayOf(-1,0,3,5,9,12), intArrayOf(-1,0,3,5,9,12))
    val targets = listOf(9, 2)
    for (i in targets.indices) {
        println("array: ${arrays[i].contentToString()}, target: ${targets[i]}, index: ${binary_search(arrays[i], targets[i])}")
    }
}

fun binary_search(array: IntArray, target: Int): Int {
    var i = 0
    var j = array.lastIndex
    while (i < j) {
        val mid = (i + j) / 2
        if (array[mid] < target)
            i = mid + 1
        else if (array[mid] > target)
            j = mid - 1
        else
            return mid
    }
    return -1
}