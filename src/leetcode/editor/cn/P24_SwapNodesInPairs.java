//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// Related Topics 递归 链表 👍 2171 👎 0


package leetcode.editor.cn;

/**
 * 两两交换链表中的节点
 * @author DY
 * @date 2024-03-17 11:35:22
 */
public class P24_SwapNodesInPairs{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P24_SwapNodesInPairs().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
		ListNode dummyHead1 = new ListNode();
		ListNode dummyHead2 = new ListNode();
		ListNode dummyHead3 = new ListNode();
		dummyHead1.next = dummyHead2;
		dummyHead2.next = dummyHead3;
		dummyHead3.next = head;
		ListNode pre = dummyHead1;
		ListNode first = dummyHead2;
		ListNode second = dummyHead3;
		while (first != null && second !=null) {
			pre.next = second;
			first.next = second.next;
			second.next = first;
			pre = pre.next.next;
			first = first.next;
			if (first == null || first.next == null) break;
			second = first.next;
		}
		return dummyHead2.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
