package leetcode;

/**
 * 奇偶链表
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 */
public class OddEvenList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        oddEvenList(n1);
    }

    public static ListNode oddEvenList(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode even = head.next;
        ListNode p1 = head;
        ListNode p2 = even;
        while (p1 != null && p2 != null) {
            p1.next = p2.next;
            if(p2.next==null){
                break;
            }
            p1 = p2.next;
            p2.next = p2.next.next;
            p2 = p1.next;
        }
        p1.next = even;
        return head;
    }
}
