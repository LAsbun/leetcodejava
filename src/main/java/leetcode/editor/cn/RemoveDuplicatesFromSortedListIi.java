//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表 
// 👍 340 👎 0


package leetcode.editor.cn;


import java.util.HashSet;
import java.util.Set;

import static leetcode.editor.cn.RemoveDuplicatesFromSortedList.buildListNodeFromArgs;
import static leetcode.editor.cn.RemoveDuplicatesFromSortedList.printListNode;

public class RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {

        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
        ListNode listNode = solution.deleteDuplicates(buildListNodeFromArgs(new Integer[]{1, 1, 1, 2}));
//        ListNode listNode = solution.deleteDuplicates(buildListNodeFromArgs(new Integer[]{1, 1, 1, 2, 3, 3}));
        printListNode(listNode);
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
        public ListNode deleteDuplicates(ListNode head) {
            // 保存一次set,然后创建空节点，然后输出即可

            Set<Integer> set = new HashSet<>();

            if (null == head) {
                return null;
            }

            ListNode dummyNode = new ListNode(0);
            dummyNode.next = head;

            head = dummyNode;

            int rmValue;

            while (null != head.next && null != head.next.next) {

                if (head.next.val == head.next.next.val) {
                    rmValue = head.next.val;
                    while (null != head.next && head.next.val == rmValue) {
                        head.next = head.next.next;
                    }

                } else {
                    head = head.next;
                }
            }
            return dummyNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}