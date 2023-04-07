package com.wjiany.leetcode.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets_78 {
    @Test
    public void test(){
        subsets(new int[]{1,2,3}).stream().forEach(l->{l.stream().forEach(x->{System.out.print(x+" ");});
            System.out.println();});
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        res.add(new LinkedList<>());
        for (int i = 1; i <= nums.length; i++) {
            back(nums,0,i,new LinkedList<>(),0);
        }
        return res;
    }
    private void back(int[] nums ,int add,int sum,LinkedList<Integer> list,int start){
        if(add == sum){
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            back(nums,add+1,sum,list,i+1);
            list.removeLast();
        }

    }
}