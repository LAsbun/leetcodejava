//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 👍 466 👎 0


package leetcode.editor.cn;


public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof {
    public static void main(String[] args) {

        Solution solution = new ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
        //System.out.println(solution.verifyPostorder(new int[]{1,6,3,2,5}));
        //System.out.println(solution.verifyPostorder(new int[]{1,3,2,6,5}));
        System.out.println(solution.verifyPostorder(new int[]{1,2,3,4,6,5}));
        //System.out.println(solution.verifyPostorder(new int[]{5,4,3,2,1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            /**
             * 思路：
             * 1、后续遍历(左右中)最后一个节点是根节点。
             * 2、根据二叉搜索数定义，大于根节点为右子树。小于根节点为左子树。
             * 3、如果在左子树中发现大于根节点，则return false;
             * 4、依次递归各个子树。
             * 5、递归的节点是只有一个叶子节点即为true.
             */

            return doFind(0, postorder.length-1, postorder);
        }

        private boolean doFind(int left, int right, int[] postorder) {
            if (left >= right) return true;


            int hasLeftIndex = -1;
            // 找左子树.
            for (int i = right - 1; i >= left; i--) {
                if (postorder[i] < postorder[right]) {
                    hasLeftIndex = i;
                    break;
                }
            }
            // 判断左子树是否存在大于根节点的
            if (hasLeftIndex != -1) {
                for (int i = left; i < hasLeftIndex; i++) {
                    if (postorder[i] > postorder[right]) {
                        return false;
                    }
                }
                return doFind(left, hasLeftIndex, postorder) && doFind(hasLeftIndex + 1, right-1, postorder);
            } else {
                return doFind(left, right - 1, postorder);
            }

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}