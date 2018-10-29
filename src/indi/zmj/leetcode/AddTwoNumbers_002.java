package indi.zmj.leetcode;

import java.util.List;

/**
 * @author zmj
 * @Description 给定两个链表，链表中每个节点有一个数字，将两个链表中每个数字对应相加，返回
 *              一个相加过后的链表
 * @create 2018/10/29
 */
public class AddTwoNumbers_002 {
  /**
   * 链表是逆序存储的，所以还是比较容易
   * 一开始踩了坑，没有考虑清楚就开始写代码
   * 首先要考虑l1，l2长度不一的情况
   * 第二，相加之后链表长度有可能更长，所以不能单纯只依靠l1和l2，必须在方法内重新定义一个链表
   * @param l1
   * @param l2
   * @return
   */
  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode pre = head;
    int res = 0, sum = 0;
    while (l1 != null || l2 != null) {
      // 如果链表当前结点为空，就把它当成0进行运算
      int n1 = l1 != null ? l1.val : 0; 
      int n2 = l2 != null ? l2.val : 0;
      
      sum = n1 + n2 + res; // 相加
      pre.next = new ListNode(sum%10);
      pre = pre.next;
      
      res = sum / 10; // 处理进位
      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
    }
    if (res == 1) {
      pre.next = new ListNode(1);
    }
    
    return head.next;
  }
}
