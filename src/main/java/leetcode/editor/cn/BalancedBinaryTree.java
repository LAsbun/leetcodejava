//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。 
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
// Related Topics 树 深度优先搜索 
// 👍 383 👎 0


package leetcode.editor.cn;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BalancedBinaryTree {
    public static void main(String[] args) {

        Solution solution = new BalancedBinaryTree().new Solution();
//        boolean balanced = solution.isBalanced(buildTreeNodeFromArgs(new Integer[]{3, 9, 20, null, null, 15, 7}));
        boolean balanced = solution.isBalanced(buildTreeNodeFromArgs(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4}));
        System.out.println(balanced);
//        testGenerateNode();
        // TODO 看一下
    }


    public static TreeNode buildTreeNodeFromArgs(Integer[] args) {
        boolean left = true;

        TreeNode root = new TreeNode(args[0]);

        Queue<TreeNode> queue = new ArrayDeque();
        queue.add(root);

        int index = 0;
        while (index < args.length && !queue.isEmpty()) {
            index++;
            TreeNode poll = queue.poll();
            if (index < args.length) {
                Integer arg = args[index];
                if (null != arg) {
                    TreeNode node = new TreeNode(arg);
                    if (left) {
                        poll.left = node;
                    } else {
                        poll.right = node;
                    }
                    queue.add(node);
                }
                left = !left;


            }

            index++;
            if (index < args.length) {
                Integer arg = args[index];
                if (null != arg) {
                    TreeNode node = new TreeNode(arg);
                    if (left) {
                        poll.left = node;
                    } else {
                        poll.right = node;
                    }
                    queue.add(node);
                }
                left = !left;


            }
        }


        return root;

    }

    public static Node buildNodeFromArgs(Integer[] args) {
        boolean left = true;

        Node root = new Node(args[0]);

        Queue<Node> queue = new ArrayDeque();
        queue.add(root);

        int index = 0;
        while (index < args.length && !queue.isEmpty()) {
            index++;
            Node poll = queue.poll();
            if (index < args.length) {
                Integer arg = args[index];
                if (null != arg) {
                    Node node = new Node(arg);
                    if (left) {
                        poll.left = node;
                    } else {
                        poll.right = node;
                    }
                    queue.add(node);
                }
                left = !left;


            }

            index++;
            if (index < args.length) {
                Integer arg = args[index];
                if (null != arg) {
                    Node node = new Node(arg);
                    if (left) {
                        poll.left = node;
                    } else {
                        poll.right = node;
                    }
                    queue.add(node);
                }
                left = !left;


            }
        }


        return root;

    }

    private static void testGenerateNode() {

        TreeNode treeNode = buildTreeNodeFromArgs(new Integer[]{3, 9, 20, null, null, 15, 7});

        StringBuffer buffer = new StringBuffer();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (null != pop) {
                if (null != pop.right) {
                    stack.push(pop.right);
                }
                if (null != pop.left) {
                    stack.push(pop.left);
                }

                stack.push(pop);
                stack.push(null);

            } else {
                buffer.append(", ");
                pop = stack.pop();
                buffer.append(pop.val);
            }
        }

        System.out.println(buffer.toString());


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
        public boolean isBalanced(TreeNode root) {


            return dfs(root);
        }


        private Boolean dfs(TreeNode root) {
            /**
             * 就是查询下左右子树的深度，如果是大于 直接false
             */

            if (null == root) {
                return true;
            }

            try {
                dfsDepth(root);
                return true;
            } catch (Exception e) {
                return false;
            }
        }

        private int dfsDepth(TreeNode root) throws Exception {
            if (null == root) {
                return 0;
            }

            int left = dfsDepth(root.left) + 1;
            int right = dfsDepth(root.right) + 1;

            if (Math.abs(left - right) > 1) {
                throw new Exception("xxx");
            }

            return Math.max(left, right);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}