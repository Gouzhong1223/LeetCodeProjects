package com.leetcode.editor.cn;
//给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
// 例如，如果一个字符在每个字符串中出现 3 次，但不
//是 4 次，则需要在最终答案中包含该字符 3 次。
//
// 你可以按任意顺序返回答案。
//
//
//
// 示例 1：
//
// 输入：["bella","label","roller"]
//输出：["e","l","l"]
//
//
// 示例 2：
//
// 输入：["cool","lock","cook"]
//输出：["c","o"]
//
//
//
//
// 提示：
//
//
// 1 <= A.length <= 100
// 1 <= A[i].length <= 100
// A[i][j] 是小写字母
//
// Related Topics 数组 哈希表
// 👍 158 👎 0

import java.util.ArrayList;
import java.util.List;

public class P1002FindCommonCharacters {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> commonChars(String[] A) {
            //先得到第一个字符串里面每个字符的情况
            int[] charCount = new int[26];
            for (int i = 0; i < A[0].length(); i++) {
                charCount[A[0].charAt(i) - 'a']++;
            }

            //从第1个开始逐个进行比较
            for (int i = 1; i < A.length; i++) {
                int[] curCount = new int[26];

                //遍历第i个字符串
                for (int j = 0; j < A[i].length(); j++) {
                    curCount[A[i].charAt(j) - 'a']++;
                }

                //将此时关于第i个字符串的情况与charCount对比，取小的即可
                for (int k = 0; k < 26; k++) {
                    charCount[k] = Math.min(charCount[k], curCount[k]);
                }
            }

            //此时的charCount即为所有的字符串出现的共有的最小元素的个数
            List<String> result = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                while (charCount[i] != 0) {
                    result.add(String.valueOf((char) (i + 'a')));
                    charCount[i]--;
                }
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
