package nick_white

fun main() {
    val raws = listOf(listOf(intArrayOf(1), intArrayOf(2,3), intArrayOf(-1,5,-1,-1)))
    for (raw in raws) {
        val tree = TreeNode.build(raw)
        println("binary tree paths: ${binary_tree_paths(tree)}")
    }
}

fun binary_tree_paths(tree: TreeNode): List<List<Int>> {
    val paths = mutableListOf<List<Int>>()
    paths(tree, paths, mutableListOf())
    return paths
}

private fun paths(node: TreeNode, paths: MutableList<List<Int>>, path: MutableList<Int>) {
    if (node.left == null && node.right == null) {
        val current = path.toMutableList()
        current.add(node.value)
        paths.add(current)
        return
    }

    path.add(node.value)
    if (node.left != null)
        paths(node.left!!, paths, path)
    if (node.right != null)
        paths(node.right!!, paths, path)
    path.removeLast()
}