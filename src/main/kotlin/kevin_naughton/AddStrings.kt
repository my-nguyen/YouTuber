import java.lang.StringBuilder

fun main() {
    val strings1 = listOf("1234")
    val strings2 = listOf("7656")
    for (i in strings1.indices) {
        println("string1: ${strings1[i]}, string2: ${strings2[i]} => added: ${add_strings(strings1[i], strings2[i])}")
    }
}

fun add_strings(num1: String, num2: String): String {
    var i = num1.lastIndex
    var j = num2.lastIndex
    var carry = 0
    val result = StringBuilder()
    while (i >= 0 || j >= 0) {
        var sum = carry
        if (i >= 0) {
            sum += num1[i] - '0'
            i--
        }
        if (j >= 0) {
            sum += num2[j] - '0'
            j--
        }
        carry = sum / 10
        result.append(sum % 10)
    }
    if (carry == 1)
        result.append(1)
    return result.reverse().toString()
}