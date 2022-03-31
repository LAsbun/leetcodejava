//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 贪心 字符串 排序 👍 410 👎 0


package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BaShuZuPaiChengZuiXiaoDeShuLcof {
    public static void main(String[] args) {

        Solution solution = new BaShuZuPaiChengZuiXiaoDeShuLcof().new Solution();
        System.out.println(solution.minNumber(new int[]{10, 2}));
        System.out.println(solution.minNumber(new int[]{3, 30, 34, 5, 9}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minNumber(int[] nums) {
            /**
             * 按照首字母从小到大排序
             */

            List<String> tmp = new ArrayList<>();

            for (int num : nums) {
                tmp.add(String.valueOf(num));
            }

            tmp.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {


                    return (o1 + o2).compareTo(o2 + o1);


                }
            });

            StringBuilder builder = new StringBuilder();

            for (String s : tmp) {
                builder.append(s);
            }

            return builder.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}