package Structures.linkedlist;

import java.util.ArrayList;
import java.util.Stack;

public class PrintListFromTailToHead {
    public static void main(String[] args) {

    }
    ArrayList<Integer> list = new ArrayList<>();
    //用递归
    //    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        if(listNode == null)
//            return list;
//        printListFromTailToHead(listNode.next);
//        list.add(listNode.val);
//        return list;
//    }
    //用栈
    public  ArrayList<Integer> print(ListNode listNode){
        Stack<Integer> stack = new Stack<>();
        if(listNode == null)
            return list;
        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
}
