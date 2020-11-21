package com.leetcode.editor.cn;
//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
// 进阶：
//
//
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
//
//
//
//
// 示例 1：
//
//
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
//
//
// 示例 2：
//
//
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
//
//
// 示例 3：
//
//
//输入：head = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 5 * 104] 内
// -105 <= Node.val <= 105
//
// Related Topics 排序 链表
// 👍 838 👎 0

public class P148SortList {
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
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode fast = head.next, slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode temp = slow.next;
            slow.next = null;
            ListNode left = sortList(head);
            ListNode right = sortList(temp);
            ListNode h = new ListNode(0);
            ListNode res = h;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    h.next = left;
                    left = left.next;
                } else {
                    h.next = right;
                    right = right.next;
                }
                h = h.next;
            }
            h.next = left != null ? left : right;
            return res.next;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            ListNode listNode = new ListNode(5);
            ListNode listNode1 = new ListNode(-1);
            ListNode listNode2 = new ListNode(4);
            ListNode listNode3 = new ListNode(3);
//            ListNode listNode4 = new ListNode(0);
//            ListNode listNode5 = new ListNode(2);
//            ListNode listNode6 = new ListNode(6);
            listNode.next = listNode1;
            listNode1.next = listNode2;
            listNode2.next = listNode3;
//            listNode3.next = listNode4;
//            listNode4.next = listNode5;
//            listNode5.next = listNode6;

            ListNode list = solution.sortList(listNode);

            for (ListNode p = list; p != null; p = p.next) {
                System.out.println(p.val);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
