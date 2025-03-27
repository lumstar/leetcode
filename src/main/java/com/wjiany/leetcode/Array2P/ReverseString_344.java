package com.wjiany.leetcode.Array2P;

public class ReverseString_344 {

    public void reverseString(char[] s) {

        for (int i = 0,j=s.length-1; i < s.length/2; i++,j--) {
            swap(s,i,j);
        }

    }
    public void  swap(char[] s,int i,int j){
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;

    }
}
