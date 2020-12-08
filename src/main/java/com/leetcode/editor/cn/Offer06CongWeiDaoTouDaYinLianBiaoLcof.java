package com.leetcode.editor.cn;
//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
//
//
// 示例 1：
//
// 输入：head = [1,3,2]
//输出：[2,3,1]
//
//
//
// 限制：
//
// 0 <= 链表长度 <= 10000
// Related Topics 链表
// 👍 76 👎 0

import java.util.Stack;

public class Offer06CongWeiDaoTouDaYinLianBiaoLcof {
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
        public int[] reversePrint(ListNode head) {
            Stack<ListNode> stack = new Stack<>();
            while (head != null) {
                stack.add(head);
                head = head.next;
            }
            int size = stack.size();
            int[] res = new int[size];
            for (int i = 0; i < size; i++) {
                res[i] = stack.pop().val;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
