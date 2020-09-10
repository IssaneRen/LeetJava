package elementary_algorithm.math;

import util.CommonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Fizz Buzz
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 *
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 *
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 *
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 *
 * 示例：
 *
 * n = 15,
 *
 * 返回:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xngt85/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class FizzBuzz {
    public static void main(String[] args) {
        int number = 15;
        FizzBuzz entity = new FizzBuzz();
        System.out.println("{number : " + number + "}, {fizzBuzz:" + entity.fizzBuzz(number) + "}");

    }


    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        int flag; // 0b01 - 3的倍数 0b10 5的倍数
        for (int i = 1; i <= n; i++) {
            flag = 0b00;
            String numberStr = String.valueOf(i);
            int threeCheck = 0;
            for (int j = 0; j < numberStr.length(); j++) {
                threeCheck += (numberStr.charAt(j) - '0');
            }
            if (threeCheck % 3 == 0) {
                flag |= 0b01;
            }
            if ((numberStr.charAt(numberStr.length() - 1) - '0' )% 5 == 0) {
                flag |= 0b10;
            }
            if (flag == 0) {
                result.add(String.valueOf(i));
            } else {
                builder.delete(0, builder.length());
                builder.append((flag & 0b01) != 0 ? "Fizz" : "");
                builder.append((flag & 0b10) != 0 ? "Buzz" : "");
                result.add(builder.toString());
            }
        }
        return result;
    }
}
