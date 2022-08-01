package intermediate_algorithm.mathematics;

/**
 *x 的平方根
 * 给你一个非负整数 x ，计算并返回x的 算术平方根 。
 *
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 *
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：x = 4
 * 输出：2
 * 示例 2：
 *
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 * 
 *
 * 提示：
 *
 * 0 <= x <= 2^31 - 1
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-medium/xwrzwc/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MySqrt {
    public static void main(String[] args) {
        // main函数测试
        MySqrt mySqrt = new MySqrt();
        int testIn = 8;
        System.out.println("MySqrt mySqrt(" + testIn + ")=" + mySqrt.mySqrt(testIn));
    }

    /**
     * 尝试1：
     * 首先是不能够使用已有的函数方法，但是找平方大概率是二分查找类似的方法
     */
    public int mySqrt(int x) {
        int low = 0, high = x, mid = (low + high) / 2;
        long tmp;
        while (low < high) {
            mid = (low + high) / 2;
            tmp = mid * mid;
            if (tmp < x) {
                low = mid - 1;
                continue;
            }
            if (tmp == x) {
                return mid;
            }
            high = mid + 1;
        }
        return mid;
    }
}
