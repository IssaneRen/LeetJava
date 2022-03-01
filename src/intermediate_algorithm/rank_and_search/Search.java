package intermediate_algorithm.rank_and_search;

import java.util.ArrayList;
import java.util.List;

/**
 * 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：nums = [1], target = 0
 * 输出：-1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -10^4 <= target <= 10^4
 * <p>
 * <p>
 * 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvyz1t/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Search {
    public static void main(String[] args) {
//        int[] nums = new int[]{4,5,6,7,0,1,2};
//        int tartget = 3;
//        int[] nums = new int[]{4,5,6,7,0,1,2};
//        int tartget = 0;
        int[] nums = new int[]{8,1,2,3,4,5,6,7};
        int tartget = 6;

        System.out.println("Search, 结果=" + (new Search()).search2(nums, tartget));
    }

    public int search(int[] nums, int target) {
        List<Integer> a = new ArrayList<>();
        for (int i : nums) {
            a.add(i);
        }
        return a.indexOf(target);
    }

    // 上面那个太作弊了，虽然超过了100%的java耗时
    // 错误： [4,5,6,7,0,1,2] 0

    // 第一次是因为每次判断递增递减用了[0]比较，其实应该用startPos比较
    // 第二次又错了 只有一个的列表没有特殊处理 加上特殊处理

    // 第三次又错了，错误数据[1,3,5] 5
    // 原因是 循环判断要加等于 startPosition <= endPosition 否则最后奇数个会直接跳过

    // 第四次又错了 错误数据[8,1,2,3,4,5,6,7] 6
    // 原因是右侧是递增的 的时候复制了条件，大于小于限制到外面去了。。。。

    public int search2(int[] nums, int target) {
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        int startPosition = 0, endPosition = nums.length - 1, middlePosition = endPosition / 2;
        while (startPosition <= endPosition) {
            if (nums[middlePosition] == target) {
                return middlePosition;
            }
            // 1. 左侧是递增的
            if (nums[middlePosition] > nums[startPosition]) {
                if (nums[middlePosition] > target && nums[startPosition] < target) {
                    endPosition = middlePosition - 1;
                } else if (target == nums[startPosition]) {
                    return startPosition;
                } else {
                    startPosition = middlePosition + 1;
                }
            } else {
                // 2. 右侧是递增的
                if (nums[middlePosition] < target && nums[endPosition] > target) {
                    startPosition = middlePosition + 1;
                } else if (target == nums[endPosition]) {
                    return endPosition;
                }  else {
                    endPosition = middlePosition - 1;
                }
            }
            middlePosition = (startPosition + endPosition) / 2;
        }
        return -1;
    }
}
