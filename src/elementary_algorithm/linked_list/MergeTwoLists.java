package elementary_algorithm.linked_list;

import util.CommonUtils;

/**
 * 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnnbp2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        ListNode root2 = new ListNode(1);
        root2.next = new ListNode(2);
        root2.next.next = new ListNode(5);
        root2.next.next.next = new ListNode(5);
        root2.next.next.next.next = new ListNode(6);
        System.out.println("{ linked_list1=" + CommonUtils.linkedList2String(root)+ ", reverse_list2=" + CommonUtils.linkedList2String(root2) + ", reverse_list=" + CommonUtils.linkedList2String(mergeTwoLists(root, root2)) + "}");
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode root = l1.val < l2.val ? l1 : l2;
        if (l1.val < l2.val) {
            l1 = l1.next;
        } else {
            l2 = l2.next;
        }
        ListNode tmp = root, tmpSwap, tmpSwap2;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                tmp.next = l2;
                return root;
            } else if (l2 == null) {
                tmp.next = l1;
                return root;
            }
            if (l1.val < l2.val) {
                tmpSwap = l1.next;
                tmp.next = l1;
//                tmp.next = new ListNode(l1.val);
                l1 = tmpSwap;
                tmp = tmp.next;
                continue;
            }
            if (l1.val > l2.val) {
                tmpSwap = l2.next;
                tmp.next = l2;
//                tmp.next = new ListNode(l2.val);
                tmp = tmp.next;
                l2 = tmpSwap;
                continue;
            }
            tmpSwap = l1.next;
            tmpSwap2 = l2.next;
            tmp.next = l1;
            tmp.next.next = l2;
//            tmp.next = new ListNode(l1.val);
//            tmp.next.next = new ListNode(l2.val);
            tmp = tmp.next.next;
            l1 = tmpSwap;
            l2 = tmpSwap2;
        }
        return root;
    }
}
