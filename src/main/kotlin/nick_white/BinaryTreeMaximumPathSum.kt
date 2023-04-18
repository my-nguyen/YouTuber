package nick_white

fun main() {
    val raws = listOf(
        listOf(intArrayOf(1), intArrayOf(2,3)),
        listOf(intArrayOf(-10), intArrayOf(9,20), intArrayOf(-1,-1,15,7))
    )
    for (raw in raws) {
        val tree = TreeNode.build(raw)
        println("maximum path sum: ${binary_tree_maximum_path_sum_nick(tree)}")
    }
}

var maxSum = Int.MIN_VALUE
fun binary_tree_maximum_path_sum_nick(tree: TreeNode): Int {
    maxGain(tree)
    return maxSum
}

private fun maxGain(node: TreeNode?): Int {
    if (node == null)
        return 0

    val maxLeft = maxOf(0, maxGain(node.left))
    val maxRight = maxOf(0, maxGain(node.right))
    maxSum = maxOf(maxSum, maxLeft + maxRight + node.value)
    return node.value + maxOf(maxLeft, maxRight)
}