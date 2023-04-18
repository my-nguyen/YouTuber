package nick_white

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
    var i = 0
    var j = 0
    while (i < greeds.size && j < cookies.size) {
        if (greeds[i] <= cookies[j])
            i++
        j++
    }
    return i
}