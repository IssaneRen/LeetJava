package elementary_algorithm.design_problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *  
 *
 * 提示：
 *
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnkq37/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MinStack {
    public static void main(String[] args) {
//        MinStack entity = new MinStack();
//        System.out.println("1. [MinStack]");
//        System.out.println("current Array: " + entity.list.toString());
//        entity.push(-2);
//        System.out.println("2. [push -2]");
//        System.out.println("current Array: " + entity.list.toString());
//        entity.push(0);
//        System.out.println("3. [push 0]");
//        System.out.println("current Array: " + entity.list.toString());
//        entity.push(-3);
//        System.out.println("4. [push -3]");
//        System.out.println("current Array: " + entity.list.toString());
//        int getMin = entity.getMin();
//        System.out.println("5. [getMin()]");
//        System.out.println("current Array: " + entity.list.toString() + "; getMin:" + getMin);
//        entity.pop();
//        System.out.println("6. [pop()]");
//        System.out.println("current Array: " + entity.list.toString());
//        int top = entity.top();
//        System.out.println("7. [pop()]");
//        System.out.println("current Array: " + entity.list.toString() + "; pop:" + top);
//        getMin = entity.getMin();
//        System.out.println("8. [getMin()]");
//        System.out.println("current Array: " + entity.list.toString() + "; getMin:" + getMin);
        // 输入：
        //["MinStack",  "push",         "push",         "push",         "top",      "pop",  "getMin",   "pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
        //[[],          [2147483646],   [2147483646],   [2147483647],   [],         [],     [],         [],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
        //输出：
        //[null,        null        ,   null,           null,           2147483647, null,   2147483646,null,2147483646,null,null,2147483647,2147483646,null,-2147483648,-2147483648,null,2147483646]
        //预期结果：
        //[null,        null,           null,           null,           2147483647, null,   2147483646,null,2147483646,null,null,2147483647,2147483647,null,-2147483648,-2147483648,null,2147483647]
        MinStack entity = new MinStack();
        entity.push(2147483646);
        entity.push(2147483646);
        entity.push(2147483647);
        System.out.println("TOP" + entity.top());
        entity.pop();
        System.out.println("getMin" + entity.getMin());
        entity.pop();
        System.out.println("getMin" + entity.getMin());
        entity.pop();
        entity.push(2147483647);
        System.out.println("TOP" + entity.top());
        System.out.println("getMin" + entity.getMin());
        entity.push(-2147483648);
        System.out.println("TOP" + entity.top());
        System.out.println("getMin" + entity.getMin());
        entity.pop();
        System.out.println("getMin" + entity.getMin());
    }

    private static class DoubleLinkedList {
        private DoubleLinkedList last = null;
        private DoubleLinkedList next = null;
        int val, count;

        public static void insert(MinStack s, int val) {
            DoubleLinkedList start = s.minRecord;
            if (start == null) {
                start = new DoubleLinkedList();
                start.val = val;
                start.count = 1;
                s.minRecord = start;
                return;
            }
            while(start != null) {
                if(start.val == val) {
                    start.count++;
                    return;
                }
                if (start.val > val) {
                    DoubleLinkedList temp = new DoubleLinkedList();
                    temp.val = val;
                    temp.count = 1;
                    temp.next = start;
                    if (start.last == null) {
                        start.last = temp;
                        s.minRecord = temp;
                    } else {
                        temp.last = start.last;
                        start.last.next = temp;
                        start.last = temp;
                    }
                    return;
                }
                start = start.next;
            }
        }

        /**
         * 我们假定不会对null做删除，减少一次判断消耗
         * @param val
         */
        public static void delete(MinStack s, int val) {
            DoubleLinkedList start = s.minRecord;
            while(start != null) {
                if(start.val == val) {
                    start.count--;
                    if (start.count == 0) {
                        if (start.last != null) {
                            start.last.next = start.next;
                        } else { // 是第一个
                            s.minRecord = start.next;
                        }
                        if (start.next != null) {
                            start.next.last = start.last;
                        }
                    }
                }
                start = start.next;
            }
        }
    }

    private final List<Integer> list = new ArrayList<>();
    private DoubleLinkedList minRecord = null;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        list.add(x);
        DoubleLinkedList.insert(this, x);
    }

    public void pop() {
        int x = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        DoubleLinkedList.delete(this, x);
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        return minRecord.val;
    }
}
