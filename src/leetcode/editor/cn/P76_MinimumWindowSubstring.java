//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(m+n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 👍 2841 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 最小覆盖子串
 * @author DY
 * @date 2024-03-09 10:00:08
 */
public class P76_MinimumWindowSubstring{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P76_MinimumWindowSubstring().new Solution();
		  System.out.println(solution.minWindow("aabaabaaab", "bb"));
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
		if (t.length() == 1) {
			if (s.contains(t)) {
				return t;
			} else {
				return "";
			}
		}
		Deque<Integer> deque = new ArrayDeque<>();
		Map<Character, Integer> map = new HashMap<>();

		int totalCnt = 0;
		for (int i = 0; i < t.length(); i++) {
			int cnt = map.getOrDefault(t.charAt(i), 0);
			map.put(t.charAt(i), cnt + 1);
			totalCnt++;
		}
		int i = 0, j = 0;
		int resultI = 0, resultJ = 0, minLen = Integer.MAX_VALUE;
		while (j < s.length()) {
			char c = s.charAt(j);
			Integer cnt = map.get(c);
			if (map.containsKey(c)) {
				if (cnt > 0) totalCnt--;
				map.put(c, cnt - 1);
				deque.add(j);
			}
			while (totalCnt == 0) { // 找到了一个满足条件的窗口
				i = deque.peek();
				int curLen = j - i + 1;
				if (curLen < minLen) {
					minLen = curLen;
					resultI = i;
					resultJ = j;
				}
				int tmpIdx = deque.poll();
				int tmpCnt = map.get(s.charAt(tmpIdx));
				map.put(s.charAt(tmpIdx), tmpCnt + 1);
				i = deque.peek();
				if (tmpCnt + 1 > 0) totalCnt++;
			}
			j++;
		}
		if (minLen == Integer.MAX_VALUE) return "";
		return s.substring(resultI, resultJ + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
