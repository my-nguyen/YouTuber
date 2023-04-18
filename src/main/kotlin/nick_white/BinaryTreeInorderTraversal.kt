package nick_white

import java.util.*

fun main() {
    val raws = listOf(listOf(intArrayOf(1), intArrayOf(-1,2), intArrayOf(-1,-1,3,-1)))
    for (raw in raws) {
        val tree = TreeNode.build(raw)
        println("inorder traversal: ${binary_tree_inorder_traversal_nick(tree)}")
    }
}

fun binary_tree_inorder_traversal_nick(tree: TreeNode) = practice4(tree)

private fun practice1(tree: TreeNode): List<Int> {
    var current: TreeNode? = tree
    val stack = Stack<TreeNode>()
    val result = mutableListOf<Int>()
    while (current != null || stack.isNotEmpty()) {
        while (current != null) {
            stack.push(current)
            current = current.left
        }

        current = stack.pop()
        result.add(current.value)
        current = current.right
    }
    return result
}

private fun practice2(tree: TreeNode): List<Int> {
    var current: TreeNode? = tree
    val result = mutableListOf<Int>()
    val stack = Stack<TreeNode>()
    while (current != null || stack.isNotEmpty()) {
        while (current != null) {
            stack.push(current)
            current = current.left
        }

        current = stack.pop()
        result.add(current.value)
        current = current.right
    }
    return result
}

private fun practice3(tree: TreeNode): List<Int> {
    var current: TreeNode? = tree
    val stack = Stack<TreeNode>()
    val result = mutableListOf<Int>()
    while (current != null || stack.isNotEmpty()) {
        while (current != null) {
            stack.push(current)
            current = current.left
        }

        current = stack.pop()
        result.add(current.value)
        current = current.right
    }
    return result
}

private fun practice4(tree: TreeNode): List<Int> {
    var current: TreeNode? = tree
    val stack = Stack<TreeNode>()
    val result = mutableListOf<Int>()
    while (current != null || stack.isNotEmpty()) {
        while (current != null) {
            stack.push(current)
            current = current.left
        }
        current = stack.pop()
        result.add(current.value)
        current = current.right
    }
    return result
}

fun binary_tree_inorder_traversal(tree: TreeNode): List<Int> {
    val result = mutableListOf<Int>()
    if (tree.left != null)
        result.addAll(binary_tree_inorder_traversal(tree.left!!))
    result.add(tree.value)
    if (tree.right != null)
        result.addAll(binary_tree_inorder_traversal(tree.right!!))
    return result
}