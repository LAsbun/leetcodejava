//数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，
//等等。 
//
// 请写一个函数，求任意第n位对应的数字。 
//
// 
//
// 示例 1： 
//
// 输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 输入：n = 11
//输出：0 
//
// 
//
// 限制： 
//
// 
// 0 <= n < 2^31 
// 
//
// 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/ 
// Related Topics 数学 二分查找 👍 221 👎 0


package leetcode.editor.cn;


public class ShuZiXuLieZhongMouYiWeiDeShuZiLcof {
    public static void main(String[] args) {

        Solution solution = new ShuZiXuLieZhongMouYiWeiDeShuZiLcof().new Solution();
        //System.out.println(solution.findNthDigit(8)); // 8
        //System.out.println(solution.findNthDigit(9)); // 9
        //System.out.println(solution.findNthDigit(10)); // 1
        //System.out.println(solution.findNthDigit(11)); // 0
        //System.out.println(solution.findNthDigit(12)); // 1
        //System.out.println(solution.findNthDigit(13)); // 1
        //System.out.println(solution.findNthDigit(14)); // 1
        //System.out.println(solution.findNthDigit(15)); // 2
        //System.out.println(solution.findNthDigit(16)); // 1
        //System.out.println(solution.findNthDigit(19)); // 4
        //System.out.println(solution.findNthDigit(189)); // 1
        //System.out.println(solution.findNthDigit(1000000000)); // 1
        System.out.println(solution.findNthDigit(2147483647)); // 1
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNthDigit(int n) {

            // m
            if (n <= 9) return n;

            n-=9;
            int nSize = -1;

            for (int i = 2; i < 9; i++) {
                int x = 9 * i * powNFast(10, i-1);
                if(n > x){
                    n-=x;
                }else {
                    nSize = i;
                    break;
                }
            }
            if (nSize == -1) nSize = 9;
            n-=1;
            int num = n/nSize+powNFast(10, nSize-1);
            int numMod = n%nSize;

            return String.valueOf(num).charAt(numMod)-'0';



        }

        private int powNFast(int num, int pow) {
            int ans = 1;
            while (pow != 0) {
                if (pow % 2 != 0) ans *= num;
                num *= num;
                pow /= 2;
            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}