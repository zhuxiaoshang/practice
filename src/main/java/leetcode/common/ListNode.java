package leetcode.common;
/**
* 链表node
* @author: zhushang
*
* @create: 2021-04-14 11:18
**/

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
