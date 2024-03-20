//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2781 👎 0


package leetcode.editor.cn;
import java.util.*;

/**
 * 合并 K 个升序链表
 * @author DY
 * @date 2024-03-20 21:06:31
 */
public class P23_MergeKSortedLists{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P23_MergeKSortedLists().new Solution();
		ListNode.PrintList(solution.mergeKLists(new ListNode[]{
				ListNode.ArrayToListNode(new int[]{1,4,5}),
				ListNode.ArrayToListNode(new int[]{1,3,4}),
				ListNode.ArrayToListNode(new int[]{2,6}),
		}));
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

    public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null) return null;
		int k = lists.length;
		if (k == 0) return null;
		ListNode dummy = new ListNode();
		ListNode head = dummy;
		PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});
		for (int i = 0; i < k; i++) {
			if (lists[i] != null) {
				minHeap.add(lists[i]);
			}
		}
		while (!minHeap.isEmpty()) {
			ListNode node = minHeap.poll();
			if (node.next != null) {
				minHeap.add(node.next);
			}
			head.next = node;
			head = head.next;
		}
		return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
