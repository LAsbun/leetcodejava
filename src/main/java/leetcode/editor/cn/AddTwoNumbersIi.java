//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。
// 将这两数相加会返回一个新的链表。
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 进阶： 
//
// 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 8 -> 0 -> 7
// 
// Related Topics 链表 
// 👍 264 👎 0


package leetcode.editor.cn;


import java.util.Stack;

import static leetcode.editor.cn.RemoveDuplicatesFromSortedList.buildListNodeFromArgs;
import static leetcode.editor.cn.RemoveDuplicatesFromSortedList.printListNode;

public class AddTwoNumbersIi {
    public static void main(String[] args) {

        Solution solution = new AddTwoNumbersIi().new Solution();
        ListNode treeNode = buildListNodeFromArgs(new Integer[]{7, 2, 4, 3});
        ListNode treeNode2 = buildListNodeFromArgs(new Integer[]{5, 6, 4});
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
            // 用栈
            Stack<Integer> stack1 = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();

            while (null != l1) {
                stack1.push(l1.val);
                l1 = l1.next;
            }
            while (null != l2) {
                stack2.push(l2.val);
                l2 = l2.next;
            }

            int bb = 0;
            ListNode head = null;

            while (!stack1.isEmpty() && !stack2.isEmpty()) {
                int sum = stack1.pop() + stack2.pop() + bb;
                if (sum > 9) {
                    sum -= 10;
                    bb = 1;
                } else {
                    bb = 0;
                }
                ListNode node = new ListNode(sum);
                node.next = head;
                head = node;
            }

            while (!stack1.isEmpty()) {
                int sum = stack1.pop() + bb;
                if (sum > 9) {
                    sum -= 10;
                    bb = 1;
                } else {
                    bb = 0;
                }
                ListNode node = new ListNode(sum);
                node.next = head;
                head = node;
            }

            while (!stack2.isEmpty()) {
                int sum = stack2.pop() + bb;
                if (sum > 9) {
                    sum -= 10;
                    bb = 1;
                } else {
                    bb = 0;
                }
                ListNode node = new ListNode(sum);
                node.next = head;
                head = node;
            }

            if (bb > 0) {
                ListNode node = new ListNode(bb);
                node.next = head;
                head = node;
            }

            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}