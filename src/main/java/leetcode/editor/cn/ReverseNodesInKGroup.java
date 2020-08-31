//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表 
// 👍 702 👎 0


package leetcode.editor.cn;


import static leetcode.editor.cn.RemoveDuplicatesFromSortedList.buildListNodeFromArgs;
import static leetcode.editor.cn.RemoveDuplicatesFromSortedList.printListNode;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {

        Solution solution = new ReverseNodesInKGroup().new Solution();
        ListNode node = solution.reverseKGroup(buildListNodeFromArgs(new Integer[]{0, 1, 2, 3, 5}), 10);
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
        public ListNode reverseKGroup(ListNode head, int k) {

            /**
             * 思路: 翻转部分节点。然后保持前置节点
             */

            if (k == 1) {
                return head;
            }

            ListNode dummyNode = new ListNode(-1);
            dummyNode.next = head;

            ListNode pre = null;
            ListNode start = null;
            ListNode tmp = dummyNode;

            int count = 0;
            while (null != tmp.next) {

                if (pre == null) {
                    pre = tmp;
                }
                tmp = tmp.next;

                ++count;

                if (start == null) {
                    start = tmp;
                }

                if (count % k == 0) {
                    ListNode end = tmp.next;
                    //这个是将start 与end 翻转
                    ListNode node = reversePart(start, end);
                    // 前置节点连接
                    pre.next = node;
                    // 反转之后，start自然就是尾部了。所以需要连接end
                    start.next = end;
                    // 因为是翻转了，所以tmp就会变成前面。此时的尾部是start. 所以需要tmp = start
                    tmp = start;
                    pre = null;
                    start = null;
                }
            }
            return dummyNode.next;

        }

        private ListNode reversePart(ListNode start, ListNode end) {
            ListNode pre = null;
            ListNode cur = start;
            while (null != cur && !cur.equals(end)) {
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