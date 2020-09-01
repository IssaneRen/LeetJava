package elementary_algorithm;

import util.CommonUtils;

import java.util.Arrays;

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2jrse/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] numArray = {0, 1, 6, 3, 12};
        System.out.println("{result: " + CommonUtils.array2String(twoSum(numArray, 9)) + "};");
    }

    public static int[] twoSum(int[] nums, int target) {
//        if (nums == null || nums.length <= 1) {
//            return new int[0];
//        }
        int[] other = Arrays.copyOf(nums, nums.length);
        Arrays.sort(other);
        int[] resultValue = new int[2], resultPosition = new int[2];
        boolean find = false;
        for (int i = 0; i < other.length - 1; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (other[i] + other[j] == target) {
                    resultValue[0] = other[i];
                    resultValue[1] = other[j];
                    find = true;
                    break;
                } else if (other[i] + other[j] < target) {
                    break;
//                } else if (other[i] + other[j] > target) {
//                    continue;
                }
            }
            if (find)
                break;
        }
        boolean firstFind = false, secondFind = false;
        for (int i = 0; i < nums.length; i++) {
            if (!firstFind && nums[i] == resultValue[0]) {
                resultPosition[0] = i;
                firstFind = true;
            } else if (!secondFind && nums[i] == resultValue[1]) {
                resultPosition[1] = i;
                secondFind = true;
            }
            if (firstFind && secondFind)
                break;
        }
        return resultPosition;
    }
}
