package com.leetcode.editor.cn;
//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i,
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。
//
//
//
//
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
//
//
//
// 示例：
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49
// Related Topics 数组 双指针
// 👍 1953 👎 0

public class P11ContainerWithMostWater {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            // 双指针夹逼，不断往中间移动
            int i = 0, j = height.length - 1, res = 0;
            while (i < j) {
                res = height[i] < height[j] ?
                        // 假如左边的高度比右边矮，就往中间移动
                        Math.max(res, (j - i) * height[i++]) :
                        // 假如右边的高度比左边矮，也往中间移动
                        Math.max(res, (j - i) * height[j--]);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
