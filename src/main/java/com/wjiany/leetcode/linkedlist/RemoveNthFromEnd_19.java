package com.wjiany.leetcode.linkedlist;

import org.junit.Test;

import java.util.List;
import java.util.Stack;

/**
 * 删除链表倒数第N个元素
 */
public class RemoveNthFromEnd_19 {
    @Test
    public void test(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode node = removeNthFromEnd(node1, 2);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        ListNode beforeN_Pre = dummy;
        while (n>0){
            curr = curr.next;
            n--;
        }
        while (curr !=null){
            beforeN_Pre = beforeN_Pre.next;
            curr = curr.next;
        }
        beforeN_Pre.next = beforeN_Pre.next.next;
     return dummy.next;
    }
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode point = dummy;
        while (n>=0){
            n--;
            point = point.next;
        }
        while (point!=null){
            pre = pre.next;
            point = point.next;
        }
        pre.next = pre.next.next;
        return dummy.next;


    }
    @Test
    public void test2(){
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
    public boolean isValid(String s) {

        if(s == null || s.equals("")){
            return true;
        }
        if(s.startsWith(")")|| s.startsWith("]")||s.startsWith("}") || s.length()%2 != 0){
            return false;
        }


            Stack<Character> stack = new Stack<>();
        while(!s.equals("")){

            if(s.startsWith("(") || s.startsWith("[") || s.startsWith("{")){
                stack.push(s.charAt(0));
                s =s.substring(1);
            }else {
                if(stack.isEmpty()) return false;
                Character peek = stack.pop();
                if(s.startsWith(")") && peek == '(' || s.startsWith("]") && peek == '[' || s.startsWith("}") && peek=='{'){
                    s = s.substring(1);
                }else {
                    return false;
                }
            }
        }
        return s.length() == 0 && stack.isEmpty();

    }
}
