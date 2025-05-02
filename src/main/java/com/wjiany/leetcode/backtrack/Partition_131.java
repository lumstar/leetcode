package com.wjiany.leetcode.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Partition_131 {


    @Test
    public void test(){
        List<Integer> list = Arrays.asList(null, 1);
        System.out.println(list);
//        System.out.println(partition("aab"));
    }

    List<List<String>> lists = new ArrayList<>();
    public List<List<String>> partition(String s) {
        rec(s,s.length()-1,1,new LinkedList<String>());
        return lists;
    }


    public void rec(String s,int times,int splitIndex,LinkedList<String> list){
        if(times == 0){
            if(isT(s)){
                list.add(s);
                lists.add(new ArrayList<String>(list));
            }
            return;
        }
        if(splitIndex >s.length()){
            return;

        }

        for(int i = 1;i<= times;i++){
            for(int j = splitIndex;j< s.length();j++){
                String tmp1 =s.substring(0,j);
                if(!isT(tmp1)){
                    continue;
                }
                list.addLast(tmp1);
                String tmp2 =s.substring(j);
                rec(tmp2,i-1,j+1,list);
                list.removeLast();
            }

        }
    }


    public boolean isT(String a){
        int le = a.length();
        if(le== 0) return false;

        for(int i=0;i< le/2;i++){
            if(a.charAt(i) != a.charAt(le-i-1)){
                return false;
            }
        }
        return true;
    }
}
