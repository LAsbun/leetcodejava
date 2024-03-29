//斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： 
//
// F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
// 
//
// 给定 N，计算 F(N)。 
//
// 
//
// 示例 1： 
//
// 输入：2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
// 
//
// 示例 2： 
//
// 输入：3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
// 
//
// 示例 3： 
//
// 输入：4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
// 
//
// 
//
// 提示： 
//
// 
// 0 ≤ N ≤ 30 
// 
// Related Topics 数组 
// 👍 153 👎 0


package leetcode.editor.cn;


public class FibonacciNumber {
    public static void main(String[] args) {

        Solution solution = new FibonacciNumber().new Solution();
        System.out.println(solution.fib(0));
        System.out.println(solution.fib(1));
        System.out.println(solution.fib(2));
        System.out.println(solution.fib(3));
        System.out.println(solution.fib(4));
        System.out.println(solution.fib(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fib(int N) {
            if (N < 1) return 0;
            if (N < 3) return 1;
            int a = 1;
            int b = 1;
            int c = 2;
            for (int i = 3; i <= N; i++) {
                c = a + b;
                a = b;
                b = c;

            }
            return c;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}