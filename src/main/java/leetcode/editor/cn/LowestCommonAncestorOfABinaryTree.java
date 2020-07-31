//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
// Related Topics 树 
// 👍 679 👎 0


package leetcode.editor.cn;


import javafx.util.Pair;

import java.util.*;

import static leetcode.editor.cn.BalancedBinaryTree.buildTreeNodeFromArgs;

public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {

        Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
        TreeNode treeNode = solution.lowestCommonAncestor(
                buildTreeNodeFromArgs(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}),
                buildTreeNodeFromArgs(new Integer[]{5}),
                buildTreeNodeFromArgs(new Integer[]{1})
        );
//        TreeNode treeNode = solution.lowestCommonAncestor(
//                buildTreeNodeFromArgs(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}),
//                buildTreeNodeFromArgs(new Integer[]{5}),
//                buildTreeNodeFromArgs(new Integer[]{4})
//        );
        System.out.println(treeNode.val);
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
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // 找出来从跟节点到指定节点的路径，判断两个路径是否有公共节点，找到最近的那个即可

            if (null == root) {
                return null;
            }

            List<Integer> pSet = new ArrayList<>();
            List<Integer> qSet = new ArrayList<>();
            boolean pflag = false;
            boolean qflag = false;

            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                if (null != pop) {
                    stack.push(pop);
                    stack.push(null);
                    if (null != pop.right) {
                        stack.push(pop.right);
                    }
                    if (null != pop.left) {
                        stack.push(pop.left);
                    }
                } else {
                    pop = stack.pop();
                    ArrayList<TreeNode> treeNodes = new ArrayList<>(stack);
                    if (!pflag) {
                        if (pop.val == p.val) {
                            pSet.add(p.val);
                            boolean preIsNull = false;
                            for (int i = treeNodes.size() - 1; i >= 0; --i) {
                                TreeNode next = treeNodes.get(i);
                                if (null != next) {
                                    if (preIsNull) {
                                        pSet.add(next.val);
                                        preIsNull = false;
                                    }
                                } else {
                                    preIsNull = true;
                                }
                            }
                            pflag = true;
                        }
                    }

                    if (!qflag) {
                        if (pop.val == q.val) {
                            qSet.add(pop.val);
                            boolean preIsNull = false;
                            for (int i = treeNodes.size() - 1; i >= 0; --i) {
                                TreeNode next = treeNodes.get(i);
                                if (null != next) {
                                    if (preIsNull) {
                                        qSet.add(next.val);
                                        preIsNull = false;
                                    }
                                } else {
                                    preIsNull = true;
                                }
                            }
                            qflag = true;

                        }
                    }

                    if (pflag && qflag) {
                        break;
                    }
                }
            }

            TreeNode resultNode = null;

            for (Integer integer : pSet) {
                if (qSet.contains(integer)) {
                    resultNode = new TreeNode(integer);
                    break;
                }
            }

            return resultNode;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
