package elementary_algorithm.dynamic_planning;

import util.CommonUtils;

/**
 * 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn3cg3/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] basicArray = new int[] {-2,1,-3,4,-1,2,1,-5,4};
//        int[] basicArray = new int[] {-1};
        MaxSubArray entity = new MaxSubArray();
        System.out.println("{stocks cost: " + CommonUtils.array2String(basicArray) + "}, {maxProfit:" + entity.maxSubArray2(basicArray) + "}");
    }

    /**
     * 最大的子字符串和
     * 我想尝试f(n+1) = max{ f(n), f(n) + nums[n+1], num[n+1]}
     * 但是发现 不对， 因为 数组是要连续的，这里的f(n)可能为sum(1~4) 但是当n = 7的时候，加上nums[7]更大，结果就错了。
     *
     * 打开答案扫了一眼简单的： -- 需要将f(n)定义为 以 n 为结束元素的最大subArray
     * 然后取所有f(n)里最大的
     * 相当于是两个max的感觉
     * 然后这里的f(n)是 max{nums[n], f(n-1)+nums[n]}
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        try {
            int result = nums[0], fn = nums[0];
            for (int i = 1; i < nums.length; i++) {
                fn = Math.max(fn + nums[i], nums[i]);
                result = Math.max(result, fn);
            }
            return result;
        } catch (Exception ex) {
            return 0;
        }
    }

    /**
     * 参考题解，按照分治法，实现一次类似线段树的解决方案
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        try {
            return Status.getMaxSum(nums, 0, nums.length).mSum;
        } catch (Exception ex) {
            return 0;
        }
    }

    /**
     * 结构的中间状态，维护一个线段的 四个sum
     * lSum - 包含左节点的最大和
     * rSum - 包含右节点的最大和
     * mSum - 整个线段的最大和
     * allSum - 整个区间和
     */
    private static class Status {
        private int lSum, rSum, mSum, allSum;

        public Status(int lSum, int rSum, int mSum, int allSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.allSum = allSum;
        }

        /**
         * 获取到某一个区间内的四个max
         * @param end exclusive
         * @return
         */
        public static Status getMaxSum(int[] array, int start, int end) {
            if (start >= end - 1) {
                return new Status(array[start],array[start],array[start],array[start]);
            }
            int middle = (end + start) / 2;
            return pushUp(getMaxSum(array, start, middle), getMaxSum(array, middle, end));
        }

        /**
         * 将左右两个相邻子Status合并，返回整个区间的Status
         * @return
         */
        public static Status pushUp(Status left, Status right) {
            int lSum = Math.max(left.allSum + right.lSum, left.lSum);
            int rSum = Math.max(right.allSum + left.rSum, right.rSum);
            int mSum = Math.max(Math.max(right.mSum, left.mSum), right.lSum + left.rSum);
            int allSum = right.allSum + left.allSum;
            return new Status(lSum, rSum, mSum, allSum);
        }
    }
}
