//给定一个链表，返回链表开始入环的第一个节点。 从链表的头节点开始沿着 next 指针进入环的第一个节点为环的入口节点。如果链表无环，则返回 null。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，
//pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。 
//
// 说明：不允许修改给定的链表。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围在范围 [0, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// pos 的值为 -1 或者链表中的一个有效索引 
// 
//
// 
//
// 进阶：是否可以使用 O(1) 空间解决此题？ 
//
// 
//
// 注意：本题与主站 142 题相同： https://leetcode-cn.com/problems/linked-list-cycle-ii/ 
// Related Topics 哈希表 链表 双指针 👍 36 👎 0


package leetcode.editor.cn;


import static leetcode.editor.cn.RemoveDuplicatesFromSortedList.buildCycleListNodeFromArgs;
import static leetcode.editor.cn.RemoveDuplicatesFromSortedList.buildListNodeFromArgs;

public class C32eOV {
    public static void main(String[] args) {

        Solution solution = new C32eOV().new Solution();

        //System.out.println(solution.detectCycle(buildCycleListNodeFromArgs(new Integer[]{3, 2, 0, -4}, 2)).val);
        System.out.println(solution.detectCycle(buildCycleListNodeFromArgs(new Integer[]{3, 2, 0, -4}, 1)).val);
        System.out.println(solution.detectCycle(buildCycleListNodeFromArgs(new Integer[]{3, 2, 0, -4}, 0)).val);
        System.out.println(solution.detectCycle(buildCycleListNodeFromArgs(new Integer[]{3}, -1)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            /**
             * 思路: 快慢指针 慢每走一步，则快走两步
             * 如果快指针先走到底，且满指针所指位置不是快指针所指位置。则表示无环.
             * 如果存在环。假设Head到第一个环节点的距离为k,
             *  走了m步，快指针追上了满指针(此时快比慢多走了一个环长度n) 特别注意: 有可能fast.next=slow.
             *  则存在 fastLen = slowlen+n => n. 则求出n
             *  再通过快慢指针. 快=慢+n(即快先走n步). 假设走了q步， 此时q= k
             *  返回head 走了k节点。
             *
             */


            if (null == head || null == head.next) return null;

            ListNode slow = head;
            ListNode fast = head.next;

            int recordFast = 2;
            int recordSlow = 1;
            while (!slow.equals(fast)) {
                // 先走两步
                slow = slow.next;
                ++recordSlow;

                fast = fast.next;
                // 如果快的走不动了，没有环
                if (fast == null) return null;

                ++recordFast;
                // 如果快指针只走了一个就追上slow 中断掉
                if (fast == slow) break;

                // 找下一个.
                fast = fast.next;
                if (fast == null) return null;
                ++recordFast;

            }

            // 到这里一定是有环了.
            int n = recordFast - recordSlow;


            ListNode fast2 = head;
            ListNode slow2 = head;

            for (int i = 0; i < n; i++) {
                fast2 = fast2.next;
            }

            int k = 1;
            while (slow2 != fast2) {
                slow2 = slow2.next;
                ++k;
                fast2 = fast2.next;
            }

            ListNode ans = head;

            for (int i = 0; i < k-1; i++) {
                ans = ans.next;
            }
            return ans;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}