//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
// 
//
// 示例 2: 
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL 
// Related Topics 链表 双指针 
// 👍 324 👎 0


package leetcode.editor.cn;


import static leetcode.editor.cn.RemoveDuplicatesFromSortedList.buildListNodeFromArgs;
import static leetcode.editor.cn.RemoveDuplicatesFromSortedList.printListNode;

public class RotateList {
    public static void main(String[] args) {

        Solution solution = new RotateList().new Solution();
//        ListNode node = solution.rotateRight(buildListNodeFromArgs(new Integer[]{1, 2, 3, 4, 5}), 2);
        ListNode node = solution.rotateRight(buildListNodeFromArgs(new Integer[]{0, 1}), 4);
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
        public ListNode rotateRight(ListNode head, int k) {
            if (null == head || null == head.next) {
                return head;
            }
            ListNode tmp = head;

            int size = 1;

            while (null != tmp.next) {
                tmp = tmp.next;
                ++size;
            }

            // 已经变成循环链表了
            tmp.next = head;
            int circle = size - (k % size);

            // 因为当前就是已经是1了
            while (circle >= 1) {
                tmp = head;
                head = head.next;
                circle--;
            }

            tmp.next = null;

            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}