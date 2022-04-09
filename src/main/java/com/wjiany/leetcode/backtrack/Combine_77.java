package com.wjiany.leetcode.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combine_77 {

    @Test
    public void test(){
        combine(4,2).stream().forEach(l->{l.stream().forEach(x->{System.out.print(x+" ");});
            System.out.println();});
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        boolean[] used = new boolean[n];
        backFun(n,0,k,new LinkedList<>(),used,1);
        return res;

    }
    private void backFun(int n,int add ,int k,LinkedList<Integer> list,boolean[] used,int start){
        if(add == k){
            res.add(new ArrayList(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            //if(used[i-1]) continue;
            list.add(i);
           // used[i-1] = true;
            backFun(n,add+1,k,list,used,i+1);
            //used[i-1] = false;
            list.removeLast();
        }
    }
}