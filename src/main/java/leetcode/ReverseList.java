package leetcode;

/**
 * 反转链表
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;n2.next=n3;n3.next=n4;n4.next=n5;
        reverseList(n1);

    }

    /**双指针迭代法
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;//这一步很精髓，先把next节点存下来，否则将丢失
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;

    }

    /**递归法
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        if(head == null ||head.next == null) {//终止条件
            return head;
        }
        ListNode cur = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

//    public static ListNode reverse(ListNode head, ListNode next) {
//        head.next = next.next;
//        next.next = head;
//
//    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
