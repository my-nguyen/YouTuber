import java.lang.StringBuilder

fun main() {
    val a = listOf("11", "1010")
    val b = listOf("1", "1011")
    for (i in a.indices) {
        println("a: ${a[i]}, b: ${b[i]} => sum: ${add_binary_kevin(a[i], b[i])}")
    }
}

fun add_binary_kevin(a: String, b: String): String {
    var i = a.lastIndex
    var j = b.lastIndex
    var carry = 0
    val result = StringBuilder()
    while (i >= 0 || j >= 0) {
        var sum = carry
        if (i >= 0) {
            sum += a[i] - '0'
            i--
        }
        if (j >= 0) {
            sum += b[j] - '0'
            j--
        }
        result.insert(0, sum % 2)
        carry = sum / 2
    }

    if (carry != 0)
        result.insert(0, carry)
    return result.toString()
}