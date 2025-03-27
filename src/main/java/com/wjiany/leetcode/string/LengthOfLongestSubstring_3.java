package com.wjiany.leetcode.string;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 当前位置减去开始位置，发现重复后，开始位置向后移动到重复之后
 * 无论这次发现是否已经存在，当前位置和开始位置的差就是大小，
 */
public class LengthOfLongestSubstring_3 {
    @Test
    public void test(){
        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring2(s));
    }
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int length = s.length();
        int ans = 0;
        int tmp = 0;
        for(int i = 0;i<length;i++){
            Character ch = s.charAt(i);
            if(map.get(ch) != null){
                tmp =Math.max(map.get(ch)+1,tmp);
            }
            ans = Math.max(i+1-tmp,ans);
            map.put(ch,i);
        }
        return ans;

    }

    @Test
    public void test11(){
        System.out.println(lengthOfLongestSubstring_oo("aabaab!bb"));

    }
    public int lengthOfLongestSubstring_oo(String s) {

        int max = 0;
        String tmp = "";

        for(int i = 0;i<s.length();i++){
            String substring = s.substring(i, i + 1);
            int indexOf = tmp.indexOf(substring);
            if( indexOf != -1){

                tmp = tmp.substring(indexOf+1)+s.charAt(i);
            }else{
                tmp=tmp+s.charAt(i);
                if(tmp.length() >max){
                    max = tmp.length();
                }
            }
        }
        return max;

    }

    public int lengthOfLongestSubstring_dd(String s) {

       Map<Character,Integer> map = new HashMap<>();

       int ans = 0;

       int  lastMax = 0;//之前最大没有重复的最后一个序列 位置

        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.get(c) != null){
                lastMax =Math.max(map.get(c)+1,lastMax);
            }
            ans = Math.max(i+1-lastMax,ans);
            map.put(c,i);
            }
        return ans;

    }
}
