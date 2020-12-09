package com.leetcode.editor.cn;
//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
//
//
//
// 实现 LRUCache 类：
//
//
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
//
//
//
//
//
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
//
//
//
// 示例：
//
//
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
//
//
//
//
// 提示：
//
//
// 1 <= capacity <= 3000
// 0 <= key <= 3000
// 0 <= value <= 104
// 最多调用 3 * 104 次 get 和 put
//
// Related Topics 设计
// 👍 1028 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P146LruCache {
    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        int capacity;

        private final List<Node> nodes = new ArrayList<>(capacity);
        // key 对应的 value 是 nodes 里面 Node 的下标
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            Integer index = hashMap.get(key);
            if (index == null) {
                return -1;
            }
            Node node = getNodeByIndex(index);
            return node.val;
        }

        public void put(int key, int value) {
            if (hashMap.containsKey(key)) {
                Integer index = hashMap.get(key);
                Node record = new Node(key, value);
                nodes.remove(index);
                nodes.add(index, record);
            } else {

            }
        }

        public Node getNodeByIndex(int index) {
            Node node = nodes.get(index);
            nodes.remove(index);
            nodes.add(0, node);
            return node;
        }
    }

    class Node {

        int key;
        int val;
        Node next, prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class DubbleLinkList {
        // 头尾虚节点
        private Node head, tail;
        // 链表元素数
        private int size;

        public DubbleLinkList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        /**
         * 在链表最后添加一个节点
         *
         * @param node 被添加的节点
         */
        public void addLast(Node node) {
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
            size++;
        }

        /**
         * 在链表中删除指定节点
         *
         * @param node 被删除的节点
         */
        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        /**
         * 获取链表头结点并将其移除链表
         *
         * @return 头结点
         */
        public Node removeFirst() {
            if (head.next == tail) {
                return null;
            }
            Node f = head.next;
            remove(f);
            return f;
        }

        public int size() {
            return size;
        }

    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
