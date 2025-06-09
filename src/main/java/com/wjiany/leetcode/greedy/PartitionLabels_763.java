package com.wjiany.leetcode.greedy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels_763 {

    @Test
    public void  test(){
        String s = "12";
        System.out.println(s.substring(0,0));

        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }

    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        int last = 0;
        int right = 0;// 最右边重复
        for(int i = 0;i< s.length();i++){
            Character ch = s.charAt(i);
            int index = s.indexOf(ch,i+1);
            if(index == -1 && i == right){
                list.add(right+1-last);
                right = i+1;
                last = right;
            }else {
                right = Math.max(right,index);
            }
        }
        String d="";
        return list;

    }
}
