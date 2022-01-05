package intermediate_algorithm.rank_and_search;

import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xv4bbv/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SearchRange {

    public static void main(String[] args) {
//        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
//        int tartget = 6;
//        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
//        int tartget = 8;
        int[] nums = new int[]{};
        int tartget = 0;

        System.out.println("SearchRange, 结果=" + Arrays.toString((new SearchRange()).searchRange(nums, tartget)));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        searchRanges(nums, target, 0, nums.length - 1, result);
        return result;
    }

    public void searchRanges(int[] nums, int target, int start, int end, int[] result) {
        if (start > end - 2) {
            try {
                if ((nums[start] == target && nums[end] != target)) {
                    result[1] = start;
                }
                if (nums[start] != target && nums[end] == target) {
                    result[0] = end;
                }
                return;
            } catch (Exception e) {
                return;
            }
        }
        int middle = start + (end - start) / 2;
        if (nums[middle] < target) {
            searchRanges(nums, target, middle, end, result);
        } else if (nums[middle] > target) {
            searchRanges(nums, target, start, middle, result);
        } else {
            searchRanges(nums, target, middle, end, result);
            searchRanges(nums, target, start, middle, result);
        }
    }

    /**
     * 简单的二分查找 官网方法
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRangeTry2(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
