/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [0]
 * 输出：[0]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中结点数在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
 * Related Topics 栈 树 深度优先搜索 链表 二叉树 👍 1137 👎 0
 */

package leetcode.editor.cn;


import java.util.Stack;

import static leetcode.editor.cn.BalancedBinaryTree.buildTreeNodeFromArgs;

public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {

        Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
        solution.flatten(buildTreeNodeFromArgs(new Integer[]{1, 2, 5, 3, 4, null, 6}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public void flatten(TreeNode root) {

            //前序遍历，保存前面一个节点.

            if (null == root) return;

            TreeNode cur = null;

            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {

                TreeNode pop = stack.pop();
                if (pop != null) {
                    if (pop.right != null) stack.push(pop.right);
                    if (pop.left != null) stack.push(pop.left);
                    stack.push(pop);
                    stack.push(null);
                } else {
                    TreeNode tmp = stack.pop();
                    if (cur == null) cur = tmp;
                    else {
                        cur.right = tmp;
                        cur.left = null;
                        cur = tmp;
                    }
                }

            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}