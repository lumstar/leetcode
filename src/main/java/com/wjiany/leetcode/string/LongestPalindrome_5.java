package com.wjiany.leetcode.string;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class LongestPalindrome_5 {
    @Test
    public void test(){
        //System.out.println(longestPalindrome("asdffdsac"));
        System.out.println(longestPalindrome2("a"));
    }
    public String longestPalindrome2(String s) {
        if(s.length() == 0){
            return "";
        }
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int ans = 0;
        String res = null;
        for (int len=1;len <= length;len++){
            for (int start = 0,end = len+start-1;end<length;start++,end++){
                dp[start][end] =(len==1)||(((len==2)||dp[start+1][end-1])&&(s.charAt(start)==s.charAt(end)));
                if(dp[start][end]&&len>ans){
                    ans = len;
                    res = s.substring(start,end+1);
                }
            }

        }
        return res;
    }

    //动归
    public String longestPalindrome(String s) {
        int length = s.length();
        if(length == 0){
            return "";
        }
        int max = 0;
        String res = null;
        boolean[][] dp = new boolean[length][length];
        for (int len = 1 ; len<= length ; len++){
            for (int i = 0,j=i+len-1 ; j< length ; i++,j++){
                dp[i][j] = (len == 1)||((len==2 || dp[i+1][j-1])&&s.charAt(i)==s.charAt(j));
                if(dp[i][j] && (len>max)){
                    max = len;
                    res = s.substring(i,i+len);
                }
            }
        }
        return res;
    }
    //暴力
    public String longestPalindrome1(String s) {
        int length = s.length();
        if(length == 0){
            return "";
        }
        int max = 0;
        String res= null;
        for(int i = 0 ; i< length ; i++){
            for(int j = i ; j<=length; j++){
                String substring = s.substring(i, j);
                if (isPal(substring)){
                    if(substring.length()>max){
                        res = substring;
                        max = substring.length();
                    }
                }
            }
        }

        return res;
    }
    public boolean isPal(String s){
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length / 2 ;i++ ) {
            if(chars[i] != chars[chars.length-i-1]){
                return false;
            }
        }
        return true;
    }
    public String longestPalindromeaaa(String s) {
        String res = null;

        int ans =0;
        Map<String,Boolean> map = new HashMap<>();
        for(int i = 0;i< s.length();i++){
            for(int j = i;j<= s.length();j++){
                String substring = s.substring(i,j);

                if(isRec(substring,map)){
                    if(substring.length() > ans){
                        res = substring;
                        ans = res.length();
                    }
                }
            }
        }
        return res;

    }
    public String longestPalindromebbb(String s) {
        int ans = 0;
        int begin = 0;

        int length = s.length();
        boolean[][] dp = new boolean[length][length];

        for(int step = 0;step< s.length();step++){
            for(int i = 0;step+i< s.length();i++){
                int len = i+step;
              if(step == 0)  dp[i][len] = true;
              else if(step == 1) dp[i][len] = s.charAt(i) == s.charAt(len);
              else dp[i][len] = s.charAt(i) == s.charAt(len) && dp[i+1][len-1];
              if(dp[i][len] && step+1 >ans){
                  ans = step+1;
                  begin = i;
              }
            }
        }
        return  s.substring(begin,begin+ans);

    }
    public boolean isRec(String s, Map<String ,Boolean> map ){
        if (s.length() == 0) return true;

        if(s.length() ==1 ) return true;
        if(s.length() ==2 ) return s.charAt(0) == s.charAt(1);
//        if(map.containsKey(s)) return map.get(s);
//        map.put(substring,rec);
        return s.charAt(0) == (s.charAt(s.length()-1)) && isRec(s.substring(1, s.length() - 1), map);
    }


    @Test
    public void  test111(){
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println(longestPalindromebbb("babad")
        );
        System.out.println(System.currentTimeMillis()-currentTimeMillis);
    }

}
