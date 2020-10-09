package com.leetcode.editor.cn;
//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
// 示例 1:
//
// 输入: 121
//输出: true
//
//
// 示例 2:
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
//
//
// 示例 3:
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
//
//
// 进阶:
//
// 你能不将整数转为字符串来解决这个问题吗？
// Related Topics 数学
// 👍 1263 👎 0

public class P9PalindromeNumber {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            int newInt = reverse(x > 0 ? x : -x);
            return newInt == x;
        }

        private int reverse(int num) {
            int result = 0;
            while (true) {
                int n = num % 10;//取出最低位上的数字
                //也可以直接打印出来System.out.println(n);但不好，也可以用一个数组存起来，也不好，都因为翻转后的前后的那个0的问题
                result = result * 10 + n;//依次的反转存储得到反转的数字
                num = num / 10;//降位
                if (num == 0) {
                    break;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
