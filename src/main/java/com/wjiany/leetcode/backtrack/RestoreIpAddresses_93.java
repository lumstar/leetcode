package com.wjiany.leetcode.backtrack;

import org.junit.Test;

import java.util.*;

public class RestoreIpAddresses_93 {

    List<String> list = new ArrayList<>();
    @Test
    public void  test(){
        System.out.println(restoreIpAddresses("1111"));
    }
    public List<String> restoreIpAddresses(String s) {
        rec(s,0,4,new StringBuilder());
        return list;
    }

    public void  rec(String s,int startIndex,int times,StringBuilder res){

        if(times == 0){
            if(res.length()-4 == s.length()){
                String string = res.toString();
                list.add(string.substring(0,string.length()-1));
            }
            return;
        }
        for (int i = startIndex; i < startIndex+3 && i< s.length(); i++) {

            String substring = s.substring(startIndex, i + 1);
            if(!isTrue(substring)){
                continue;
            }
            res.append(substring).append(".");
            rec(s,i+1,times-1,res);
            res.setLength(res.length()-i+startIndex-2);


        }

    }



    public boolean isTrue(String s){
        if(s.length() == 0 || s.length()>3 || s.startsWith("0")&& s.length() >1){
            return false;
        }
        Integer integer = Integer.valueOf(s);
       return integer>=0&& integer<=255;
    }
}
