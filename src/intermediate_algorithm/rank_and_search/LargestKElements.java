package intermediate_algorithm.rank_and_search;

import java.util.Arrays;

/**
 * 数组中的第K个最大元素
 *给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * 提示：
 *
 * 1 <= k <= nums.length <= 104
 * -104 <= nums[i] <= 104
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvsehe/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 */
public class LargestKElements {
    public static void main(String[] args) {

    }

    /**
     *
     * 这个没啥可说的 我直接使用java自己的s
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 83.10% 的用户
     * 内存消耗： 38.6 MB , 在所有 Java 提交中击败了 77.47% 的用户
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
