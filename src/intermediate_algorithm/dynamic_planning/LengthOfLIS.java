package intermediate_algorithm.dynamic_planning;

import java.util.Arrays;

/**
 * 最长上升子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列  是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 *   
 * 示例 1：
 *
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 *
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 *
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 *   
 *
 * 提示：
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *   
 *
 * 进阶：
 *
 * 你能将算法的时间复杂度降低到  O(n log(n)) 吗?
 * 相关标签
 * 数组
 * 二分查找
 * 动态规划
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xwhvq3/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LengthOfLIS {
    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};

        System.out.println("LengthOfLIS, 结果=" + ((new LengthOfLIS()).lengthOfLIS(nums)));
    }

    /**
     * 实验1 参考上文的教训，尝试用空间换时间
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int[] lengthMemo = new int[nums.length];
        Arrays.fill(lengthMemo, 1);
        int currentNode, currentMax = 1;
        for (int i = 1; i < nums.length; i++) {
            currentNode = nums[i];
            for (int j = 0; j < i; j++) {
                if (currentNode > nums[j]) {
                    lengthMemo[i] = Math.max(lengthMemo[j] + 1, lengthMemo[i]);
                }
            }
            currentMax = Math.max(currentMax, lengthMemo[i]);
        }
        return currentMax;
    }
}
