package com.wjiany.leetcode.dp;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class WordBreak_139 {


    @Test
    public void test(){
        System.out.println(wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
    }
/**
 * 感觉集合选元素带排列问题的还是爬楼梯模型好用，思路清晰得一
 *
 * // 爬楼梯思维直接秒
 * // 能否构成字符串s，也即是能否爬上s.size()层楼梯
 * // 每次爬楼梯的方法都在wordDict中
 * // 想要爬上楼梯i，需要遍历wrodDict找能够爬上去的方法，
 * // 但是要确保爬上来的那个台阶也是能够爬到的
 * vector<bool> dp(s.size()+1, false);
 * dp【0】 = true; // 表示空字符串时，楼梯0层肯定能爬上，
 *
 * // 将字符串构造成unordered_set，底层使用hash实现.
 * // 这样在寻找字符串是否在爬楼梯的方法的时候，时间复杂度降为O(1)
 * unordered_set<string> set(wordDict.begin(), wordDict.end());
 *
 * for (int i = 1; i <= s.size(); i++) {// 爬楼梯，对每一层楼梯，更新其能否爬上去
 * // 看是否能够从当前楼梯位置前面的某一台阶爬上来，对于超过当前台阶的，不用考虑
 * // 本质上是能否爬到当前这一台阶，所以肯定是从前面往这一台阶爬，所以j < i
 *
 * j应该表示的是步数吗
 * for (int j = 0; j < i; j++) {
 * // 能够爬上来的条件是，爬上来的方法在set中存在，并且爬上来的位置j处也要保证能够爬上
 * if ((set.find(s.substr(j, i-j)) != set.end()) &&
 * (dp【j】 == true))
 * dp【i】 = true;
 * }
 * }
 *
 * return dp【s.size()】;
 */

    /**
     * 递归超时
     */
    boolean res = false;
    public boolean wordBreak(String s, List<String> wordDict) {
        
        rec(s,0,wordDict);
        return res;
    }
    public void rec(String s,int start,List<String> wordDict){
            if(start == s.length()){
                res = true;
                return;
            }
            String sub = s.substring(start);
            for(int i = 0;i<wordDict.size();i++){
                if(sub.startsWith(wordDict.get(i))){
                    rec(s,start+wordDict.get(i).length(),wordDict);
                }
            }

    }
}