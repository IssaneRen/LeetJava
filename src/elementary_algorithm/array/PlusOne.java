package elementary_algorithm.array;

import util.CommonUtils;

import java.util.Arrays;

/**
 * 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2cv1c/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] testNum = new int[]{9};

        System.out.println("{result: " + CommonUtils.array2String(plusOne(testNum)) + "};");
    }


    public static int[] plusOne(int[] digits) {
        if (digits == null)
            return new int[]{0};
        boolean stopPlus = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            if (digits[i] > 9) {
                digits[i] = 0;
                continue;
            } else {
                stopPlus = true;
                break;
            }
        }
        if (stopPlus) {
            return digits;
        } else {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, digits.length);
            return result;
        }
    }
}
