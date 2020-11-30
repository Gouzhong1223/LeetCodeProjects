package com.leetcode.editor.cn;
//给出一个完全二叉树，求出该树的节点个数。
//
// 说明：
//
// 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为
//第 h 层，则该层包含 1~ 2h 个节点。
//
// 示例:
//
// 输入:
//    1
//   / \
//  2   3
// / \  /
//4  5 6
//
//输出: 6
// Related Topics 树 二分查找
// 👍 343 👎 0

import java.util.concurrent.CopyOnWriteArrayList;

public class P222CountCompleteTreeNodes {
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
        public int countNodes(TreeNode root) {
            CopyOnWriteArrayList<Integer> integers = new CopyOnWriteArrayList<>();
            integers.add(1);
            integers.get(0);
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
