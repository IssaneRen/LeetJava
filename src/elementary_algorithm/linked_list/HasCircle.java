package elementary_algorithm.linked_list;

import util.CommonUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 环形链表
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * <p>
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnwzei/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class HasCircle {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = root;
//        root.next = new ListNode(2);
//        root.next.next = new ListNode(2);
//        root.next.next.next = new ListNode(2);
//        ListNode tmp = new ListNode(1);
//        root.next.next.next.next = tmp;
//        tmp.next = root;
        System.out.println("{ linked_list=" + "CommonUtils.linkedList2String(root)" + ", result(hasCycle)=" + hasCycle2(root) + "}");
    }

    public static boolean hasCycle(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        while (head != null) {
            if (map.containsKey(head.hashCode())) {
                return true;
            }
            map.put(head.hashCode(), 1);
            head = head.next;
        }
        return false;
    }

    public static boolean hasCycle2(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) { // 相遇了
                return true;
            }
        }
        return false;
    }
}
