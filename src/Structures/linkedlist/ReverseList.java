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
