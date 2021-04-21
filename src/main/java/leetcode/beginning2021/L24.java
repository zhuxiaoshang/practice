package leetcode.beginning2021;

import leetcode.common.ListNode;

/**
 * 两两交换链表中的节点
 *
 * @author: zhushang
 * @create: 2021-04-14 11:49
 */
public class L24 {
  // 递归方式
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode next = head.next;
    head.next = swapPairs(next.next);
    next.next = head;
    return next;
  }
  // 迭代遍历
  public ListNode swapPairs_1(ListNode head) {
    ListNode pre = new ListNode(-1);
    pre.next = head;
    ListNode cur = pre;
    while (cur.next != null && cur.next.next != null) {
      ListNode f = cur.next;
      ListNode s = cur.next.next;
      ListNode next = s.next;
      cur.next = s;
      s.next = f;
      f.next = next;
      cur = f;
    }

    return pre.next;
  }
}
