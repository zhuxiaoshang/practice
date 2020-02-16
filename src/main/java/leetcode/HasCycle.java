package leetcode;

public class HasCycle {
    public static void main(String[] args) {

    }
    public static boolean hasCycle(ListNode head) {
        ListNode l1 = head, l2 = head;
        while (null != l1 && l2 != null) {
            ListNode node1 = l1.next;
            ListNode node2 = l2.next;
            if (node1 == null || node2 == null) {
                return false;
            }
            if(node1==node2.next){
                return  true;
            }
            l1 = node1;
            l2 = node2.next;
        }

        return false;
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}
