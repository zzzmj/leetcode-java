package indi.zmj.leetcode;

/**
 * @author zmj
 * @Description Remove Duplicates from Sorted List
 * @create 2018/9/25
 */
public class RemoveDuplicateFromSortedList_083 {
    /**
     * 这里我的思路是定义两个指针，一个p指针用来迭代整个链表，q指针迭代来跳过相同的数字
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p;
        p = head;
        while (p != null) {
            ListNode q; // 定义q指针迭代
            q = p;
            while (q.next != null && q.val == q.next.val) {
                q = q.next;
            }

            if (q.next == null) {
                p.next = null;
            } else {
                p.next = q.next;
            }
            p = p.next;
        }
        return head;
    }
}
