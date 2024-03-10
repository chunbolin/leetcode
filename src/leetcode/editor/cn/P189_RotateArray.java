//给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4,5,6,7], k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右轮转 1 步: [7,1,2,3,4,5,6]
//向右轮转 2 步: [6,7,1,2,3,4,5]
//向右轮转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 
//输入：nums = [-1,-100,3,99], k = 2
//输出：[3,99,-1,-100]
//解释: 
//向右轮转 1 步: [99,-1,-100,3]
//向右轮转 2 步: [3,99,-1,-100] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 0 <= k <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。 
// 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？ 
// 
//
// Related Topics 数组 数学 双指针 👍 2111 👎 0


package leetcode.editor.cn;

/**
 * 轮转数组
 * @author DY
 * @date 2024-03-09 15:15:39
 */
public class P189_RotateArray{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P189_RotateArray().new Solution();
		  int[] nums = new int[]{-1,-100,3,99};
		  solution.rotate(nums, 2);
		 for (int i = 0; i < nums.length; i++) {
			 System.out.print(nums[i] + " ");
		 }
		  System.out.println();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public void rotateHelper(int[] nums, int k, int start, int end) {
		// len - k = k  [1,2,3,4,5,6] -> [4,5,6,1,2,3]
		// len - k > k [1,2,3,4,5,6,7] -> [5,6,7,4,1,2,3] 4+ 3 - 4 5 + 3
		// len - k < k [1,2,3,4,5] -> [4,5,3,1,2]
		if (start >= end) return;
		;
		int len = end - start + 1;
		while (k >= len) k -= len;
		if (k == len || k == 0) return;
		if (len - k == k) {
			for (int i = start; i < start + k; i++) {
				swap(nums, i, i + k);
			}
		} else if (len - k > k) {
			for (int i = end; i > end - k; i--) {
				swap(nums, i, i + k - len);
			}
			rotateHelper(nums, k, start + k, end);
		} else {
			for (int i = start; i < start + len - k; i++) {
				swap(nums, i, i + k);
			}
			rotateHelper(nums, k - (len - k), start, end - (len - k));
		}
	}

	public void rotate(int[] nums, int k) {
		rotateHelper(nums, k, 0, nums.length - 1);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
