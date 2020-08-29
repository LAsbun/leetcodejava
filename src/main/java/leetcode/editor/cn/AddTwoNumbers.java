//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 4812 👎 0


package leetcode.editor.cn;


import static leetcode.editor.cn.RemoveDuplicatesFromSortedList.buildListNodeFromArgs;
import static leetcode.editor.cn.RemoveDuplicatesFromSortedList.printListNode;

public class AddTwoNumbers {
    public static void main(String[] args) {

        Solution solution = new AddTwoNumbers().new Solution();

        ListNode treeNode = buildListNodeFromArgs(new Integer[]{5});
        ListNode treeNode2 = buildListNodeFromArgs(new Integer[]{5});
        ListNode node = solution.addTwoNumbers(treeNode, treeNode2);
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode head = new ListNode(-1);
            ListNode tmp = head;
            int bb = 0;

            while (null != l1 && null != l2) {
                int sum = l1.val + l2.val + bb;
                if (sum > 9) {
                    sum -= 10;
                    bb = 1;
                } else {
                    bb = 0;
                }

                ListNode node = new ListNode(sum);
                head.next = node;
                head = node;

                l1 = l1.next;
                l2 = l2.next;
            }

            while (null != l1) {
                int sum = l1.val + bb;
                if (sum > 9) {
                    sum -= 10;
                    bb = 1;
                } else {
                    bb = 0;
                }
                ListNode node = new ListNode(sum);
                head.next = node;
                head = node;
                l1 = l1.next;

            }

            while (null != l2) {
                int sum = l2.val + bb;
                if (sum > 9) {
                    sum -= 10;
                    bb = 1;
                } else {
                    bb = 0;
                }
                ListNode node = new ListNode(sum);
                head.next = node;
                head = node;
                l2 = l2.next;

            }

            if (bb > 0) {
                ListNode node = new ListNode(bb);
                head.next = node;
            }

            return tmp.next;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}