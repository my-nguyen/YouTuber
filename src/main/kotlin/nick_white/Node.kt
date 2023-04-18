data class Node(val value: Int = 0, var next: Node? = null) {
    override fun toString(): String {
        // return "$value -> ${if (next == null) null else next!!.value }"
        return "$value"
    }

    companion object {
        fun build(array: IntArray): Node {
            var head = Node(array.last())
            for (i in array.lastIndex - 1 downTo 0) {
                head = Node(array[i], head)
            }
            return head
        }

        fun toArray(head: Node): List<Int> {
            var node: Node? = head
            val result = mutableListOf<Int>()
            while (node != null) {
                result.add(node.value)
                node = node.next
            }
            return result
        }

        fun reverse(head: Node): Node? {
            var previous: Node? = null
            var next: Node? = head
            while (next != null) {
                val tmp = next.next
                next.next = previous
                previous = next
                next = tmp
            }
            return previous
        }

        fun middle(head: Node): Node {
            var slow = head
            var fast: Node? = head
            // while (fast != null && fast.next != null) {
            while (fast?.next != null) {
                fast = fast.next!!.next
                slow = slow.next!!
            }
            return slow
        }
    }
}