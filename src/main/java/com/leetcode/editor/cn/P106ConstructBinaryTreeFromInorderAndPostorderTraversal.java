package com.leetcode.editor.cn;
//根据一棵树的中序遍历与后序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 中序遍历 inorder = [9,3,15,20,7]
// 后序遍历 postorder = [9,15,7,20,3]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// Related Topics 树 深度优先搜索 数组
// 👍 409 👎 0

public class P106ConstructBinaryTreeFromInorderAndPostorderTraversal {
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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }

        private TreeNode build(int[] inorder, int inOrderStart, int inOrderEnd, int[] postorder, int postOrderStart, int postOrderEnd) {
            if (inOrderStart > inOrderEnd) {
                return null;
            }
            TreeNode root = new TreeNode(postorder[postOrderEnd]);
            int index = 0;
            // 找到中序遍历的 root 节点索引
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == root.val) {
                    index = i;
                    break;
                }
            }
            int leftSize = index - inOrderStart;
            root.left = build(inorder, inOrderStart, index - 1,
                    postorder, postOrderStart, postOrderStart + leftSize - 1);

            root.right = build(inorder, index + 1, inOrderEnd,
                    postorder, postOrderStart + leftSize, postOrderEnd - 1);

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
