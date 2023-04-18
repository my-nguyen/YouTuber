package nick_white

import java.util.*

fun main() {
    val s1 = listOf("ab#c", "ab##", "a##c", "a#c")
    val s2 = listOf("ad#c", "c#d#", "#a#c", "b")
    for (i in s1.indices) {
        println("s1: ${s1[i]}, s2: ${s2[i]} => equal? ${backspace_string_compare_nick(s1[i], s2[i])}")
    }
}

fun backspace_string_compare_nick(s1: String, s2: String): Boolean {
    var i = s1.lastIndex
    var j = s2.lastIndex
    var skips1 = 0
    var skips2 = 0
    while (i >= 0 || j >= 0) {
        while (i >= 0) {
            if (s1[i] == '#') {
                skips1++
                i--
            } else {
                if (skips1 > 0) {
                    skips1--
                    i--
                } else
                    break
            }
        }

        while (j >= 0) {
            if (s2[j] == '#') {
                skips2++
                j--
            } else {
                if (skips2 > 0) {
                    skips2--
                    j--
                } else
                    break
            }
        }

        if (i >= 0 && j >= 0 && s1[i] != s2[j])
            return false
        if (i != j)
            return false

        i--
        j--
    }
    return true
}

fun backspace_string_compare(s1: String, s2: String) = process(s1) == process(s2)

private fun process(string: String): String {
    val stack = Stack<Char>()
    for (c in string) {
        if (c == '#') {
            if (stack.isNotEmpty())
                stack.pop()
        } else
            stack.push(c)
    }
    return stack.toString()
}