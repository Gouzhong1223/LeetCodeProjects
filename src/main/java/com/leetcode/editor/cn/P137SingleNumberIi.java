package com.leetcode.editor.cn;
//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
//
// 说明：
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//
// 示例 1:
//
// 输入: [2,2,3,2]
//输出: 3
//
//
// 示例 2:
//
// 输入: [0,1,0,1,0,1,99]
//输出: 99
// Related Topics 位运算
// 👍 464 👎 0

public class P137SingleNumberIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int num = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int tmp = num;
                num = num | nums[i];
                if (num != tmp) {
                    return nums[i];
                }
                num = tmp;
            }
            return 0;
        }

//        public static void main(String[] args) {
//            Solution solution = new Solution();
//            int[] ints = {2, 2, 3, 2};
//            System.out.println(solution.singleNumber(ints));
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
