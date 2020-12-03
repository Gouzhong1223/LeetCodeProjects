package com.leetcode.editor.cn;
//给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
// 示例 1:
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
//
// 示例 2:
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
// Related Topics 链表
// 👍 468 👎 0

import java.util.ArrayList;

public class P143ReorderList {
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
        public void reorderList(ListNode head) {
            if (head == null) {
                return;
            }
            ArrayList<ListNode> nodes = new ArrayList<>();
            while (head != null) {
                nodes.add(head);
                head = head.next;
            }
            int i = 0;
            int j = nodes.size() - 1;
            while (i < j) {
                nodes.get(i).next = nodes.get(j);
                i++;
                if (i == j) {
                    break;
                }
                nodes.get(j).next = nodes.get(i);
                j--;
            }
            nodes.get(i).next = null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
