package com.wjiany.leetcode.Array2P;

import org.junit.Test;

public class ReverseStr_541 {


    @Test
    public void test(){
        String s = "abcdefg";
        System.out.println(reverseStr(s,2));
    }

    public String reverseStr(String s, int k) {

        char[] cs = s.toCharArray();
        for (int i = 0; i < s.length(); i+=2*k) {
            if(i + k <= s.length()){
                reverseString(cs,i,i+k);
                continue;
            }
            reverseString(cs,i, cs.length);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i< cs.length;i++){
            sb.append(cs[i]);
        }
        return sb.toString();


    }

    public void reverseString(char[] s,int m,int k) {
        for (int i = m,j=k-1; i < (k+m)/2; i++,j--) {
            swap(s,i,j);
        }

    }
    public void  swap(char[] s,int i,int j){
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;

    }
}
