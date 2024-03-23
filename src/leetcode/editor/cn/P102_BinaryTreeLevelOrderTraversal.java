//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 1929 👎 0


package leetcode.editor.cn;
import java.util.*;

/**
 * 二叉树的层序遍历
 * @author DY
 * @date 2024-03-23 15:48:46
 */
public class P102_BinaryTreeLevelOrderTraversal{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P102_BinaryTreeLevelOrderTraversal().new Solution();
		 List<List<Integer>> result = solution.levelOrder(TreeNode.arrayToTreeNode(new Integer[]{3,9,20,11,12,15,7}));
		 for (int i = 0; i < result.size(); i++) {
			 List<Integer> tmp = result.get(i);
			 for (int j = 0; j < tmp.size(); j++) {
				 System.out.print(tmp.get(j) + " ");
			 }
			 System.out.println();
		 }
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
    public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode dummy = new TreeNode();
		queue.offer(root);
		queue.offer(dummy);
		while (queue.peek() != dummy) {
			List<Integer> tmpList = new ArrayList<>();
			while (queue.peek() != dummy) {
				TreeNode tmpNode = queue.poll();
				tmpList.add(tmpNode.val);
				if (tmpNode.left != null) queue.offer(tmpNode.left);
				if (tmpNode.right != null) queue.offer(tmpNode.right);
			}
			queue.poll();
			queue.offer(dummy);
			result.add(tmpList);
		}
		return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
