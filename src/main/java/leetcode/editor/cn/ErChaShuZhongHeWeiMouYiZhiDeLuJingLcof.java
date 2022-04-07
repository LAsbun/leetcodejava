//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 回溯 二叉树 👍 311 👎 0


package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static leetcode.editor.cn.BalancedBinaryTree.buildTreeNodeFromArgs;

public class ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof {
    public static void main(String[] args) {

        Solution solution = new ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof().new Solution();
        for (List<Integer> tmp : solution.pathSum(buildTreeNodeFromArgs(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}), 22)) {
            System.out.println(tmp);
        }
        solution = new ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof().new Solution();
        for (List<Integer> tmp : solution.pathSum(buildTreeNodeFromArgs(new Integer[]{1, 2, 3}), 5)) {
            System.out.println(tmp);
        }
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

        List<List<Integer>> ans;

        public List<List<Integer>> pathSum(TreeNode root, int target) {

            ans = new ArrayList<>();

            if (null == root) return ans;

            doFind(new ArrayList<>(), 0, root, target);

            return ans;


        }

        private void doFind(List<Integer> tmp, int tmpSum, TreeNode root, int target) {

            if (root.right == null && root.left == null) {
                if (tmpSum + root.val == target) {
                    tmp.add(root.val);
                    ans.add(tmp);
                }
                return;
            }

            if (root.left != null) {
                List<Integer> curTmp = new ArrayList<>(tmp);
                curTmp.add(root.val);
                doFind(curTmp, tmpSum + root.val, root.left, target);
            }
            if (root.right != null) {
                List<Integer> curTmp = new ArrayList<>(tmp);
                curTmp.add(root.val);
                doFind(curTmp, tmpSum + root.val, root.right, target);
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}