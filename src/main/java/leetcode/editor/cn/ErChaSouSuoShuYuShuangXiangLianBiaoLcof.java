//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。 
//
// 
//
// 为了让您更好地理解问题，以下面的二叉搜索树为例： 
//
// 
//
// 
//
// 
//
// 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是
//第一个节点。 
//
// 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。 
//
// 
//
// 
//
// 
//
// 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。 
//
// 
//
// 注意：本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-
//to-sorted-doubly-linked-list/ 
//
// 注意：此题对比原题有改动。 
// Related Topics 栈 树 深度优先搜索 二叉搜索树 链表 二叉树 双向链表 👍 442 👎 0


package leetcode.editor.cn;


import java.util.Stack;

import static leetcode.editor.cn.BalancedBinaryTree.buildNodeFromArgs;

public class ErChaSouSuoShuYuShuangXiangLianBiaoLcof {
    public static void main(String[] args) {

        Solution solution = new ErChaSouSuoShuYuShuangXiangLianBiaoLcof().new Solution();
        System.out.println(solution.treeToDoublyList(buildNodeFromArgs(new Integer[]{4, 2, 5, 1, 3})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
    class Solution {
        public Node treeToDoublyList(Node root) {
            /**
             * 思路，后续遍历，保持前置节点即可.
             */
            Node pre = null;
            Node head = null;

            Stack<Node> stack = new Stack<>();


            if (root != null) {
                stack.push(root);
            } else {
                return root;
            }

            while (!stack.isEmpty()) {

                Node pop = stack.pop();
                if (pop != null) {
                    if (pop.right != null) {
                        stack.push(pop.right);
                    }

                    stack.push(pop);
                    stack.push(null);

                    if (pop.left != null) {
                        stack.push(pop.left);
                    }

                } else {
                    Node pop2 = stack.pop();
                    if (pre == null) {
                        pre = pop2;
                        head = pop2;
                    } else {
                        pop2.left = pre;
                        pre.right = pop2;
                        pre = pop2;
                    }
                }
            }

            // 最后要指向head节点
            pre.right = head;
            head.left = pre;

            return head;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}