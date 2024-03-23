//给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。 
//
// 
//
// 示例 1： 
// 
// 
//输入：nums = [-10,-3,0,5,9]
//输出：[0,-3,9,-10,null,5]
//解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
//
// 
//
// 示例 2： 
// 
// 
//输入：nums = [1,3]
//输出：[3,1]
//解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 按 严格递增 顺序排列 
// 
//
// Related Topics 树 二叉搜索树 数组 分治 二叉树 👍 1492 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 将有序数组转换为二叉搜索树
 *
 * @author DY
 * @date 2024-03-23 16:25:08
 */
public class P108_ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P108_ConvertSortedArrayToBinarySearchTree().new Solution();
        TreeNode.PrintTree(solution.sortedArrayToBST(new int[]{-10,-3,0,5,9}));
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        public TreeNode helper(int[] nums, int start, int end) {
            if (start > end) return null;
            if (start == end) return new TreeNode(nums[start]);
            int middle = (start + end) / 2;
            TreeNode left = helper(nums, start, middle - 1);
            TreeNode right = helper(nums, middle + 1, end);
            return new TreeNode(nums[middle], left, right);
        }

        public TreeNode sortedArrayToBST(int[] nums) {
            return helper(nums, 0 ,nums.length - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
