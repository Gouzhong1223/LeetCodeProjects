package com.leetcode.editor.cn;
//给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
//
// 返回仅包含 1 的最长（连续）子数组的长度。
//
//
//
// 示例 1：
//
// 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//输出：6
//解释：
//[1,1,1,0,0,1,1,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 6。
//
// 示例 2：
//
// 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
//输出：10
//解释：
//[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 10。
//
//
//
// 提示：
//
//
// 1 <= A.length <= 20000
// 0 <= K <= A.length
// A[i] 为 0 或 1
//
// Related Topics 双指针 Sliding Window
// 👍 224 👎 0

public class P1004MaxConsecutiveOnesIii {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestOnes(int[] A, int K) {
            int left = 0, right = 0;
            int maxLen = 0;
            int zeros = 0;
            while (right < A.length) {
                if (A[right] == 0) {
                    zeros++;
                }
                while (zeros > K) {
                    if (A[left++] == 0) {
                        zeros--;
                    }
                }
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            }
            return maxLen;
        }

//        public static void main(String[] args) {
//            Solution solution = new Solution();
//            int[] ints = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
//            int result = solution.longestOnes(ints, 3);
//            System.out.println(result);
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
