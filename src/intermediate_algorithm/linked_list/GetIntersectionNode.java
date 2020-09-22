package intermediate_algorithm.linked_list;

import elementary_algorithm.linked_list.ListNode;
import util.CommonUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 *  *
 *  * 如下面的两个链表：
 *  *
 *  *
 *  *
 *  * 在节点 c1 开始相交。
 *  *
 *  *  
 *  *
 *  * 示例 1：
 *  *
 *  *
 *  *
 *  * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 *  * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *  
 *
 * 示例 2：
 *
 *
 *
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *  
 *
 * 示例 3：
 *
 *
 *
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 *  
 *
 * 注意：
 *
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xv02ut/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class GetIntersectionNode {
    public static void main(String[] args) {
//        ListNode l1 = new ListNode(0);
//        l1.next = new ListNode(9);
//        l1.next.next = new ListNode(1);
//        l1.next.next.next = new ListNode(2);
//        l1.next.next.next.next = new ListNode(4);
//        ListNode l2 = new ListNode(3);
//        l2.next = l1.next.next.next;
//        ListNode l1 = new ListNode(4);
//        ListNode l2 = new ListNode(2);
//        l2.next = new ListNode(2);
//        l2.next.next = new ListNode(4);
//        l2.next.next.next = new ListNode(5);
//        l2.next.next.next.next = l1;
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(5);
        l2.next.next.next.next = new ListNode(4);
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(2);
        l1.next.next = l2.next.next;
        System.out.println("{ l1=" + CommonUtils.linkedList2String(l1) + "},\n { l2=" +
                CommonUtils.linkedList2String(l2) + "},\n {result(getIntersectionNode)=" +
                CommonUtils.linkedList2String(new GetIntersectionNode().getIntersectionNode(l1, l2)) + "}");
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> setA = new HashSet<>(), setB = new HashSet<>();
        while (headA != null && headB != null) {
            if (setB.contains(headA)) {
                return headA;
            }
            if (setA.contains(headB)) {
                return headB;
            }
            if (headA == headB) { // 极端case，二者步速一样
                return headA;
            }
            setA.add(headA);
            setB.add(headB);
            headA = headA.next;
            headB = headB.next;
        }
        setA = headA != null ? setB : setA;
        headA = headA != null ? headA : headB;
        while (headA != null) { // 如果有一方已经结束了，就不需要往set里添加了
            if (setA.contains(headA)) {
                return headA;
            }
            headA = headA.next;
        }
        return null;
    }
}
