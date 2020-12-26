package com.leetcode.editor.cn;
//给定一个二叉树，它的每个结点都存放着一个整数值。
//
// 找出路径和等于给定数值的路径总数。
//
// 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
//
// 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
//
// 示例：
//
// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//返回 3。和等于 8 的路径有:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
//
// Related Topics 树
// 👍 692 👎 0

import java.util.HashMap;

public class P437PathSumIii {
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
        public int pathSum(TreeNode root, int sum) {
            HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
            prefixSumCount.put(0, 1);
            return recursionPathSum(root, prefixSumCount, sum, 0);
        }

        public int recursionPathSum(TreeNode root, HashMap<Integer, Integer> prefixSumCount, int target, int currSum) {
            if (root == null) {
                return 0;
            }
            int res = 0;
            currSum += root.val;
            res += prefixSumCount.getOrDefault(currSum - target, 0);
            prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);
            res += recursionPathSum(root.left, prefixSumCount, target, currSum);
            res += recursionPathSum(root.right, prefixSumCount, target, currSum);
            prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
