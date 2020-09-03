package elementary_algorithm.linked_list;

import util.CommonUtils;

/**
 * 反转链表
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnnhm6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
//        root.next.next = new ListNode(3);
//        root.next.next.next = new ListNode(4);
//        root.next.next.next.next = new ListNode(5);
        System.out.println("{ linked_list=" + CommonUtils.linkedList2String(root) + ", reverse_list=" + CommonUtils.linkedList2String(reverseList(root)) + "}");
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) { //节点数 0 or 1
            return head;
        }
        ListNode tmp1 = head, tmp2 = head.next, tmp3;
        head.next = null;
        while (tmp2.next != null) {
            tmp3 = tmp2.next;
            tmp2.next = tmp1;
            tmp1 = tmp2;
            tmp2 = tmp3;
        }
        tmp2.next = tmp1;
        return tmp2;
    }
}
