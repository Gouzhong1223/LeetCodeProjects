package com.leetcode.editor.cn;
//给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
//
// 请你返回该链表所表示数字的 十进制值 。
//
//
//
// 示例 1：
//
//
//
// 输入：head = [1,0,1]
//输出：5
//解释：二进制数 (101) 转化为十进制数 (5)
//
//
// 示例 2：
//
// 输入：head = [0]
//输出：0
//
//
// 示例 3：
//
// 输入：head = [1]
//输出：1
//
//
// 示例 4：
//
// 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
//输出：18880
//
//
// 示例 5：
//
// 输入：head = [0,0]
//输出：0
//
//
//
//
// 提示：
//
//
// 链表不为空。
// 链表的结点总数不超过 30。
// 每个结点的值不是 0 就是 1。
//
// Related Topics 位运算 链表
// 👍 79 👎 0

public class P1290ConvertBinaryNumberInALinkedListToInteger {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int getDecimalValue(ListNode head) {
            ListNode node = reverse(head);
            int counter = 0;
            int res = 0;
            while (node != null) {
                res += node.val * Math.pow(2, counter);
                counter++;
                node = node.next;
            }
            return res;
        }

        public ListNode reverse(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode last = reverse(head.next);
            head.next.next = head;
            head.next = null;
            return last;
        }

//        public static void main(String[] args) {
//            Solution solution = new Solution();
//            ListNode listNode = new ListNode(1);
//            ListNode listNode1 = new ListNode(0);
//            ListNode listNode2 = new ListNode(1);
//            listNode.next = listNode1;
//            listNode1.next = listNode2;
//            int decimalValue = solution.getDecimalValue(listNode);
//            System.out.println(decimalValue);
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
