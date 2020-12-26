package com.leetcode.editor.cn;
//给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
//
// 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
//
//
//
// 示例 1：
//输入:
//
//   5
// /  \
//2   -3
//
//
// 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。
//
// 示例 2：
//输入：
//
//   5
// /  \
//2   -5
//
//
// 返回 [2]，只有 2 出现两次，-5 只出现 1 次。
//
//
//
// 提示： 假设任意子树元素和均可以用 32 位有符号整数表示。
// Related Topics 树 哈希表
// 👍 99 👎 0

import java.util.ArrayList;
import java.util.HashMap;

public class P508MostFrequentSubtreeSum {
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
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int max = 0;

        public int[] findFrequentTreeSum(TreeNode root) {
            if (root == null) {
                return new int[]{};
            }
            findSum(root);
            ArrayList<Integer> integers = new ArrayList<>();
            for (Integer integer : hashMap.keySet()) {
                if (hashMap.get(integer) == max) {
                    integers.add(integer);
                }
            }
            int[] res = new int[integers.size()];
            for (int i = 0; i < integers.size(); i++) {
                res[i] = integers.get(i);
            }
            return res;
        }

        public int findSum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = findSum(root.left);
            int right = findSum(root.right);
            int value = root.val + left + right;
            hashMap.put(value, hashMap.getOrDefault(value, 0) + 1);
            max = Math.max(max, hashMap.get(value));
            return value;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
