package com.leetcode.editor.cn;
//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//
//
//
// 示例：
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
//
//
//
//
// 提示：你可以假定该字符串只包含小写字母。
// Related Topics 哈希表 字符串
// 👍 328 👎 0

public class P387FirstUniqueCharacterInAString {
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public int firstUniqChar(String s) {
            int[] count = new int[26];
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                count[aChar - 'a']++;
            }
            for (int i = 0; i < chars.length; i++) {
                if (count[chars[i] - 'a'] == 1) {
                    return i;
                }
            }
            return -1;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            int loveleetcode = solution.firstUniqChar("loveleetcode");
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
