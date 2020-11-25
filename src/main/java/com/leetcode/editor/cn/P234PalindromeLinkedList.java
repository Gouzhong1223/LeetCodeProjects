package com.leetcode.editor.cn;
//请判断一个链表是否为回文链表。
//
// 示例 1:
//
// 输入: 1->2
//输出: false
//
// 示例 2:
//
// 输入: 1->2->2->1
//输出: true
//
//
// 进阶：
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
// Related Topics 链表 双指针
// 👍 771 👎 0

import java.util.Stack;

public class P234PalindromeLinkedList {
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
        public boolean isPalindrome(ListNode head) {
            ListNode last = null;
            ListNode counter = head;
            // 节点个数
            int count = 0;
            while (counter != null) {
                count++;
                counter = counter.next;
            }
            Stack<Integer> integers = new Stack<>();
            int i;
            if (count % 2 == 0) {
                i = count / 2;
                for (ListNode p = head; i > 0; i--) {
                    integers.push(p.val);
                    last = p.next;
                    p = p.next;
                }
                int j = count / 2;
                for (ListNode p = last; j > 0; j--) {
                    if (integers.pop() != p.val) {
                        return false;
                    }
                    p = p.next;
                }
            } else {
                i = (count - 1) / 2;
                for (ListNode p = head; i > 0; i--) {
                    integers.push(p.val);
                    last = p.next.next;
                    p = p.next;
                }
                int j = (count - 1) / 2;
                for (ListNode p = last; j > 0; j--) {
                    if (integers.pop() != p.val) {
                        return false;
                    }
                    p = p.next;
                }
            }
            return integers.size() == 0;
        }

//
//        public static void main(String[] args) {
//            Solution solution = new Solution();
//            ListNode listNode = new ListNode(1);
//            ListNode listNode1 = new ListNode(2);
//            ListNode listNode2 = new ListNode(2);
//            ListNode listNode3 = new ListNode(1);
//            listNode.next = listNode1;
//            listNode1.next = listNode2;
//            listNode2.next = listNode3;
//            System.out.println(solution.isPalindrome(listNode));
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
