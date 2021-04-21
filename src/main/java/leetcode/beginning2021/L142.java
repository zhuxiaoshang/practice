package leetcode.beginning2021;

import leetcode.common.ListNode;

/**
 * @author: zhushang
 * @create: 2021-04-14 14:31
 */
public class L142 {
  public ListNode detectCycle(ListNode head) {
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        ListNode p = head;
        while (p != slow) {
          p = p.next;
          slow = slow.next;
        }
        return p;
      }
    }
    return null;
  }
}
