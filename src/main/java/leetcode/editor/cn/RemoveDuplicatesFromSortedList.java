//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表 
// 👍 371 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {

        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();

//        ListNode listNode = solution.deleteDuplicates(buildListNodeFromArgs(new Integer[]{1, 1, 1, 2}));
        ListNode listNode = solution.deleteDuplicates(buildListNodeFromArgs(new Integer[]{1, 1, 1, 2, 3, 3}));
        printListNode(listNode);
    }


    public static void printListNode(ListNode head) {
        while (null != head) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode buildListNodeFromArgs(Integer[] args) {

        ListNode head = new ListNode(args[0]);

        ListNode tmp = head;

        for (int i = 1; i < args.length; i++) {
            ListNode listNode = new ListNode(args[i]);
            tmp.next = listNode;
            tmp = listNode;
        }

        return head;
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
            Set<Integer> set = new HashSet<>();

            if (null == head) {
                return null;
            }

            ListNode tmp = head;
            ListNode pre = tmp;
            while (null != tmp) {
                if (set.contains(tmp.val)) {
                    pre.next = tmp.next;
                    tmp = tmp.next;
                } else {
                    set.add(tmp.val);
                    pre = tmp;
                    tmp = tmp.next;

                }
            }
            return head;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}