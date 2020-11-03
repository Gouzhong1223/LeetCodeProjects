package com.leetcode.editor.cn;
//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
// 示例 1:
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
//
//
// 示例 2:
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
//
//
// 说明:
//
// 所有输入只包含小写字母 a-z 。
// Related Topics 字符串
// 👍 1329 👎 0

public class P14LongestCommonPrefix {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            // 如果字符串场长度为0，则说明没有最长前缀
            if (strs.length == 0) {
                return "";
            }
            // 当前数组的第一个初始化为共有前缀
            String res = strs[0];
            // 从第一个开始遍历
            for (int i = 1; i < strs.length; i++) {
                int j = 0;
                for (; j < res.length() && j < strs[i].length(); j++) {
                    if (res.charAt(j) != strs[i].charAt(j)) {
                        break;
                    }
                }
                res = res.substring(0, j);
                if ("".equals(res)) {
                    return res;
                }
            }
            return res;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
