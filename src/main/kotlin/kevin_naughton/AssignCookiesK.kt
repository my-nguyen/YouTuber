package kevin_naughton

fun main() {
    val greeds = listOf(intArrayOf(1,2,3), intArrayOf(1,2))
    val cookies = listOf(intArrayOf(1,1), intArrayOf(1,2,3))
    for (i in greeds.indices) {
        println("greeds: ${greeds[i].contentToString()}, cookies: ${cookies[i].contentToString()} => assignment: ${assign_cookies(greeds[i], cookies[i])}")
    }
}

fun assign_cookies(greeds: IntArray, cookies: IntArray): Int {
    greeds.sort()
    cookies.sort()
    var count = 0
    var i = greeds.lastIndex
    var j = cookies.lastIndex
    while (i >= 0 && j >= 0) {
        if (cookies[j] >= greeds[i]) {
            count++
            j--
        }
        i--
    }
    return count
}