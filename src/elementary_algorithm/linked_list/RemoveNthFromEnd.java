package elementary_algorithm.linked_list;

/**
 * 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn2925/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode deletePtr = head, searchPtr = head;
        if (n == 1) {
            if (head.next == null)
                return null;
            searchPtr = head.next;
        } else {
            for (int i = 1; i < n; i++) { // 因为一定n 有效，所以必定从第n个开始
                searchPtr = searchPtr.next;
            }
        }
        while (searchPtr.next != null) { // search还有下一个
            searchPtr = searchPtr.next;
            deletePtr = deletePtr.next;
        }
        if (n == 1) {
            deletePtr.next = null;
        } else {
            deletePtr.val = deletePtr.next.val;
            deletePtr.next = deletePtr.next.next;
        }
        // 基本流程走完，检查一下边界条件
        // a. 如果删除的是head？  ---  ok
        // b. 如果n == 1 即删除尾巴？不行
        return head;
    }
}
