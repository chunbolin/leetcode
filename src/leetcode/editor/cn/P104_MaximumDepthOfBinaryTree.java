//给定一个二叉树 root ，返回其最大深度。 
//
// 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：root = [1,null,2]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数量在 [0, 10⁴] 区间内。 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1802 👎 0


package leetcode.editor.cn;
import java.util.*;

/**
 * 二叉树的最大深度
 * @author DY
 * @date 2024-03-22 20:03:39
 */
public class P104_MaximumDepthOfBinaryTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P104_MaximumDepthOfBinaryTree().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

	private int maxDepth;

	private void Helper(TreeNode root, int currentDepth) {
		if (root == null) {
			return;
		}
		maxDepth = Math.max(maxDepth, currentDepth);
		Helper(root.left, currentDepth + 1);
		Helper(root.right, currentDepth + 1);
	}
    public int maxDepth(TreeNode root) {
		maxDepth = 0;
		Helper(root, 1);
		return maxDepth;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
