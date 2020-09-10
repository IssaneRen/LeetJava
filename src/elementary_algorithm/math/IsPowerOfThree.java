package elementary_algorithm.math;

/**
 * 3的幂
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 27
 * 输出: true
 * 示例 2:
 *
 * 输入: 0
 * 输出: false
 * 示例 3:
 *
 * 输入: 9
 * 输出: true
 * 示例 4:
 *
 * 输入: 45
 * 输出: false
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 *
 *
 * Java
 *
 *
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnsdi2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class IsPowerOfThree {
    public static void main(String[] args) {
        int number = 1;
        IsPowerOfThree entity = new IsPowerOfThree();
        System.out.println("{number : " + number + "}, {countPrimes:" + entity.isPowerOfThree(number) + "}");
    }

    public boolean isPowerOfThree(int n) {
        int i = 0;
        while (Math.pow(3, i) < n) {
            i++;
        }
        return Math.pow(3, i) == n;
    }
}
