package leetcode.editor.cn;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode ArrayToListNode(int[] array) {
        if (array.length == 0) {
            return null;
        }
        ListNode root = new ListNode(array[0]);
        ListNode other = root; //生成另一个节点，并让other指向root节点，other在此作为一个临时变量，相当于指针
        for (int i = 1; i < array.length; i++) { //由于已给root赋值，所以i从1开始
            ListNode temp = new ListNode(array[i]); //每循环一次生成一个新的节点,并给当前节点赋值
            other.next = temp; //将other的下一个节点指向生成的新的节点
            other = temp; //将other指向最后一个节点(other的下一个节点)  other=other.getNext();
        }
        return root;
    }

    public static void PrintList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }
}


