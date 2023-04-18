package p9_tree_depth_first_search

data class TreeNode(val value: Int, var left: TreeNode? = null, var right: TreeNode? = null) {
    var next: TreeNode? = null

    override fun toString(): String {
        return "$value, left: ${if (left == null) null else left!!.value}, right: ${if (right == null) null else right!!.value}"
    }

    companion object {
        fun build(lists: List<IntArray>): TreeNode {
            val head = TreeNode(lists[0][0])

            if (lists.size > 1) {
                head.left = build(lists[1][0])
                head.right = build(lists[1][1])

                if (lists.size > 2) {
                    head.left?.left = build(lists[2][0])
                    head.left?.right = build(lists[2][1])
                    head.right?.left = build(lists[2][2])
                    head.right?.right = build(lists[2][3])

                    if (lists.size > 3) {
                        head.left?.left?.left = build(lists[3][0])
                        head.left?.left?.right = build(lists[3][1])
                        head.left?.right?.left = build(lists[3][2])
                        head.left?.right?.right = build(lists[3][3])
                        head.right?.left?.left = build(lists[3][4])
                        head.right?.left?.right = build(lists[3][5])
                        head.right?.right?.left = build(lists[3][6])
                        head.right?.right?.right = build(lists[3][7])
                    }
                }
            }

            return head
        }

        private fun build(value: Int) = if (value == -1) null else TreeNode(value)
    }
}