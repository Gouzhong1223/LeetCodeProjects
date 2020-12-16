package com.leetcode.editor.cn;
//给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
//
// 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
//。
//
// 示例 1:
//
//
//输入:
//	Tree 1                     Tree 2
//          1                         2
//         / \                       / \
//        3   2                     1   3
//       /                           \   \
//      5                             4   7
//输出:
//合并后的树:
//	     3
//	    / \
//	   4   5
//	  / \   \
//	 5   4   7
//
//
// 注意: 合并必须从两个树的根节点开始。
// Related Topics 树
// 👍 585 👎 0

public class P617MergeTwoBinaryTrees {
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
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) {
                return null;
            }
            TreeNode root = new TreeNode(0);
            if (t1 != null) {
                root.val += t1.val;
            }
            if (t2 != null) {
                root.val += t2.val;
            }
            root.left = mergeTrees(t1 != null ? t1.left : null, t2 != null ? t2.left : null);
            root.right = mergeTrees(t1 != null ? t1.right : null, t2 != null ? t2.right : null);
            return root;
        }

//        public static void main(String[] args) {
//            Solution solution = new Solution();
//            TreeNode treeNode = new TreeNode(1);
//            TreeNode treeNode1 = new TreeNode(3);
//            TreeNode treeNode2 = new TreeNode(2);
//            TreeNode treeNode3 = new TreeNode(5);
//
//            treeNode.left = treeNode1;
//            treeNode.right = treeNode2;
//            treeNode1.left = treeNode3;
//
//            TreeNode treeNode4 = new TreeNode(2);
//            TreeNode treeNode5 = new TreeNode(1);
//            TreeNode treeNode6 = new TreeNode(3);
//            TreeNode treeNode7 = new TreeNode(4);
//            TreeNode treeNode8 = new TreeNode(7);
//
//            treeNode4.left = treeNode5;
//            treeNode4.right = treeNode6;
//
//            treeNode5.right = treeNode7;
//            treeNode6.right = treeNode8;
//            TreeNode node = solution.mergeTrees(treeNode, treeNode4);
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
