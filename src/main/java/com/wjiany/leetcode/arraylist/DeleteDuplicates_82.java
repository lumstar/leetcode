package com.wjiany.leetcode.arraylist;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

///
//  https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
//
//
// /
public class DeleteDuplicates_82 {

    @Test
    public void test(){
        int[] nums = {1,2,3,3,4,4,5};
         ListNode root = new ListNode(nums[0]);
        ListNode other  = root;
        for (int i = 1; i < nums.length; i++) {
            ListNode tm = new ListNode(nums[i]);
            other.next = tm;
            other = tm;
        }
        ListNode p = root;
        while (p!=null){
            System.out.println(p.val);
            p=p.next;
        }
        ListNode node = deleteDuplicates(root);
        p = node;
        while (p!=null){
            System.out.println(p.val);
            p=p.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {

        if(head == null){
            return null;
        }
        Set<Integer> setTem = new HashSet<>();
        Set<Integer> set = new HashSet<>();

        ListNode tem = head;
        while (tem!=null){
            boolean add = setTem.add(tem.val);
            if(!add){
                set.add(tem.val);
            }
            tem = tem.next;
        }
        ListNode node = new ListNode(-200);
        node.next = head;
        ListNode curr = head;
        ListNode pre = node;
        while (curr!= null){
            if(set.contains(curr.val)){
                pre.next = curr.next;
                curr = curr.next;
            }else {
                pre = curr;
                curr = curr.next;
            }
        }

        return node.next;
    }
    

}