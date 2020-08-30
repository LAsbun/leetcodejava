//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 966 👎 0


package leetcode.editor.cn;


import static leetcode.editor.cn.RemoveDuplicatesFromSortedList.buildListNodeFromArgs;
import static leetcode.editor.cn.RemoveDuplicatesFromSortedList.printListNode;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {

        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        ListNode node = solution.removeNthFromEnd(buildListNodeFromArgs(new Integer[]{1, 2, 3, 4, 5}), 5);
        ListNode node2 = solution.removeNthFromEnd(buildListNodeFromArgs(new Integer[]{1}), 1);
//        printListNode(node);
        printListNode(node2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode headhead = new ListNode(-1);
            headhead.next = head;
            ListNode pre = headhead;
            ListNode cur = headhead;

            // 这个时候两个指针已经是第一个了
            while (n > 0) {
                pre = pre.next;
                --n;
            }
            while (null != pre.next) {
                pre = pre.next;
                cur = cur.next;
            }
            if (cur.next != null) {
                cur.next = cur.next.next;
            } else {
                return null;
            }
            return headhead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}