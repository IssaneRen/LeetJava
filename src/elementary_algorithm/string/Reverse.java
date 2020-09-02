package elementary_algorithm.string;

/**
 * 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnx13t/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Reverse {
    public static void main(String[] args) {
        int input = -123;
        System.out.println("{input = " + input + "}, {output = " + reverse(input) + "}, {maxValue = " + Integer.MAX_VALUE + "}");
    }

    public static int reverse(int x) {
        boolean positive = true;
        if (x < 0) {
            x = -x;
            positive = false;
        }
        long ans = 0;
        while (x > 0) {
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        if (ans > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) (positive ? ans : -ans);
    }
}
