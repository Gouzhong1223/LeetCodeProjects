package com.leetcode.editor.cn;
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
// Related Topics 链表
// 👍 1356 👎 0

public class P21MergeTwoSortedLists {
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
    static class Solution {
        public static void main(String[] args) {
            Solution solution = new Solution();
            ListNode listNode = new ListNode(1);
            listNode.next = new ListNode(2);

            ListNode listNode1 = new ListNode(2);
            listNode1.next = new ListNode(3);
            ListNode result = solution.mergeTwoLists(listNode, listNode1);

            while (result.next != null) {
                System.out.println(result.val);
                result = result.next;
            }
            System.out.println(result.val);
        }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }

            if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
