import java.lang.StringBuilder

fun main() {
    val a = listOf("11", "1010")
    val b = listOf("1", "1011")
    for (i in a.indices) {
        println("a: ${a[i]}, b: ${b[i]} => sum: ${add_binary_nick(a[i], b[i])}")
    }
}

fun add_binary_me(a: String, b: String): String {
    val binary1 = a.reversed()
    val binary2 = b.reversed()
    var i = 0
    val result = StringBuilder()
    var carry = 0
    while (i < minOf(binary1.length, binary2.length)) {
        val sum = binary1[i].toString().toInt() + binary2[i].toString().toInt() + carry
        carry = sum / 2
        result.append(sum % 2)
        i++
    }
    while (i < binary1.length) {
        val sum = binary1[i].toString().toInt() + carry
        carry = sum / 2
        result.append(sum % 2)
        i++
    }
    while (i < binary2.length) {
        val sum = binary2[i].toString().toInt() + carry
        carry = sum / 2
        result.append(sum % 2)
        i++
    }
    if (carry == 1)
        result.append(1)
    return result.reverse().toString()
}

fun add_binary_nick(a: String, b: String): String {
    var i = a.lastIndex
    var j = b.lastIndex
    var carry = 0
    val result = StringBuilder()
    while (i >= 0 || j >= 0) {
        val ca = if (i >= 0) a[i] - '0' else 0
        val cb = if (j >= 0) b[j] - '0' else 0
        val sum = ca + cb + carry
        result.append(sum % 2)
        carry = sum / 2
        i--
        j--
    }

    if (carry != 0)
        result.append(carry)
    return result.toString().reversed()
}