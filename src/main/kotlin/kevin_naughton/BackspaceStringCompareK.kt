package kevin_naughton

import nick_white.backspace_string_compare_nick
import java.util.*

fun main() {
    val s1 = listOf("ab#c", "ab##", "a##c", "a#c")
    val s2 = listOf("ad#c", "c#d#", "#a#c", "b")
    for (i in s1.indices) {
        println("s1: ${s1[i]}, s2: ${s2[i]} => equal? ${backspace_string_compare_nick(s1[i], s2[i])}")
    }
}

fun backspace_string_compare_kevin(s1: String, s2: String): Boolean {
    val stack1 = buildStack(s1)
    val stack2 = buildStack(s2)
    while (stack1.isNotEmpty()) {
        if (stack2.isEmpty() || stack2.pop() != stack1.pop())
            return false
    }
    return stack1.isEmpty() && stack2.isEmpty()
}

private fun buildStack(string: String): Stack<Char> {
    val stack = Stack<Char>()
    for (c in string) {
        if (c != '#')
            stack.push(c)
        else if (stack.isNotEmpty())
            stack.pop()
    }
    return stack
}