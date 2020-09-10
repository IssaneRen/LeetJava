package elementary_algorithm.design_problem;

import util.CommonUtils;

import java.util.Random;

/**
 * 打乱数组
 * 打乱一个没有重复元素的数组。
 *
 *  
 *
 * 示例:
 *
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn6gq1/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 */
public class ShuffleArray {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3};
        ShuffleArray entity = new ShuffleArray();
        Solution solution = entity.new Solution(array);
        System.out.println("{array : " + CommonUtils.array2String(array) +
                "}, {shuffle:" +CommonUtils.array2String(solution.shuffle()) +
                "}, {reset:" +CommonUtils.array2String(solution.reset()) + "}");
    }


    class Solution {
        int[] array;

        public Solution(int[] nums) {
            this.array = nums;
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return array;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            Random random = new Random();
            boolean[] record = new boolean[array.length];
            int[] newArray = new int[array.length];
            int index;
            for (int i = 0; i < array.length; i++) {
                index = random.nextInt(array.length);
                while (record[index]) {
                    index = random.nextInt(array.length);
                }
                record[index] = true;
                newArray[i] = array[index];
            }
            return newArray;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
}
