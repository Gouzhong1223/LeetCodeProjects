package com.leetcode.editor.cn;
//给你一个链表数组，每个链表都已经按升序排列。
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。
//
//
//
// 示例 1：
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
//
//
// 示例 2：
//
// 输入：lists = []
//输出：[]
//
//
// 示例 3：
//
// 输入：lists = [[]]
//输出：[]
//
//
//
//
// 提示：
//
//
// k == lists.length
// 0 <= k <= 10^4
// 0 <= lists[i].length <= 500
// -10^4 <= lists[i][j] <= 10^4
// lists[i] 按 升序 排列
// lists[i].length 的总和不超过 10^4
//
// Related Topics 堆 链表 分治算法
// 👍 980 👎 0

public class P23MergeKSortedLists {
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
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            return merage(lists, 0, lists.length - 1);

        }

        public ListNode merage(ListNode[] lists, int left, int right) {
            if (left == right) {
                return lists[left];
            }
            int mid = (left + right) / 2;
            ListNode l = merage(lists, left, mid);
            ListNode r = merage(lists, mid + 1, right);
            return merageTwo(l, r);
        }

        /**
         * 合并两个链表
         *
         * @param l1
         * @param l2
         * @return
         */
        public ListNode merageTwo(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            if (l1.val < l2.val) {
                l1.next = merageTwo(l1.next, l2);
                return l1;
            } else {
                l2.next = merageTwo(l1, l2.next);
                return l2;
            }
        }


        public static void main(String[] args) {
            Solution solution = new Solution();
            ListNode[] listNodes = new ListNode[3];
            ListNode listNode = new ListNode(1);
            ListNode listNode2 = new ListNode(4);
            listNode.next = listNode2;
            listNode2.next = new ListNode(5);

            ListNode listNode4 = new ListNode(1);
            ListNode listNode5 = new ListNode(3);
            listNode4.next = listNode5;
            listNode5.next = new ListNode(4);

            ListNode listNode7 = new ListNode(2);
            listNode7.next = new ListNode(6);
            listNodes[0] = listNode;
            listNodes[1] = listNode4;
            listNodes[2] = listNode7;

            ListNode listNode1 = solution.mergeKLists(listNodes);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
