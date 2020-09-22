package intermediate_algorithm.linked_list;

import elementary_algorithm.linked_list.ListNode;
import util.CommonUtils;

/**
 * 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvdwtj/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class OddEvenList {
    public static void main(String[] args) {
//        ListNode root = new ListNode(2);
//        root.next = new ListNode(1);
//        root.next.next = new ListNode(3);
//        root.next.next.next = new ListNode(5);
//        root.next.next.next.next = new ListNode(6);
//        root.next.next.next.next.next = new ListNode(4);
//        root.next.next.next.next.next.next = new ListNode(7);
//        ListNode root = new ListNode(1);
//        root.next = new ListNode(2);
        ListNode root = null;
        System.out.println("{ root=" + CommonUtils.linkedList2String(root) + "},\n {result(oddEvenList)=" +
                CommonUtils.linkedList2String(new OddEvenList().oddEvenList(root)) + "}");
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode evenNode = head, oddNode = head != null ? head.next : null, oddRecord = oddNode;
        while (oddNode != null && oddNode.next != null) {  // odd 奇数 在后面，所以它不为空，则偶数一定不为空
            evenNode.next = oddNode.next;
            evenNode = evenNode.next;
            oddNode.next = oddNode.next.next;
            oddNode = oddNode.next;
        }
        if (evenNode != null) {
            evenNode.next = oddRecord;
        }
        return head;
    }
}
