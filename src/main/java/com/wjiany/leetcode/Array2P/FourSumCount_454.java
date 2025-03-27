package com.wjiany.leetcode.Array2P;

import org.junit.Test;

import java.util.*;

/**
 *   A B    C------ D   定前两个，C和D双指针跑
 */
public class FourSumCount_454 {

    int getMax = 0;
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                map.merge(nums1[i]+nums2[j],1, Integer::sum);
            }
        }

        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                if(map.containsKey(-nums3[i]-nums4[j])){
                    getMax +=map.get(-nums3[i]-nums4[j]);
                }
            }
        }
        return getMax;
    }

    int max = 0;
    public int fourSumCount1(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        List<int[]> list = new ArrayList<>();
        list.add(nums1);
        list.add(nums2);
        list.add(nums3);
        list.add(nums4);
        fourSumCount(list,0,0);
        return max;
    }

    public void fourSumCount(List<int[]> list,int res,int times){
        if(times >list.size()-1){
            if(res == 0){
                max++;
            }
            return;
        }
        int[] nums = list.get(times);
        for(int i =0;i<nums.length;i++){
            fourSumCount(list,res+nums[i],times+1);
        }
    }
}