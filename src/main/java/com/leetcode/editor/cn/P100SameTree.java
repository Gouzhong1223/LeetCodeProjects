package com.leetcode.editor.cn;
//给定两个二叉树，编写一个函数来检验它们是否相同。
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
//
// 示例 1:
//
// 输入:       1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//输出: true
//
// 示例 2:
//
// 输入:      1          1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//输出: false
//
//
// 示例 3:
//
// 输入:       1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//输出: false
//
// Related Topics 树 深度优先搜索
// 👍 504 👎 0

public class P100SameTree {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            return bfs(p, q);
        }

        /**
         * 比较两个节点的左右节点的 val 是否相等
         *
         * @param p 左节点
         * @param q 右节点
         * @return 如果相等则返回 true ，如果不相等则返回 false
         */
        private boolean bfs(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p != null && q != null) {
                if (p.val != q.val) {
                    return false;
                }
                // 将左右节点各自的左节点再次比较
                // 将左右节点各自的右节点再次比较
                return bfs(p.left, q.left) && bfs(p.right, q.right);
            }
            return false;
        }

//        public static void main(String[] args) {
//            Solution solution = new Solution();
//            TreeNode treeNode = new TreeNode(1);
//            treeNode.left = new TreeNode(2);
//            treeNode.right = new TreeNode(3);
//
//            System.out.println(solution.isSameTree(treeNode, treeNode));
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
