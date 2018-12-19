package easy._021;

import structure.ListNode;

/**
 * @author zmj
 * @Description 合并两个链表，要熟悉链表的结构和操作
 * @create 2018/9/13
 */

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;

        ListNode head = new ListNode(0);
        ListNode pre = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }

        while (l1 != null) {
            pre.next = l1;
            l1 = l1.next;
            pre = pre.next;
        }

        while (l2 != null) {
            pre.next = l2;
            l2 = l2.next;
            pre = pre.next;
        }

        return head.next;
    }
}
