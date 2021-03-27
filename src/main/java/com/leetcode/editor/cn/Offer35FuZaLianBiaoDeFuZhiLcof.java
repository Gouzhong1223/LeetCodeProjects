package com.leetcode.editor.cn;
//请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指
//向链表中的任意节点或者 null。
//
//
//
// 示例 1：
//
//
//
// 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
//
//
// 示例 2：
//
//
//
// 输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
//
//
// 示例 3：
//
//
//
// 输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
//
//
// 示例 4：
//
// 输入：head = []
//输出：[]
//解释：给定的链表为空（空指针），因此返回 null。
//
//
//
//
// 提示：
//
//
// -10000 <= Node.val <= 10000
// Node.random 为空（null）或指向链表中的节点。
// 节点数目不超过 1000 。
//
//
//
//
// 注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-point
//er/
//
//
// Related Topics 链表
// 👍 179 👎 0

public class Offer35FuZaLianBiaoDeFuZhiLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return head;
            }
            Node node = head;
            // 在原有链表的每一个节点后面复制一个新的节点
            while (node != null) {
                // 根据 node 的 val 构建一个 node
                Node cloneNode = new Node(node.val);
                // 复制 node 的 next 指针到 cloneNode
                cloneNode.next = node.next;
                // 将 node 的 next 指针指向 cloneNode
                node.next = cloneNode;
                // node 变成 cloneNode 的 next 也就是原 node 的 next
                node = cloneNode.next;
            }
            node = head;
            Node cloneNode;
            // 复制随机指针
            while (node != null) {
                if (node.random != null) {
                    node.next.random = node.random.next;
                }
                node = node.next.next;
            }
            // 拆分链表
            node = head;
            Node cloneHead = head.next;
            cloneNode = cloneHead;
            while (node != null) {
                node.next = cloneNode.next;
                node = node.next;
                if (cloneNode.next != null) {
                    cloneNode.next = cloneNode.next.next;
                    cloneNode = cloneNode.next;
                }
            }
            return cloneHead;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
