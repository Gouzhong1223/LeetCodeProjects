package com.leetcode.editor.cn;
//给定一个二叉树，返回所有从根节点到叶子节点的路径。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
// Related Topics 树 深度优先搜索
// 👍 411 👎 0

import java.util.ArrayList;
import java.util.List;

public class P257BinaryTreePaths {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            dfs(root, res, "");
            return res;
        }

        public void dfs(TreeNode root, List<String> res, String path) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                path = path + root.val;
                res.add(path);
            } else {
                path = path + root.val + "->";
                dfs(root.left, res, path);
                dfs(root.right, res, path);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
