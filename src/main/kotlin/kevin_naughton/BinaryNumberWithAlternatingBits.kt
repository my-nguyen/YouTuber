fun main() {
    val numbers = listOf(5, 7, 11, 10)
    for (number in numbers) {
        println("number $number, is alternating bits? ${binary_number_with_alternating_bits_kevin(number)}")
    }
}

fun binary_number_with_alternating_bits_kevin(binary: Int): Boolean {
    var last = binary % 2
    var current = binary shr 1
    while (current != 0) {
        val tmp = current % 2
        if (tmp == last)
            return false
        last = tmp
        current = current shr 1
    }
    return true
}

fun binary_number_with_alternating_bits(binary: Int): Boolean {
    val string = binary.toString(2)
//    val string = toBinaryString(binary)
    var current = string[0] - '0'
    for (i in 1..string.lastIndex) {
        current = (current + 1) % 2
        if (string[i] - '0' != current)
            return false
    }
    return true
}

private fun toBinaryString(number: Int): String {
    var current = number
    val string = StringBuilder()
    while (current != 0) {
        string.insert(0, current % 2)
        current /= 2
    }
    return string.toString()
}