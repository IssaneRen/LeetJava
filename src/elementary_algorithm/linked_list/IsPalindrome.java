package elementary_algorithm.linked_list;

import util.CommonUtils;

import java.util.Stack;

/**
 * 回文链表
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnv1oc/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class IsPalindrome {
    public static void main(String[] args) {

        ListNode root = new ListNode(1);
//        root.next = new ListNode(2);
//        root.next.next = new ListNode(2);
//        root.next.next.next = new ListNode(2);
//        root.next.next.next.next = new ListNode(1);
        System.out.println("{ linked_list=" + CommonUtils.linkedList2String(root) + ", result(isPalindrome)=" + isPalindrome(root) + "}");
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        boolean even = fast == null; // 偶数个单位
        // 寻找结束，现在慢指针正好在后一半的第一个位置。如果是奇数个，在正中间
        fast = head;
        Stack<Integer> stack = new Stack<>();
        while (fast != slow) {
            stack.push(fast.val);
            fast = fast.next;
        }
        if (!even) {
            slow = slow.next;
        }
        while (slow != null) {
            if (slow.val != stack.pop())
                return false;
            slow = slow.next;
        }
        return true;
    }
}
