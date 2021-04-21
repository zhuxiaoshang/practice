package leetcode.beginning2021;

import leetcode.common.ListNode;

/**
 * 判断链表是否有环
 *
 * @author: zhushang
 * @create: 2021-04-14 14:21
 */
public class L141 {
  public boolean hasCycle(ListNode head) {
    // 快慢指针
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        return true;
      }
    }
    return false;
  }
}
