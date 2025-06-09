package com.wjiany.leetcode.greedy;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class MonotoneIncreasingDigits_738 {

    @Test
    public void  test(){
        System.out.println(monotoneIncreasingDigits(10));
    }

    public int monotoneIncreasingDigits(int n) {

        while(true){
            String s = n+"";
            int len = s.length();
            if(len == 1){
                return n;
            }else{
                int max = 9;
                boolean order = true;
                String r = "";
                for(int i = s.length()-1;i>=0 ;i--){
                    if(max >= s.charAt(i) -'0'){
                        max = s.charAt(i) -'0';
                        order = true;
                        r+="0";
                    }else{
                        order = false;
                        int newInt = s.charAt(i) -'0';
                        n = Integer.valueOf(s.substring(0,i)+newInt+r);
                        break;
                    }
                }
                if(order){
                    return n;
                }else {
                    n--;
                }
            }
        }
    }
}
