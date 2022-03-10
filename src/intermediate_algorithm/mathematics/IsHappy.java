package intermediate_algorithm.mathematics;

import java.util.HashMap;
import java.util.Map;

/**
 * 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」 定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= n <= 231 - 1
 * 相关标签
 * 哈希表
 * 数学
 * 双指针
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xw99u7/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class IsHappy {
    public static void main(String[] args) {
        int n = 2;
        System.out.println("IsHappy, isHappy=" + (new IsHappy()).isHappy(n));
    }

    public boolean isHappy(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int tmp, res, tmp2;
        while (n > 1) {
            tmp = n;
            res = 0;
            while (tmp > 0) {
                tmp2 = tmp % 10;
                tmp = tmp / 10;
                res += (tmp2 * tmp2);
            }
            if (map.containsKey(res)) {
                return false;
            }
            n = res;
            map.put(res, 0);
        }
        return true;
    }
}
