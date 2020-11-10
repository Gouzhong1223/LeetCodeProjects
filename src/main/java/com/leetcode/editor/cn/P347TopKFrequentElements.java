package com.leetcode.editor.cn;
//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
//
//
//
// 示例 1:
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
//
//
// 示例 2:
//
// 输入: nums = [1], k = 1
//输出: [1]
//
//
//
// 提示：
//
//
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
// 你可以按任意顺序返回答案。
//
// Related Topics 堆 哈希表
// 👍 565 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class P347TopKFrequentElements {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                if (map.containsKey(num)) {
                    Integer count = map.get(num);
                    map.put(num, count + 1);
                } else {
                    map.put(num, 1);
                }
            }
            ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
            entries.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = entries.get(i).getKey();
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
