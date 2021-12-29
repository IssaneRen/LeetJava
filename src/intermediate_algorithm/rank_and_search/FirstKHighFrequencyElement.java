package intermediate_algorithm.rank_and_search;

import java.util.*;

/**
 * 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 * <p>
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 * <p>
 * 相关标签
 * 数组
 * 哈希表
 * 分治
 * 桶排序
 * 计数
 * 快速选择
 * 排序
 * <p>
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvzpxi/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class FirstKHighFrequencyElement {

    public static void main(String[] args) {
        int[] testArr = new int[]{1, 1, 1, 2, 2, 3, 2, 4, 4, 4, 4, 4, 1, 4};
        int testK = 2;
        // 预期结果 {1,2}
        System.out.println("测试 结果为：" + Arrays.toString((new FirstKHighFrequencyElement()).topKFrequent(testArr, testK)));
    }

    /**
     * 看到题目的第一瞬间，我就想到使用一个类似桶排序的方式。
     * 但是鉴于太久没有复习过，上学时候学的桶排序已经印象不请了。
     * 准确的说，我脑海里是想要实现一个像是有序的Pair数组的感觉
     * <p>
     * 那么第一步的思路讲清楚了，我们就开始第一次尝试吧，第一次写在  topKFrequentTry1 方法里
     *
     * @param nums 提供的数字列表
     * @param k    结果需要前几个元素
     */
    public int[] topKFrequent(int[] nums, int k) {
        return topKFrequentTry3(nums, k);
    }

    public int[] topKFrequentTry1(int[] nums, int k) {
        // 1. 异常容错 - 可以注释掉，节约一步的时间
//        if (nums == null || nums.length < k || k <= 0) {
//            return null;
//        }
        // 2. 维护一个hashMap
        Map<Integer, Integer> timesMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            timesMap.put(nums[i], timesMap.getOrDefault(nums[i], 0) + 1);
        }
        // 3. 排序
        List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(timesMap.entrySet());
        sortedList.sort((lhs, rhs) -> Integer.compare(rhs.getValue(), lhs.getValue()));

        // 4. 结果
        return sortedList.subList(0, k).stream().mapToInt(Map.Entry::getKey).toArray();
    }

    /**
     * try1 的尝试，
     * 执行用时： 17 ms , 在所有 Java 提交中击败了  11.38%  的用户
     * 内存消耗： 41.3 MB  , 在所有 Java 提交中击败了 5.47%  的用户
     * <p>
     * 这个尝试怎么说都有点太慢了，还是要重新想一下，
     * 上一个的思路首先是使用了Map存储次数，遍历了一次数组，复杂度 O(n)  （PS: 这里还有一个hashMap写的操作，应该是2n）
     * 随后又执行了一个O(logn)的排序
     * <p>
     * 想了十几分钟，实在是没想出比较好的方法，先偷看一下答案，（但是看完不能马上写，容易是瞬时记忆） 五点钟我再回来写一下。
     * <p>
     * 在网上看到了优先级队列（最大堆）的方式，尝试一下，
     * <p>
     * 这次跑完，果然快了很多， try2：
     * 执行用时： 13 ms , 在所有 Java 提交中击败了 66.16% 的用户
     * 内存消耗： 41.1 MB , 在所有 Java 提交中击败了 36.98% 的用户
     */
    public int[] topKFrequentTry2(int[] nums, int k) {
        // 1. 异常容错 - 可以注释掉，节约一步的时间
//        if (nums == null || nums.length < k || k <= 0) {
//            return null;
//        }
        // 2. 维护一个hashMap
        Map<Integer, Integer> timesMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            timesMap.put(nums[i], timesMap.getOrDefault(nums[i], 0) + 1);
        }
        // 3. 排序
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((l, r) -> Integer.compare(r.getValue(), l.getValue()));
        maxHeap.addAll(timesMap.entrySet());

        // 4. 结果
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll().getKey();
        }
        return res;
    }

    /**
     * try2 执行完，看到了相关解析的提醒，发现还是有很多优化空间了。
     * 扫到一眼， 使用快速排序的思想，
     *
     * 赶紧合上答案，我先试一下。毕竟快速排序也想不太起来了，太久了。
     * 借着这个机会一起复习一下。
     *
     * 简单google 百度了一下，回忆了一些概念。想起来快速排序就是前后两个指针一次次扫。基本就确定了思路
     *
     * 但是这个try3 跑下来，整体还是差不多
     *
     * 执行用时： 13 ms , 在所有 Java 提交中击败了 66.16% 的用户
     * 内存消耗： 41.1 MB , 在所有 Java 提交中击败了 38.46% 的用户
     */
    public int[] topKFrequentTry3(int[] nums, int k) {
        // 2. 维护一个hashMap
        Map<Integer, Integer> timesMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            timesMap.put(nums[i], timesMap.getOrDefault(nums[i], 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> frequencyList = new ArrayList<>(timesMap.entrySet());
        // 结果
        int[] res = new int[k];
        qSort(frequencyList, 0, frequencyList.size() - 1 , res, 0, k);
        return res;
    }

    public void qSort(List<Map.Entry<Integer, Integer>> values, int start, int end, int[] ret, int retIndex, int k) {
//        int picked = ((end - start + 1) / 2) + start;
//        Collections.swap(values, picked, start);

        int pivot = values.get(start).getValue();
        int index = start; // 持有当前选中的第一个比较位置的index 和 次数
        for (int i = start + 1; i <= end; i++) {
            if (values.get(i).getValue() >= pivot) {
                Collections.swap(values, index + 1, i);
                index++;
            }
        }
        Collections.swap(values, start, index);

        if (k <= index - start) {
            qSort(values, start, index - 1, ret, retIndex, k);
        } else {
            for (int i = start; i <= index; i++) {
                ret[retIndex++] = values.get(i).getKey();
            }
            if (k > index - start + 1) {
                qSort(values, index + 1, end, ret, retIndex, k - (index - start + 1));
            }
        }
    }
}
