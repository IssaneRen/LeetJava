package elementary_algorithm.others;

/**
 * 颠倒二进制位
 * 颠倒给定的 32 位无符号整数的二进制位。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: 00000010100101000001111010011100
 * 输出: 00111001011110000010100101000000
 * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 *      因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 * 示例 2：
 *
 * 输入：11111111111111111111111111111101
 * 输出：10111111111111111111111111111111
 * 解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
 *      因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。
 *  
 *
 * 提示：
 *
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
 *  
 *
 * 进阶:
 * 如果多次调用这个函数，你将如何优化你的算法？
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnc5vg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ReverseBits {
    public static void main(String[] args) {
//        int input = 0b11111111111111111111111111111101;
        int input = 0b00000010100101000001111010011100;
        int output = new ReverseBits().reverseBits(input);
        System.out.println("{input: " + input +
                "}, {inputBinary: " + Integer.toBinaryString(input) +
                "}, {output: " + output +
                "}, {outputBinary: " + Integer.toBinaryString(output) + "}");
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 1; i <= 32; i++) {
            result += ((n & 0b1) << (32 - i));
            n = n >>> 1;
            if (n == 0) {
                break;
            }
        }
        return result;
    }
}
