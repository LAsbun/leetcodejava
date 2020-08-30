//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1196 👎 0


package leetcode.editor.cn;


import static leetcode.editor.cn.RemoveDuplicatesFromSortedList.buildListNodeFromArgs;
import static leetcode.editor.cn.RemoveDuplicatesFromSortedList.printListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {

        Solution solution = new ReverseLinkedList().new Solution();
//        ListNode node = solution.reverseList(buildListNodeFromArgs(new Integer[]{0, 1, 2, 3}));
        ListNode node = solution.reverseList(buildListNodeFromArgs(new Integer[]{0}));
        printListNode(node);

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
        public ListNode reverseList(ListNode head) {

            ListNode pre = null;
            ListNode cur = head;
            while (null != cur) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            return pre;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}