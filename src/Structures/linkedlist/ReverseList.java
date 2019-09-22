package Structures.linkedlist;

public class ReverseList {
    public static void main(String[] args) {

    }
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        ListNode t = reverseList(head.next);
        head.next.next = head;
        head.next =null;
        return t;
    }
}
/*
public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null)return head;
//        ListNode temp = ReverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return temp;
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
*
* */