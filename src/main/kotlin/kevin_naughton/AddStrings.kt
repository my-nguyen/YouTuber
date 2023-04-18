import java.lang.StringBuilder

// Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
//
// Note:
// 1. The length of both num1 and num2 is < 5100.
// 2. Both num1 and num2 contains only digits 0-9.
// 3. Both num1 and num2 does not contain any leading zero.
// 4. You must not use any built-in BigInteger library or convert the inputs to integer directly.
fun main() {

}

fun add_strings(num1: String, num2: String): String {
    var i = num1.lastIndex
    var j = num2.lastIndex
    var carry = 0
    val result = StringBuilder()
    while (i >= 0 || j >= 0) {
        val d1 = if (i >= 0) num1[i] - '0' else 0
        val d2 = if (j >= 0) num2[j] - '0' else 0
        val sum = d1 + d2 + carry
        carry = sum / 10
        result.append(sum % 10)
        i--
        j--
    }
    if (carry == 1)
        result.append(1)
    return result.reverse().toString()
}