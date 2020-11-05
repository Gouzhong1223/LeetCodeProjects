package com.leetcode.editor.cn;
//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
//
//
// 示例 2：
//
//
//输入：head = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 100] 内
// 0 <= Node.val <= 100
//
// Related Topics 链表
// 👍 730 👎 0

public class P24SwapNodesInPairs {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        /**
         * 将 head 的 next 指向 next 节点的 next 节点
         * next 节点的 next 指向 head
         *
         * @param head 传入的链表头结点
         * @return
         */
        public ListNode swapPairs(ListNode head) {
            // 终止条件
            if (head == null || head.next == null) {
                return head;
            }
            // 获取头结点的下一节点
            ListNode next = head.next;
            // 递归
            head.next = swapPairs(next.next);
            // 将 next 节点的下一节点指向头结点
            next.next = head;
            return next;
        }

//        public static void main(String[] args) {
//            Solution solution = new Solution();
//            ListNode listNode = new ListNode(1);
//            ListNode listNode1 = new ListNode(2);
//            ListNode listNode2 = new ListNode(3);
//            ListNode listNode3 = new ListNode(4);
//            ListNode listNode5 = new ListNode(5);
//            listNode.next = listNode1;
//            listNode1.next = listNode2;
//            listNode2.next = listNode3;
//            listNode3.next = listNode5;
//            ListNode listNode4 = solution.swapPairs(listNode);
//
//
//            while (listNode4.next != null) {
//                System.out.println(listNode4.val);
//                listNode4 = listNode4.next;
//            }
//            System.out.println(listNode4.val);
//
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
