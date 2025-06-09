package com.wjiany.leetcode.dp;

import org.junit.Test;

public class FindLength_718 {


    @Test
    public void test(){
        System.out.println(findLength(new int[]{1,2,3,2,1},new int[]{3,2,1,4,7}));
    }
    public int findLength(int[] nums1, int[] nums2) {
        return Math.max(compare(nums1,nums2),compare(nums2,nums1));

    }

    /**
     * [0,0,0,0,1]
     * [1,0,0,0,0]
     * 考虑到上边这种情况，需要正反比较
     * @param nums1
     * @param nums2
     * @return
     */

    public int compare(int[] nums1, int[] nums2){
        int max = 0;
        for(int i = 0;i< nums1.length;i++){
            int step = 0;
            for(int j = 0;j< nums2.length&& i+j<nums1.length;j++){
                if(nums1[i+j] == nums2[j]){
                    step++;
                    max = Math.max(max,step);
                }else{
                    step=0;
                }
            }
        }
        return max;
    }
}