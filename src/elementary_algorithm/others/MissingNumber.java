package elementary_algorithm.others;

import util.CommonUtils;

/**
 * 缺失数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 *  
 *
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnj4mt/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MissingNumber {
    public static void main(String[] args) {
//        int[] input = new int[]{3,0,1};
//        int[] input = new int[]{9,6,4,2,3,5,7,0,1};
        int[] input = new int[]{0,1,};
        System.out.println("{input: " + CommonUtils.array2String(input) + "}, {output: " + new MissingNumber().missingNumber(input) + "}");

    }

    public int missingNumber(int[] nums) {
        int result = 0, max = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
            if (max < nums[i]) {
                max = nums[i];
            }
            if (min > nums[i]) {
                min = nums[i];
            }
        }
        if (min > 0) {
            return 0;
        }
        // 拿到max 后 找到大于等于它 的 最小 二的整数次幂
        int temp = max, i = 0;
        if (temp <= 1) {
            i = 2;
        } else {
            while (temp != 0) {
                temp = temp >>> 1;
                i++;
            }
        }
        int minTwoPower = 1 << i;
        for (int j = max + 1; j < minTwoPower; j++) {
            result = result ^ j;
        }
        return result == 0 ? max + 1 : result;
    }
}
