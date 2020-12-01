package com.leetcode.editor.cn;
//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
//
// 示例 1:
//
// 输入: 1->1->2
//输出: 1->2
//
//
// 示例 2:
//
// 输入: 1->1->2->3->3
//输出: 1->2->3
// Related Topics 链表
// 👍 433 👎 0

public class P83RemoveDuplicatesFromSortedList {
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
        public ListNode deleteDuplicates(ListNode head) {
            ListNode pre = new ListNode(-1);
            pre.next = head;
            ListNode a = pre;
            ListNode b = head;
            while (b != null && b.next != null) {
                if (a.next.val != b.next.val) {
                    a = a.next;
                    b = b.next;
                } else {
                    while (b != null && b.next != null && a.next.val == b.next.val) {
                        a.next = b.next;
                        b = b.next;
                    }
                }
            }
            return pre.next;
        }

//        public static void main(String[] args) {
//            Solution solution = new Solution();
//            ListNode listNode = new ListNode(1);
//            ListNode listNode1 = new ListNode(2);
//            ListNode listNode2 = new ListNode(3);
//            ListNode listNode3 = new ListNode(3);
//            ListNode listNode4 = new ListNode(4);
//            ListNode listNode5 = new ListNode(4);
//            ListNode listNode6 = new ListNode(5);
//            listNode.next = listNode1;
//            listNode1.next = listNode2;
//            listNode2.next = listNode3;
//            listNode3.next = listNode4;
//            listNode4.next = listNode5;
//            listNode5.next = listNode6;
//            ListNode listNode8 = solution.deleteDuplicates(listNode);
//            while (listNode8 != null) {
//                System.out.println(listNode8.val);
//                listNode8 = listNode8.next;
//            }
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
