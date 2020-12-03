package com.leetcode.editor.cn;
//给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
//
// 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
//
// 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
//
// 返回一个符合上述规则的链表的列表。
//
// 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
//
// 示例 1：
//
//
//输入:
//root = [1, 2, 3], k = 5
//输出: [[1],[2],[3],[],[]]
//解释:
//输入输出各部分都应该是链表，而不是数组。
//例如, 输入的结点 root 的 val= 1, root.next.val = 2, \root.next.next.val = 3, 且 root.ne
//xt.next.next = null。
//第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。
//最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。
//
//
// 示例 2：
//
//
//输入:
//root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
//输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
//解释:
//输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度。
//
//
//
//
// 提示:
//
//
// root 的长度范围： [0, 1000].
// 输入的每个节点的大小范围：[0, 999].
// k 的取值范围： [1, 50].
//
//
//
// Related Topics 链表
// 👍 111 👎 0

public class P725SplitLinkedListInParts {
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
        public ListNode[] splitListToParts(ListNode root, int k) {

            ListNode counter = root;
            int count = 0;
            while (counter != null) {
                count += 1;
                counter = counter.next;
            }
            int width = count / k;
            int rem = count % k;

            ListNode[] ans = new ListNode[k];
            counter = root;
            for (int i = 0; i < k; ++i) {

                ListNode head = counter;

                for (int j = 0; j < width + (i < rem ? 1 : 0) - 1; ++j) {
                    if (counter != null) {
                        counter = counter.next;
                    }
                }
                if (counter != null) {
                    ListNode prev = counter;
                    counter = counter.next;
                    prev.next = null;
                }
                ans[i] = head;
            }
            return ans;

        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            ListNode listNode = new ListNode(2);
            ListNode listNode1 = new ListNode(4);
            ListNode listNode2 = new ListNode(3);
            ListNode listNode3 = new ListNode(5);
            ListNode listNode4 = new ListNode(6);
            ListNode listNode5 = new ListNode(4);
            listNode.next = listNode1;
            listNode1.next = listNode2;
            listNode2.next = listNode3;
            listNode3.next = listNode4;
            listNode4.next = listNode5;
            ListNode[] listNodes = solution.splitListToParts(listNode, 4);
            for (ListNode node : listNodes) {
                while (node != null) {
                    System.out.println(node.val);
                    node = node.next;
                }
                System.out.println("----");
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
