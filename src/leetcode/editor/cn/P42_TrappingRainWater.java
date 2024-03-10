//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 5035 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 接雨水
 *
 * @author DY
 * @date 2024-03-02 14:20:58
 */
public class P42_TrappingRainWater {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P42_TrappingRainWater().new Solution();

        System.out.println(solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int calc(int begin, int end, int[] height) {
            if (end - begin <= 1) return 0;
            int min = Math.min(height[begin], height[end]);
            int result = 0;
            for (int i = begin + 1; i < end; i++) {
                result += min - height[i];
            }
            return result;
        }

        public int trap(int[] height) {
            int i = 0, j = 1;
            int result = 0;
            while (j < height.length) {
                if (height[i] <= height[j]) {
                    i++;
                    j++;
                } else {
                    while (j < height.length && height[i] > height[j]) j++;
                    if (j >= height.length) break;
                    result += calc(i, j, height);
                    i = j;
                    j++;
                }
            }
            j = height.length - 2;
            i = height.length - 1;
            while (j >= 0) {
                if (height[i] <= height[j]) {
                    i--;
                    j--;
                } else {
                    while (j >= 0 && height[i] > height[j]) j--;
                    if (j < 0) break;
                    result += calc(j, i, height);
                    i = j;
                    j--;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
