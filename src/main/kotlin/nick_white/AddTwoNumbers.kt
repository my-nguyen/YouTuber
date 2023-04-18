fun main() {
    val arrays1 = listOf(intArrayOf(2,4,3), intArrayOf(1,0,1,1), intArrayOf(6,8,7))
    val arrays2 = listOf(intArrayOf(5,6,4), intArrayOf(2,1,1,5), intArrayOf(4,1,1))
    for (i in arrays1.indices) {
        val root1 = Node.build(arrays1[i])
        val root2 = Node.build(arrays2[i])
        val sum = add_two_numbers(root1, root2)
        val array = Node.toArray(sum)
        println("list1: ${arrays1[i].contentToString()}, list2: ${arrays2[i].contentToString()} => sum: $array")
    }
}

fun add_two_numbers(root1: Node, root2: Node): Node {
    var current1: Node? = root1
    var current2: Node? = root2
    var result = Node()
    val dummy = result
    var carry = 0
    while (current1 != null || current2 != null) {
        var sum = carry
        if (current1 != null) {
            sum += current1.value
            current1 = current1.next
        }
        if (current2 != null) {
            sum += current2.value
            current2 = current2.next
        }
        carry = sum / 10
        result.next = Node(sum % 10)
        result = result.next!!
    }
    return dummy.next!!
}
