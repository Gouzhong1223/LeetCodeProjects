package com.leetcode.editor.cn;
//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
//
// k 是一个正整数，它的值小于或等于链表的长度。
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//
//
//
// 示例：
//
// 给你这个链表：1->2->3->4->5
//
// 当 k = 2 时，应当返回: 2->1->4->3->5
//
// 当 k = 3 时，应当返回: 3->2->1->4->5
//
//
//
// 说明：
//
//
// 你的算法只能使用常数的额外空间。
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
//
// Related Topics 链表
// 👍 784 👎 0

public class P25ReverseNodesInKGroup {
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

        ListNode successor = null;

        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode pre = new ListNode(0);
            pre.next = head;
            int counter = 0;
            while (pre.next != null) {
                counter += 1;
                pre = pre.next;
            }
            if (k == 0 || counter < k) {
                return head;
            }
            for (int i = 1; counter >= k; i = i + k, counter -= k) {
                head = reverseMN(head, i, i + k - 1);
            }
            return head;
        }

        /**
         * 反转链表的 M 到 N
         *
         * @param head 链表
         * @param m    M
         * @param n    N
         * @return 反转之后的链表
         */
        public ListNode reverseMN(ListNode head, int m, int n) {
            if (m == 1) {
                return reverseN(head, n);
            }
            head.next = reverseMN(head.next, m - 1, n - 1);
            successor = null;
            return head;
        }

        /**
         * 反转链表前 N 个元素
         *
         * @param head 链表
         * @param n    N
         * @return 反转之后的链表
         */
        public ListNode reverseN(ListNode head, int n) {
            if (n == 1) {
                successor = head.next;
                return head;
            }
            ListNode last = reverseN(head.next, n - 1);
            head.next.next = head;
            head.next = successor;
            return last;
        }

//        public static void main(String[] args) {
//            Solution solution = new Solution();
//            ListNode listNode = new ListNode(1);
//            ListNode listNode1 = new ListNode(2);
//            ListNode listNode2 = new ListNode(3);
//            ListNode listNode3 = new ListNode(4);
//            ListNode listNode4 = new ListNode(5);
//            ListNode listNode5 = new ListNode(6);
//            ListNode listNode6 = new ListNode(7);
//            ListNode listNode7 = new ListNode(8);
//            listNode.next = listNode1;
//            listNode1.next = listNode2;
//            listNode2.next = listNode3;
//            listNode3.next = listNode4;
//            listNode4.next = listNode5;
//            listNode5.next = listNode6;
//            listNode6.next = listNode7;
//            ListNode listNode8 = solution.reverseKGroup(listNode, 3);
//            for (ListNode l1 = listNode8; l1 != null; l1 = l1.next) {
//                System.out.println(l1.val);
//            }
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
