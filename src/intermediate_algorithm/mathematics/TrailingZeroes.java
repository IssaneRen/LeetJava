package intermediate_algorithm.mathematics;

/**
 * 阶乘后的零
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 *
 * 提示  n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 *
 *   
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：0
 * 解释：3! = 6 ，不含尾随 0
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：1
 * 解释：5! = 120 ，有一个尾随 0
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：0
 *   
 *
 * 提示：
 *
 * 0 <= n <= 104
 *   
 *
 * 进阶：你可以设计并实现对数时间复杂度的算法来解决此问题吗？
 *
 * 相关标签
 * 数学
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xwehi5/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class TrailingZeroes {
    public static void main(String[] args) {
        int n = 3;  // 2*5*10*12*15*20*22*25*30
        System.out.println("trailingZeroes, trailingZeroes=" + (new TrailingZeroes()).trailingZeroes(n));
    }

    public int trailingZeroes(int n) {
        if (n < 5) return 0;
        else if (n < 6) return 1;
        int[] res = new int[n+1];
        int twoNum = 1+2+1, fiveNum = 0;
        res[5] = res[6] = 1;
        int lastRes = 1, tmp;
        for (int i = 7; i <= n; i++) {
            tmp = i;
            while (tmp % 2 == 0) {
                twoNum++;
                tmp /= 2;
            }
            tmp = i;
            while (tmp % 5 == 0) {
                fiveNum++;
                tmp /= 5;
            }
            if (fiveNum != 0 && twoNum != 0) {
                tmp = Math.min(fiveNum, twoNum);
                lastRes += tmp;
                fiveNum -= tmp;
                twoNum -= tmp;
            }
            res[i] = lastRes;
        }

        return res[n];
    }
}
