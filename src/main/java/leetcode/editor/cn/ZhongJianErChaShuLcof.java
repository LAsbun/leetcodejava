//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 709 👎 0


package leetcode.editor.cn;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZhongJianErChaShuLcof {
    public static void main(String[] args) {

        Solution solution = new ZhongJianErChaShuLcof().new Solution();

        TreeNode treeNode = solution.buildTree(
                new int[]{3, 9, 20, 15, 7},
                new int[]{9, 3, 15, 20, 7});

        TreeNode treeNode2 = solution.buildTree(
                new int[]{3},
                new int[]{3});


        List<Integer> list = new BinaryTreePreorderTraversal().new Solution().preorderTraversal(treeNode);
        System.out.println(Arrays.toString(list.toArray()));
        List<Integer> list2 = new BinaryTreePreorderTraversal().new Solution().preorderTraversal(treeNode2);
        System.out.println(Arrays.toString(list2.toArray()));
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

        // 当前第几个前序
        int index;
        Map<Integer, Integer> map;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            /**
             * 前序 中左右
             * 中序 左中右
             *  前序的第一个节点一定是根节点。 则根据根节点，就可以找到左子树和右子树，依次递归构建即可。
             *
             *  思路 遍历前序，根据前序中根节点在中序中的位置，依次拆分构建左右子树
             */

            map = new HashMap<>(inorder.length);

            index = 0;

            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }

            return buildDfsTree(0, inorder.length, preorder);
        }

        private TreeNode buildDfsTree(int left, int right, int[] preorder) {

            if (left == right) return null;

            int curValue = preorder[index];
            TreeNode root = new TreeNode(curValue);

            ++index;

            Integer rootIndex = map.get(curValue);

            root.left = buildDfsTree(left, rootIndex, preorder);
            root.right = buildDfsTree(rootIndex + 1, right, preorder);


            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}