//现在你总共有 n 门课需要选，记为 0 到 n-1。 
//
// 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1] 
//
// 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。 
//
// 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。 
//
// 示例 1: 
//
// 输入: 2, [[1,0]] 
//输出: [0,1]
//解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。 
//
// 示例 2: 
//
// 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
//输出: [0,1,2,3] or [0,2,1,3]
//解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
//     因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
// 
//
// 说明: 
//
// 
// 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。 
// 你可以假定输入的先决条件中没有重复的边。 
// 
//
// 提示: 
//
// 
// 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。 
// 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。 
// 
// 拓扑排序也可以通过 BFS 完成。 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序


package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CourseScheduleIi {
    public static void main(String[] args) {

//        int[] order = new CourseScheduleIi().new Solution().findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
//        int[] order = new CourseScheduleIi().new Solution().findOrder(2, new int[][]{{1, 0}});
        int[] order = new CourseScheduleIi().new Solution().findOrder(2, new int[][]{});
        System.out.println(Arrays.toString(order));
    }


    //leetcode submit region begin(Prohibit modification and deletion)


    class Node {
        int input;
        int val;

        List<Node> linkedNode;

        public Node(int val) {
            this.input = 0;
            this.val = val;
            linkedNode = new ArrayList<>();
        }

    }

    class Solution {

        private int index = 0;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            /**
             * 思路： 拓扑排序，BFS/DFS
             */

            Node[] nodes = buildGraph(numCourses, prerequisites);

            int[] ints = dfsFindOrder(numCourses, nodes);

//            int[] ints = bfsFindOrder(numCourses, nodes);
//
//            if (ints.length != numCourses) {
//                return new int[0];
//            }

            return ints;

        }

        /**
         * 构建一张图
         *
         * @param numCourses
         * @param prerequisites
         * @return
         */
        private Node[] buildGraph(int numCourses, int[][] prerequisites) {

            Node[] nodes = new Node[numCourses];


            for (int[] prerequisite : prerequisites) {

                if (nodes[prerequisite[0]] == null) {
                    nodes[prerequisite[0]] = new Node(prerequisite[0]);
                }

                if (nodes[prerequisite[1]] == null) {
                    nodes[prerequisite[1]] = new Node(prerequisite[1]);
                }

                nodes[prerequisite[0]].input += 1;

                nodes[prerequisite[1]].linkedNode.add(nodes[prerequisite[0]]);

            }

            // 因为有些课就是很独立 所以要初始化

            for (int i = 0; i < numCourses; i++) {
                if (nodes[i] == null) {
                    nodes[i] = new Node(i);
                }
            }

            return nodes;


        }

        private int[] bfsFindOrder(int numCourses, Node[] nodes) {
            int[] result = new int[numCourses];

            int index = 0;

            boolean[] visit = new boolean[numCourses];

            LinkedList<Node> queue = new LinkedList<>();

            for (int i = 0; i < nodes.length; i++) {
                if (!visit[i] && nodes[i].input == 0) {
                    visit[i] = true;
                    queue.addLast(nodes[i]);
                }
            }
            while (!queue.isEmpty()) {
                Node pop = queue.pop();
                result[index++] = pop.val;
                for (Node node : pop.linkedNode) {
                    if (!visit[node.val]) {
                        node.input -= 1;

                        if (node.input == 0) {
                            visit[node.val] = true;
                            queue.addLast(node);
                        }
                    }

                }
            }

            if (index != numCourses) {
                return new int[0];
            }

            return result;
        }

        /**
         * dfs 的本质是一直递归
         *
         * @param numCourses
         * @param nodes
         * @return
         */
        private int[] dfsFindOrder(int numCourses, Node[] nodes) {

            index = 0;

            boolean[] visit = new boolean[numCourses];

            int[] result = new int[numCourses];


            for (Node node : nodes) {
                if (!visit[node.val] && node.input == 0) {
                    visit[node.val] = true;
                    result[index++] = node.val;
                    dfsFindOrder(visit, result, node);
                }

            }

            if (index != numCourses) {
                return new int[0];
            }

            return result;
        }

        private void dfsFindOrder(boolean[] visit, int[] result, Node node) {

            for (Node node1 : node.linkedNode) {
                node1.input -= 1;
                if (!visit[node1.val] && node1.input == 0) {
                    visit[node1.val] = true;
                    result[index++] = node1.val;
                    dfsFindOrder(visit, result, node1);
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}