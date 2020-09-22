package intermediate_algorithm.linked_list;

import elementary_algorithm.linked_list.ListNode;
import util.CommonUtils;

/**
 * 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvw73v/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = new ListNode(9);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
        System.out.println("{ l1=" + CommonUtils.linkedList2String(l1) + "},\n { l2=" +
                CommonUtils.linkedList2String(l2) + "},\n {result(hasCycle)=" +
                CommonUtils.linkedList2String(new AddTwoNumbers().addTwoNumbers(l1, l2)) + "}");
    }

    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int tmp = 0, record = 0; // record - 进位预留
        ListNode result = new ListNode(0); // 头节点
        ListNode root = result, endNode = null;
        while (l1 != null && l2 != null) {
            tmp = l1.val + l2.val + record;
            if (tmp >= 10) {
                tmp = tmp - 10;
                record = 1;
            } else {
                record = 0;
            }
            root.next = new ListNode(tmp);
            root = root.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        // 循环完毕，可能有某一个链表还没loop完
        endNode = l1 != null ? l1 : l2;
        while (endNode != null) {
            tmp = endNode.val + record;
            if (tmp >= 10) {
                tmp = tmp - 10;
                record = 1;
            } else {
                record = 0;
            }
            root.next = new ListNode(tmp);
            root = root.next;
            endNode = endNode.next;
        }
        if (record == 1) {
            root.next = new ListNode(1);
        }
        return result.next;
    }
}
