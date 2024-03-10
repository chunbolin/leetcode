//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 1391 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 找到字符串中所有字母异位词
 *
 * @author DY
 * @date 2024-03-04 20:29:30
 */
public class P438_FindAllAnagramsInAString {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P438_FindAllAnagramsInAString().new Solution();
        List<Integer> result = solution.findAnagrams("abaacbabc", "abc");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + "");
        }
        System.out.println();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void initMap(Map<Character, Integer> map, String p) {
            map.clear();
            for (int i = 0; i < p.length(); i++) {
                char c = p.charAt(i);
                if (map.containsKey(c)) {
                    int cnt = map.get(c);
                    map.put(c, cnt + 1);
                } else {
                    map.put(c, 1);
                }
            }
        }

        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new ArrayList<>();
            if (s.isEmpty() || s.length() < p.length()) {
                return result;
            }
            Map<Character, Integer> map = new HashMap<>();
            int len = p.length();
            initMap(map, p);
            int i = 0, j = 0;
            while (j < s.length()) {
                char c = s.charAt(j);
                Integer cnt = map.get(c);
                if (map.containsKey(c) && cnt > 0) {
                    map.put(c, cnt - 1);
                    if (j - i + 1 == len ) {
                        result.add(i);
                        int tmpCnt = map.get(s.charAt(i));
                        map.put(s.charAt(i), tmpCnt + 1);
                        i++;
                    }
                    j++;
                } else if (map.containsKey(c) && cnt == 0) {
                    int tmpCnt = map.get(s.charAt(i));
                    map.put(s.charAt(i), tmpCnt + 1);
                    i++;
                } else {
                    initMap(map, p);
                    j++;
                    i = j;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
