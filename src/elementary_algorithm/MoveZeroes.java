package elementary_algorithm;

import util.CommonUtils;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2ba4i/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] numArray = {0, 1, 0, 3, 12};
        moveZeroes(numArray);
        System.out.println("{result: " + CommonUtils.array2String(numArray) + "};");
    }

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int sequentZeroCount = 0, totalZeroCount = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                sequentZeroCount++;
                totalZeroCount++;
                if (i != 0) {
                    continue;
                } else {
                    System.arraycopy(nums, sequentZeroCount, nums, 0, nums.length - totalZeroCount);
                    break;
                }
            } else if (sequentZeroCount != 0) {
                // 上一个元素是0，这是第一个非0元素，需要复制
                System.arraycopy(nums, i + sequentZeroCount + 1, nums, i + 1, nums.length - 1 - i - totalZeroCount);
            }
            sequentZeroCount = 0; // 找到了非0元素，目前为止的0计数器归零
        }
        //if (totalZeroCount > 0) {
            Arrays.fill(nums, nums.length - totalZeroCount, nums.length, 0);
        //}
    }
}
