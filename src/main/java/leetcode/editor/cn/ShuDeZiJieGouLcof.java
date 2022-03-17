//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构) 
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。 
//
// 例如: 
//给定的树 A: 
//
// 3 
// / \ 
// 4 5 
// / \ 
// 1 2 
//给定的树 B： 
//
// 4 
// / 
// 1 
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。 
//
// 示例 1： 
//
// 输入：A = [1,2,3], B = [3,1]
//输出：false
// 
//
// 示例 2： 
//
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true 
//
// 限制： 
//
// 0 <= 节点个数 <= 10000 
// Related Topics 树 深度优先搜索 二叉树 👍 507 👎 0


package leetcode.editor.cn;


import java.util.LinkedList;
import java.util.Queue;

import static leetcode.editor.cn.BalancedBinaryTree.buildTreeNodeFromArgs;

public class ShuDeZiJieGouLcof {
    public static void main(String[] args) {

        Solution solution = new ShuDeZiJieGouLcof().new Solution();
        System.out.println(solution.isSubStructure(buildTreeNodeFromArgs(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4}), buildTreeNodeFromArgs(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4})));
        System.out.println(solution.isSubStructure(buildTreeNodeFromArgs(new Integer[]{3, 4, 5, 1, null, null, 2}), buildTreeNodeFromArgs(new Integer[]{4, 1})));
        System.out.println(solution.isSubStructure(buildTreeNodeFromArgs(new Integer[]{3, 4, 5, 1, null, null, 2}), buildTreeNodeFromArgs(new Integer[]{1, 4})));
        System.out.println(solution.isSubStructure(buildTreeNodeFromArgs(new Integer[]{4, 2, 3, 4, 5, 6, 7, 8, 9}), buildTreeNodeFromArgs(new Integer[]{4, 8, 9})));
        System.out.println(solution.isSubStructure(buildTreeNodeFromArgs(new Integer[]{1,0,1,-4,-3}), buildTreeNodeFromArgs(new Integer[]{1,-4})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            /**
             * 思路: 遍历A的所有节点
             * 对于A的某个节点，
             * 如果等于B的某个节点，则判断A的左子树与B的左子树且A的右子树与B的右子树是否完全一直
             * 如果不等于B的某个节点，返回结束。
             * 注意如果B先为Null，则表示为正确.
             */

            if (B == null) return false;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(A);

            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (doMatch(poll, B)) {
                    return true;
                } else {
                    if (poll.right != null) queue.add(poll.right);
                    if (poll.left != null) queue.add(poll.left);
                }
            }


            return false;
        }

        private boolean doMatch(TreeNode a, TreeNode b) {
            if (b == null) return true;
            // a=null b!=null
            if (a == null) return false;

            if (a.val == b.val) {
                return doMatch(a.left, b.left) && doMatch(a.right, b.right);
            }

            return false;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
