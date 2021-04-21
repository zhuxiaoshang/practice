package leetcode.beginning2021;

import leetcode.common.ListNode;

/**
*   反转单链表
* @author: zhushang
*
* @create: 2021-04-14 11:17
**/

public class L206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode next = cur.next;//报错next节点，否则会丢失
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
