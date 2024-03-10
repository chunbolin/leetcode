//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics 数组 排序 👍 2256 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 * @author DY
 * @date 2024-03-09 14:39:00
 */
public class P56_MergeIntervals{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P56_MergeIntervals().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		int i = 0;
		while ( i < intervals.length - 1){
			if(intervals[i][1] >= intervals[i + 1][0]) {
				if (intervals[i][1] > intervals[i+1][1]) {
					intervals[i+1][1] = intervals[i][1];
				}
				intervals[i + 1][0] = intervals[i][0];
				intervals[i][0] = -1;
			}
			i++;
		}
		int cnt = 0;
		for (int j = 0; j < intervals.length; j++) {
			if (intervals[j][0] == -1) continue;
			cnt++;
		}
		int[][] result = new int[cnt][2];
		cnt = 0;
		for (int j = 0; j < intervals.length; j++) {
			if (intervals[j][0] == -1) continue;
			result[cnt] = intervals[j];
			cnt++;
		}
		return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
