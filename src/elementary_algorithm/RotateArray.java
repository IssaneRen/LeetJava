package elementary_algorithm;

import util.CommonUtils;

/**
 * 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        rotate1(nums, 4);
        System.out.println(" {nums: " + CommonUtils.array2String(nums) + "}");
    }

    /**
     * 由官方题解的 <a href=https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode><b>使用环状替换</b></a> 方法
     * 我觉得不需要每次都记录count++以实现效果，因为当 n % k == 0 的时候，一定是会循环 k次的。
     * <p>
     * 谨记不要copy代码，读过一次代码之后再回头来写
     *
     * @param nums
     * @param k
     */
    public static void rotate1(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return; // 若为空或只有一个元素，不旋转
        }
        final int length = nums.length;
        k = k % length; // 若旋转超过一轮，取余
        if (k == 0) {
            return; // k = 0，不旋转
        }
        int minK = k < length / 2 ? k : length - k;
        final int baseLoopTime = length % minK == 0 ? minK : 1;
        int prevPosition = 0, nextPosition = 0, prev, next;
        for (int start = 0; start < baseLoopTime; start++) {
            prevPosition = start;
            prev = nums[prevPosition];
            do {
                nextPosition = (prevPosition + k) % length;
                next = nums[nextPosition];
                nums[nextPosition] = prev;
                prev = next;
                prevPosition = nextPosition;
            } while (prevPosition != start);
        }
    }

    public static void rotate2(int[] nums, int k) {

    }

    public static void rotate3(int[] nums, int k) {

    }
}
