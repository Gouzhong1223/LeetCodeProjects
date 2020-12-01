package com.leetcode.editor.cn;
//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
//
// 示例 1:
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
//
//
// 示例 2:
//
// 输入: 1->1->1->2->3
//输出: 2->3
// Related Topics 链表
// 👍 403 👎 0

public class P82RemoveDuplicatesFromSortedListIi {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode pre = new ListNode(-1);
            pre.next = head;
            ListNode a = pre;
            ListNode b = head;
            while (b != null && b.next != null) {
                if (a.next.val != b.next.val) {
                    a = a.next;
                } else {
                    while (b != null && b.next != null && a.next.val == b.next.val) {
                        b = b.next;
                    }
                    a.next = b.next;
                }
                b = b.next;
            }
            return pre.next;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            ListNode listNode = new ListNode(1);
            ListNode listNode1 = new ListNode(2);
            ListNode listNode2 = new ListNode(3);
            ListNode listNode3 = new ListNode(3);
            ListNode listNode4 = new ListNode(4);
            ListNode listNode5 = new ListNode(4);
            ListNode listNode6 = new ListNode(5);
            listNode.next = listNode1;
            listNode1.next = listNode2;
            listNode2.next = listNode3;
            listNode3.next = listNode4;
            listNode4.next = listNode5;
            listNode5.next = listNode6;
            ListNode listNode8 = solution.deleteDuplicates(listNode);
            while (listNode8 != null) {
                System.out.println(listNode8.val);
                listNode8 = listNode8.next;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
